package implement;

import entities.Pawn;
import entities.Position;
import entities.Wall;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class SAITest {

    private int row;
    private int col;
    private Pawn enemyPawn;
    private Pawn pawn;
    private String[][] board;

    @Before
    public void init() {
        row = 0;
        col = 0;
        enemyPawn = null;
        pawn = null;
        board = null;
    }

    // CALCULATE PROFIT TESTS --------------------------------------------------
    @Test
    public void testCalculateProfitIfValidOption() {
        row = 2;
        try {
            Integer expResult = 128;
            Integer result = SAI.calculateProfit(row);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testCalculateProfitIfInvalidOption() {
        row = 24;
        try {
            Integer expResult = null;
            Integer result = NAI.calculateProfit(row);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    // BLOCK PATH TESTS --------------------------------------------------------
    @Test
    public void testBlockPathIfColIsZero() {
        enemyPawn = new Pawn("N", 3, 0, 0, true, true, false, false);
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {"N", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Wall expResult = new Wall(enemyPawn.getRow(), enemyPawn.getCol(), "h");
            Wall result = SAI.blockPath(enemyPawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testBlockPathIfColIsZeroAndCanNotPutWall() {
        enemyPawn = new Pawn("N", 3, 0, 0, true, false, false, false);
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {"N", "|", " ", " ", " "},
            {" ", "*", " ", " ", " "},
            {" ", "|", " ", " ", " "}};
        try {
            Wall expResult = null;
            Wall result = SAI.blockPath(enemyPawn, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testBlockPathIfColIsEight() {
        enemyPawn = new Pawn("N", 3, 8, 0, true, false, true, false);
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "N"},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}};
        try {
            Wall expResult = new Wall(enemyPawn.getRow(), enemyPawn.getCol() - 1, "h");
            Wall result = SAI.blockPath(enemyPawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testBlockPathIfColIsEightAndCanNotPutWall() {
        enemyPawn = new Pawn("N", 3, 8, 0, true, false, false, false);
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "-", "*", "-"},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", "N"},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", " "}};
        try {
            Wall expResult = null;
            Wall result = SAI.blockPath(enemyPawn, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testBlockPathIfDefaultIsNotPossible() {
        enemyPawn = new Pawn("N", 3, 4, 0, true, true, true, false);
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", "N", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", "-", "*", "-", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}};
        try {
            Wall expResult = new Wall(enemyPawn.getRow(), enemyPawn.getCol(), "h");
            Wall result = SAI.blockPath(enemyPawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void secondTestBlockPathIfDefaultIsNotPossible() {
        enemyPawn = new Pawn("N", 3, 2, 0, true, true, true, false);
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", "N", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {"-", "*", "-", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}};
        try {
            Wall expResult = new Wall(enemyPawn.getRow(), enemyPawn.getCol(), "h");
            Wall result = SAI.blockPath(enemyPawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testBlockPathDeafultWall() {
        enemyPawn = new Pawn("N", 3, 2, 0, true, true, true, false);
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", "N", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}};
        try {
            Wall expResult = new Wall(enemyPawn.getRow(), enemyPawn.getCol() - 1, "h");
            Wall result = SAI.blockPath(enemyPawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testBlockPathIfEnemyPawnIsBlocked() {
        enemyPawn = new Pawn("N", 3, 1, 0, false, true, true, false);
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {"-", "*", "-", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}};
        try {
            Wall expResult = null;
            Wall result = SAI.blockPath(enemyPawn, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    // ANALYZE QUADRANT TESTS --------------------------------------------------
    @Test
    public void testAnalyzeQuadrantIfRightOrientedWall() {
        pawn = new Pawn("S", 4, 0, 0, false, true, false, false);
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {"-", "*", "-", " ", " "},
            {"S", " ", " ", " ", " "}};
        try {
            Position expResult = new Position(4, 1);
            Position result = SAI.analyzeQuadrant(pawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeQuadrantIfCanMoveFront() {
        pawn = new Pawn("S", 4, 0, 0, true, false, false, false);
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", "|", " ", " ", " "},
            {" ", "*", " ", " ", " "},
            {"S", "|", " ", " ", " "}};
        try {
            Position expResult = new Position(3, 0);
            Position result = SAI.analyzeQuadrant(pawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeQuadrantIfCanJumpFront() {
        pawn = new Pawn("S", 4, 0, 0, true, false, false, false);
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {"N", "|", " ", " ", " "},
            {" ", "*", " ", " ", " "},
            {"S", "|", " ", " ", " "}};
        try {
            Position expResult = new Position(2, 0);
            Position result = SAI.analyzeQuadrant(pawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeQuadrantIfHasToMoveLeft() {
        pawn = new Pawn("S", 2, 1, 0, false, true, true, false);
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", "-", "*", "-", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", "S", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}};
        try {
            Position expResult = new Position(2, 0);
            Position result = SAI.analyzeQuadrant(pawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeQuadrantIfMoveFrontAndRightIsFalse() {
        pawn = new Pawn("S", 2, 1, 0, false, false, true, false);
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {"-", "*", "-", "|", " ", " ", " ", " ", " ", "N", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", "S", "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "S", " ", " "}};
        try {
            Position expResult = null;
            Position result = SAI.analyzeQuadrant(pawn, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeQuadrantIfHasToMoveRight() {
        pawn = new Pawn("S", 2, 1, 0, false, true, true, false);
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {"-", "*", "-", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", "S", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {"-", "*", "-", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", "-", "*", "-"},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", "S", " ", " "}};
        try {
            Position expResult = new Position(2, 2);
            Position result = SAI.analyzeQuadrant(pawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (Exception e) {
            fail();
        }
    }

    // COL WALL ODD TESTS ------------------------------------------------------
    @Test
    public void testColWallOddIfEven() {
        row = 1;
        col = 0;
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {"-", "*", "-", " ", " "},
            {"S", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = SAI.ColWallOdd(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void secondTestColWallOddIfEven() {
        row = 2;
        col = 2;
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", "-", "*", "-", " "},
            {" ", " ", " ", " ", "S", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = SAI.ColWallOdd(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testColWallOddIfOdd() {
        row = 1;
        col = 2;
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", "-", "*", "-", " ", " ", " "},
            {" ", " ", " ", " ", "S", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "}};
        try {
            Boolean expResult = true;
            Boolean result = SAI.ColWallOdd(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void secondTestColWallOddIfOdd() {
        row = 2;
        col = 2;
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", "|", " ", " "},
            {" ", " ", "-", "*", "-", "*", " ", " "},
            {" ", " ", " ", " ", "S", "|", " ", " "},
            {" ", " ", "-", "*", "-", " ", " ", " "}};
        try {
            Boolean expResult = true;
            Boolean result = SAI.ColWallOdd(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testColWallOddIfInvalidData() {
        row = 34;
        col = 2;
        board = new String[][]{
            {" ", " ", "|", " ", " ", " ", " ", " "},
            {" ", " ", "*", " ", " ", " ", " ", " "},
            {" ", " ", "|", " ", "S", " ", " ", " "}};
        try {
            Boolean expResult = null;
            Boolean result = NAI.ColWallOdd(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }
}
