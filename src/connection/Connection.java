package connection;

import java.net.URI;
import java.net.URISyntaxException;
import entities.Pawn;
import ai.NAI;
import ai.SAI;
import java.util.ArrayList;
import java.util.List;
import entities.Position;
import entities.Wall;
import models.Message;
import utilities.Information;
import utilities.ShapeShifter;
import utilities.Event;

public final class Connection {

    private WebSocketClient clientEndPoint;
    private final String root = "wss://4yyity02md.execute-api.us-east-1.amazonaws.com/ws?token=";
    private final String tokenZampe = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjoibHVjYS56YW1wZXJvbml6QGdtYWlsLmNvbSJ9.3PkVXJ34XxzbiAx1Ab-GbvkFtFPextL3hBLQNZ8hcjY";

    private final String url;

    public Connection() throws URISyntaxException {
        url = root.concat(tokenZampe);
        start();
    }

    // Start: manages the messages received by the socket to determine the next action.
    public void start() throws URISyntaxException {
        try {
            clientEndPoint = new WebSocketClient(new URI(url));
            clientEndPoint.addMessageHandler((String msj) -> {
                Message message = ShapeShifter.JSONToObject(msj);
                if (msj.contains(Event.CHALLENGE.getString())) {
                    Information.showChallenge(message);
                    clientEndPoint.sendMessage(ShapeShifter.acceptChallenge(message.getData().getChallenge_id()));
                }
                if (msj.contains(Event.YOUR_TURN.getString())) {
                    Information.showTurn(message);
                    String[][] board = createBoard(message);
                    String[][] pawnsBoard = createPawnsBoard(board);
                    if (message.getData().getSide().equalsIgnoreCase("N")) {
                        sendNAction(message, board, pawnsBoard);
                    } else {
                        sendSAction(message, board, pawnsBoard);
                    }
                }
                if (msj.contains(Event.GAMEOVER.getString())) {
                    System.out.println(ShapeShifter.gameover(message));
                }
                if (msj.contains(Event.GET_USERS.getString())) {
                    System.out.println(msj);
                }
            });
            while (true) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.err.println("InterruptedException exception: " + ex.getMessage());
        } catch (URISyntaxException ex) {
            System.err.println("URISyntaxException exception: " + ex.getMessage());
        }
    }

