package utilities;

import models.Message;

public class Information {

    public static void showChallenge(Message message) {
        System.out.println("EVENT: " + message.getEvent());
        System.out.println("Opponent: " + message.getData().getOpponent());
        System.out.println("Challenge id: " + message.getData().getChallenge_id());
        System.out.println(" ----------------- ");
    }

    public static void showTurn(Message message) {
        System.out.println("EVENT: " + message.getEvent());
        System.out.println("DATA: " + "\n"
                + "Player 1: " + message.getData().getPlayer_1() + "\n"
                + "Score 1: " + message.getData().getScore_1() + "\n"
                + "Player 2: " + message.getData().getPlayer_2() + "\n"
                + "Score 2: " + message.getData().getScore_2() + "\n"
                + "Walls: " + message.getData().getWalls() + "\n"
                + "Side: " + message.getData().getSide() + "\n"
                + "Remaining moves: " + message.getData().getRemaining_moves() + "\n"
                + "Turn token: " + message.getData().getTurn_token() + "\n"
                + "Game id: " + message.getData().getGame_id() + "\n");
        System.out.print("");
    }
}
