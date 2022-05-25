package implement;

import entities.Pawn;
import entities.Position;
import entities.Wall;

public class NAI extends Analyzer {

    public static Integer calculateProfit(int row) {
        switch (row + 1) {
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 1000;
            default:
                return null;
        }
    }

    public static void analyzeMovement(Pawn pawn, String[][] board) {
        if (pawn.getRow() + 1 < 8) {
            pawn.setMoveFront(analyzeS(pawn.getRow(), pawn.getCol(), board, "S"));
        } else if (pawn.getRow() + 1 == 8) {
            if (!board[(pawn.getRow() * 2) + 1][pawn.getCol() * 2].equalsIgnoreCase(" ")
                    || board[(pawn.getRow() * 2) + 2][pawn.getCol() * 2].equalsIgnoreCase("S")) {
                pawn.setMoveFront(false);
            } else {
                pawn.setMoveFront(true);
            }
        }
        if (pawn.getCol() + 1 <= 8) {
            pawn.setMoveRight(analyzeE(pawn.getRow(), pawn.getCol(), board, "S"));
        }
        if (pawn.getCol() - 1 >= 0) {
            pawn.setMoveLeft(analyzeW(pawn.getRow(), pawn.getCol(), board, "S"));
        }
    }

    // If the enemy pawn is considered a threat, this function returns the position of the wall that will block it.
    public static Wall blockPath(Pawn enemyPawn, String[][] board) {
        int row = enemyPawn.getRow();
        int col = enemyPawn.getCol();
        Wall wall = null;
        if (enemyPawn.getMoveFront()) {
            wall = new Wall(row - 1, col - 1, "h");
            switch (col) {
                case 0:
                    if (scanNEHorWall(row, col, board) == 0) {
                        return null; // If the return is null, my bot should move a pawn.
                    } else {
                        wall.setCol(col);
                    }
                    break;
                case 8:
                    if (scanNWHorWall(row, col, board) == 0) {
                        return null; // If the return is null, my bot should move a pawn.
                    }
                    break;
                default:
                    if (scanNWHorWall(row, col, board) == 0) {
                        if (scanNEHorWall(row, col, board) == 2) {
                            wall.setCol(col);
                        }
                    }
                    break;
            }
            return wall;
        }
        return wall;
    }

    public static Position analyzeQuadrant(Pawn pawn, String[][] board) {
        Position nextPosition = new Position();
        int row = pawn.getRow();
        int col = pawn.getCol();
        if (pawn.getMoveFront()) {
            nextPosition.setRow(row + 1);
            nextPosition.setCol(col);
            if (row + 1 < 8) {
                if (analyzeJumpS(row, col, board, "S")) {
                    nextPosition.setRow(row + 2);
                }
            }
            return nextPosition;
        } else {
            if (row + 1 == 8 && board[(row * 2) + 2][(col * 2)].equalsIgnoreCase("S")) {
                if (pawn.getMoveRight()) {
                    nextPosition.setRow(row);
                    nextPosition.setCol(col + 1);
                } else if (pawn.getMoveLeft()) {
                    nextPosition.setRow(row);
                    nextPosition.setCol(col - 1);
                }
                return nextPosition;
            }
            if (ColWallOdd(row, col, board)) {
                if (pawn.getMoveLeft()) {
                    nextPosition.setRow(row);
                    nextPosition.setCol(col - 1);
                    if (col - 1 > 0) {
                        if (analyzeJumpW(row, col, board, "S")) {
                            nextPosition.setCol(col - 2);
                        }
                    }
                    return nextPosition;
                }
            } else {
                if (pawn.getMoveRight()) {
                    nextPosition.setRow(row);
                    nextPosition.setCol(col + 1);
                    if (col + 1 < 8) {
                        if (analyzeJumpE(row, col, board, "S")) {
                            nextPosition.setCol(col + 2);
                        }
                    }
                    return nextPosition;
                }
            }
        }
        return null;
    }
    
    // This function is used as the base for deciding which way the pawn should dodge a horizontal wall.
    public static Boolean ColWallOdd(int row, int col, String[][] board) {
        try {
            if (col + 1 <= 8) {
                if (scanSEHorWall(row, col, board) == 1) {
                    return col % 2 != 0;
                }
            }
            if (col - 1 >= 0) {
                if (scanSWHorWall(row, col, board) == 1) {
                    return (col - 1) % 2 != 0;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }
}