    public String[][] createBoard(Message message) {
        int counter = 0;
        String[][] board = new String[17][17];
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 17; j++) {
                board[i][j] = String.valueOf(message.getData().getBoard().charAt(counter));
                counter++;
                System.out.print("[" + board[i][j] + "]");
            }
            System.out.println("");
        }
        System.out.println("");
        return board;
    }

    public String[][] createPawnsBoard(String[][] board) {
        // Create a sencondary board to set pawns position.
        String[][] pawnsBoard = new String[9][9];
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 17; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    pawnsBoard[i / 2][j / 2] = board[i][j];
                }
            }
        }
        return pawnsBoard;
    }

    public ArrayList[] createPawns(String[][] pawnsBoard, String idPawn, String idEnemyPawn) {
        ArrayList[] allPawns = new ArrayList[2];
        ArrayList<Pawn> pawns = new ArrayList();
        ArrayList<Pawn> enemyPawns = new ArrayList();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (pawnsBoard[i][j].equalsIgnoreCase(idPawn)) {
                    pawns.add(new Pawn(idPawn, i, j, 0, false, false, false, false));
                } else if (pawnsBoard[i][j].equalsIgnoreCase(idEnemyPawn)) {
                    enemyPawns.add(new Pawn(idEnemyPawn, i, j, 0, false, false, false, false));
                }
            }
        }

        allPawns[0] = pawns;
        allPawns[1] = enemyPawns;
        return allPawns;
    }

    public void sendNAction(Message message, String[][] board, String[][] pawnsBoard) {
        Boolean messageSent = false;
        ArrayList[] allPawns = createPawns(pawnsBoard, "N", "S");
        List<Pawn> pawns = allPawns[0];
        List<Pawn> enemyPawns = allPawns[1];

        pawns.forEach((pawn) -> NAI.analyzeQuadrant(pawn, board));
        pawns.forEach((pawn) -> pawn.setBenefit(NAI.calculateProfit(pawn.getRow())));
        pawns.sort((x, y) -> y.getBenefit().compareTo(x.getBenefit()));

        enemyPawns.forEach((enemyPawn) -> SAI.analyzeQuadrant(enemyPawn, board));
        enemyPawns.forEach((enemyPawn) -> enemyPawn.setBenefit(SAI.calculateProfit(enemyPawn.getRow())));
        enemyPawns.sort((x, y) -> y.getBenefit().compareTo(x.getBenefit()));

        for (Pawn enemyPawn : enemyPawns) {
            if (enemyPawn.getBenefit() > 8) {
                Wall wall = NAI.blockPath(enemyPawn, board);
                if (wall != null) {
                    messageSent = true;
                    clientEndPoint.sendMessage(ShapeShifter.wall(message, wall.getRow(), wall.getCol(), wall.getOrientation()));
                    break;
                }
            }
        }
        if (messageSent == false) {
            for (Pawn pawn : pawns) {
                if ((pawn.getMoveFront() == false && pawn.getMoveRight() == false && pawn.getCol() < 8)
                        || (pawn.getMoveFront() == false && pawn.getMoveLeft() == false && pawn.getCol() > 0)) {
                    continue;
                }

                Position nextPosition = NAI.analyzeQuadrant(pawn, board);
                if (nextPosition != null) {
                    clientEndPoint.sendMessage(ShapeShifter.move(message,
                            pawn.getRow(), pawn.getCol(), nextPosition.getRow(), nextPosition.getCol()));
                    break;
                }
            }
        }
    }

    public void sendSAction(Message message, String[][] board, String[][] pawnsBoard) {
        Boolean messageSent = false;
        ArrayList[] allPawns = createPawns(pawnsBoard, "S", "N");
        List<Pawn> pawns = allPawns[0];
        List<Pawn> enemyPawns = allPawns[1];

        pawns.forEach((pawn) -> SAI.analyzeQuadrant(pawn, board));
        pawns.forEach((pawn) -> pawn.setBenefit(SAI.calculateProfit(pawn.getRow())));
        pawns.sort((x, y) -> y.getBenefit().compareTo(x.getBenefit()));

        enemyPawns.forEach((enemyPawn) -> NAI.analyzeQuadrant(enemyPawn, board));
        enemyPawns.forEach((enemyPawn) -> enemyPawn.setBenefit(NAI.calculateProfit(enemyPawn.getRow())));
        enemyPawns.sort((x, y) -> y.getBenefit().compareTo(x.getBenefit()));

        for (Pawn enemyPawn : enemyPawns) {
            if (enemyPawn.getBenefit() > 8) {
                Wall wall = SAI.blockPath(enemyPawn, board);
                if (wall != null) {
                    messageSent = true;
                    clientEndPoint.sendMessage(ShapeShifter.wall(message, wall.getRow(), wall.getCol(), wall.getOrientation()));
                    break;
                }
            }
        }
        if (messageSent == false) {
            for (Pawn pawn : pawns) {
                if ((pawn.getMoveFront() == false && pawn.getMoveRight() == false && pawn.getCol() < 8)
                        || (pawn.getMoveFront() == false && pawn.getMoveLeft() == false && pawn.getCol() > 0)) {
                    continue;
                }

                Position nextPosition = SAI.analyzeQuadrant(pawn, board);
                if (nextPosition != null) {
                    clientEndPoint.sendMessage(ShapeShifter.move(message,
                            pawn.getRow(), pawn.getCol(), nextPosition.getRow(), nextPosition.getCol()));
                    break;
                }
            }
        }
    }
}
