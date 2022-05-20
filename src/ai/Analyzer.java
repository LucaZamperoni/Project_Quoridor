package ai;

public class Analyzer {

    public static Boolean analyzeN(int row, int col, String[][] board, String enemyPawn) {
        return board[(row * 2) - 1][col * 2].equalsIgnoreCase(" ")
                && (board[(row * 2 - 2)][col * 2].equalsIgnoreCase(" ")
                || board[(row * 2 - 2)][col * 2].equalsIgnoreCase(enemyPawn));
    }

    public static Boolean analyzeJumpN(int row, int col, String[][] board, String enemyPawn) {
        return board[(row * 2) - 2][col * 2].equalsIgnoreCase(enemyPawn)
                && board[(row * 2) - 3][(col * 2)].equalsIgnoreCase(" ")
                && board[(row * 2) - 4][col * 2].equalsIgnoreCase(" ");
    }

    public static Boolean analyzeS(int row, int col, String[][] board, String enemyPawn) {
        return board[(row * 2) + 1][col * 2].equalsIgnoreCase(" ")
                && (board[(row * 2 + 2)][col * 2].equalsIgnoreCase(" ")
                || board[(row * 2 + 2)][col * 2].equalsIgnoreCase(enemyPawn));
    }

    public static Boolean analyzeJumpS(int row, int col, String[][] board, String enemyPawn) {
        return board[(row * 2) + 2][col * 2].equalsIgnoreCase(enemyPawn)
                && board[(row * 2) + 3][(col * 2)].equalsIgnoreCase(" ")
                && board[(row * 2) + 4][col * 2].equalsIgnoreCase(" ");
    }

    public static Boolean analyzeE(int row, int col, String[][] board, String enemyPawn) {
        return board[(row * 2)][(col * 2) + 1].equalsIgnoreCase(" ")
                && (board[(row * 2)][(col * 2) + 2].equalsIgnoreCase(" ")
                || board[(row * 2)][(col * 2) + 2].equalsIgnoreCase(enemyPawn));
    }

    public static Boolean analyzeJumpE(int row, int col, String[][] board, String enemyPawn) {
        return board[(row * 2)][(col * 2) + 2].equalsIgnoreCase(enemyPawn)
                && board[(row * 2)][(col * 2) + 3].equalsIgnoreCase(" ")
                && board[(row * 2)][(col * 2) + 4].equalsIgnoreCase(" ");
    }

    public static Boolean analyzeW(int row, int col, String[][] board, String enemyPawn) {
        return board[(row * 2)][(col * 2) - 1].equalsIgnoreCase(" ")
                && (board[(row * 2)][(col * 2) - 2].equalsIgnoreCase(" ")
                || board[(row * 2)][(col * 2) - 2].equalsIgnoreCase(enemyPawn));
    }

    public static Boolean analyzeJumpW(int row, int col, String[][] board, String enemyPawn) {
        return board[(row * 2)][(col * 2) - 2].equalsIgnoreCase(enemyPawn)
                && board[(row * 2)][(col * 2) - 3].equalsIgnoreCase(" ")
                && board[(row * 2)][(col * 2) - 4].equalsIgnoreCase(" ");
    }

    public static int scanNEHorWall(int row, int col, String[][] board) {
        if (board[(row * 2) - 1][(col * 2) + 1].equalsIgnoreCase("*")) {
            if (board[(row * 2) - 1][(col * 2)].equalsIgnoreCase("-")) {
                if (board[(row * 2) - 1][(col * 2) + 2].equalsIgnoreCase("-")) {
                    return 1;
                }
            }
        }
        if (board[(row * 2) - 1][(col * 2) + 1].equalsIgnoreCase(" ")) {
            if (board[(row * 2) - 1][(col * 2)].equalsIgnoreCase(" ")) {
                if (board[(row * 2) - 1][(col * 2) + 2].equalsIgnoreCase(" ")) {
                    return 2;
                }
            }
        }
        return 0;
    }

    public static int scanNWHorWall(int row, int col, String[][] board) {
        if (board[(row * 2) - 1][(col * 2) - 1].equalsIgnoreCase("*")) {
            if (board[(row * 2) - 1][(col * 2)].equalsIgnoreCase("-")) {
                if (board[(row * 2) - 1][(col * 2) - 2].equalsIgnoreCase("-")) {
                    return 1;
                }
            }
        }
        if (board[(row * 2) - 1][(col * 2) - 1].equalsIgnoreCase(" ")) {
            if (board[(row * 2) - 1][(col * 2)].equalsIgnoreCase(" ")) {
                if (board[(row * 2) - 1][(col * 2) - 2].equalsIgnoreCase(" ")) {
                    return 2;
                }
            }
        }
        return 0;
    }

    public static int scanSEHorWall(int row, int col, String[][] board) {
        if (board[(row * 2) + 1][(col * 2) + 1].equalsIgnoreCase("*")) {
            if (board[(row * 2) + 1][(col * 2)].equalsIgnoreCase("-")) {
                if (board[(row * 2) + 1][(col * 2) + 2].equalsIgnoreCase("-")) {
                    return 1;
                }
            }
        }
        if (board[(row * 2) + 1][(col * 2) + 1].equalsIgnoreCase(" ")) {
            if (board[(row * 2) + 1][(col * 2)].equalsIgnoreCase(" ")) {
                if (board[(row * 2) + 1][(col * 2) + 2].equalsIgnoreCase(" ")) {
                    return 2;
                }
            }
        }
        return 0;
    }

    public static int scanSWHorWall(int row, int col, String[][] board) {
        if (board[(row * 2) + 1][(col * 2) - 1].equalsIgnoreCase("*")) {
            if (board[(row * 2) + 1][(col * 2)].equalsIgnoreCase("-")) {
                if (board[(row * 2) + 1][(col * 2) - 2].equalsIgnoreCase("-")) {
                    return 1;
                }
            }
        }
        if (board[(row * 2) + 1][(col * 2) - 1].equalsIgnoreCase(" ")) {
            if (board[(row * 2) + 1][(col * 2)].equalsIgnoreCase(" ")) {
                if (board[(row * 2) + 1][(col * 2) - 2].equalsIgnoreCase(" ")) {
                    return 2;
                }
            }
        }
        return 0;
    }
}
