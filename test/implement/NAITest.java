package implement;

import entities.Pawn;
import entities.Position;
import entities.Wall;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class NAITest {

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
        row = 1;
        try {
            Integer expResult = 4;
            Integer result = NAI.calculateProfit(row);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testCalculateProfitIfInvalidOption() {
        row = 16;
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
        enemyPawn = new Pawn("S", 4, 0, 0, true, true, false, false);
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {"S", " ", " ", " ", " "}};
        try {
            Wall expResult = new Wall(enemyPawn.getRow() - 1, enemyPawn.getCol(), "h");
            Wall result = NAI.blockPath(enemyPawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testBlockPathIfColIsZeroAndCanNotPutWall() {
        enemyPawn = new Pawn("S", 4, 0, 0, true, false, false, false);
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
            Wall expResult = null;
            Wall result = NAI.blockPath(enemyPawn, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testBlockPathIfColIsEight() {
        enemyPawn = new Pawn("S", 4, 8, 0, true, false, true, false);
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "S"}};
        try {
            Wall expResult = new Wall(enemyPawn.getRow() - 1, enemyPawn.getCol() - 1, "h");
            Wall result = NAI.blockPath(enemyPawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testBlockPathIfColIsEightAndCanNotPutWall() {
        enemyPawn = new Pawn("S", 4, 8, 0, true, false, false, false);
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "-", "*", "-"},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", "S"}};
        try {
            Wall expResult = null;
            Wall result = NAI.blockPath(enemyPawn, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testBlockPathIfDefaultIsNotPossible() {
        enemyPawn = new Pawn("S", 4, 4, 0, true, true, true, false);
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", "-", "*", "-", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", "S", " ", " ", " ", " ", " ", " ", " ", " "}};
        try {
            Wall expResult = new Wall(enemyPawn.getRow() - 1, enemyPawn.getCol(), "h");
            Wall result = NAI.blockPath(enemyPawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void secondTestBlockPathIfDefaultIsNotPossible() {
        enemyPawn = new Pawn("S", 4, 2, 0, true, true, true, false);
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {"-", "*", "-", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", "S", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}};
        try {
            Wall expResult = new Wall(enemyPawn.getRow() - 1, enemyPawn.getCol(), "h");
            Wall result = NAI.blockPath(enemyPawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testBlockPathDeafultWall() {
        enemyPawn = new Pawn("S", 4, 2, 0, true, false, true, false);
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", "S", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}};
        try {
            Wall expResult = new Wall(enemyPawn.getRow() - 1, enemyPawn.getCol() - 1, "h");
            Wall result = NAI.blockPath(enemyPawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testBlockPathIfEnemyPawnIsBlocked() {
        enemyPawn = new Pawn("S", 4, 3, 0, false, false, false, false);
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", "-", "*", "-", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", "s", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}};
        try {
            Wall expResult = null;
            Wall result = NAI.blockPath(enemyPawn, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    // ANALYZE QUADRANT TESTS --------------------------------------------------
    @Test
    public void testAnalyzeQuadrantIfRightOrientedWall() {
        pawn = new Pawn("N", 0, 0, 0, false, true, false, false);
        board = new String[][]{
            {"N", " ", " ", " ", " "},
            {"-", "*", "-", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Position expResult = new Position(0, 1);
            Position result = NAI.analyzeQuadrant(pawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeQuadrantIfCanMoveFront() {
        pawn = new Pawn("N", 0, 0, 0, true, false, false, false);
        board = new String[][]{
            {"N", "|", " ", " ", " "},
            {" ", "*", " ", " ", " "},
            {" ", "|", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Position expResult = new Position(1, 0);
            Position result = NAI.analyzeQuadrant(pawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeQuadrantIfCanJumpFront() {
        pawn = new Pawn("N", 0, 0, 0, true, false, false, false);
        board = new String[][]{
            {"N", "|", " ", " ", " "},
            {" ", "*", " ", " ", " "},
            {"S", "|", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Position expResult = new Position(2, 0);
            Position result = NAI.analyzeQuadrant(pawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeQuadrantIfHasToMoveLeft() {
        pawn = new Pawn("N", 2, 1, 0, false, true, true, false);
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", "-", "*", "-", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", " ", " ", " "},
            {" ", " ", "-", "*", "-", " ", " ", " ", " ", " ", " ", " ", " ", "*", "-", "*", "-"},
            {" ", " ", "S", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", "S", " ", " "}};
        try {
            Position expResult = new Position(2, 0);
            Position result = NAI.analyzeQuadrant(pawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeQuadrantIfMoveFrontAndRightIsFalse() {
        pawn = new Pawn("N", 2, 1, 0, false, false, true, false);
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", "N", "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {"-", "*", "-", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", " ", " ", " "},
            {" ", " ", "-", "*", "-", " ", " ", " ", " ", " ", " ", " ", " ", "*", "-", "*", "-"},
            {" ", " ", "S", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", "S", " ", " "}};
        try {
            Position expResult = null;
            Position result = NAI.analyzeQuadrant(pawn, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeQuadrantIfHasToMoveRight() {
        pawn = new Pawn("N", 2, 1, 0, false, true, true, false);
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {"-", "*", "-", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", " ", " ", " "},
            {" ", " ", "-", "*", "-", " ", " ", " ", " ", " ", " ", " ", " ", "*", "-", "*", "-"},
            {" ", " ", "S", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", "S", " ", " "}};
        try {
            Position expResult = new Position(2, 2);
            Position result = NAI.analyzeQuadrant(pawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (Exception e) {
            fail();
        }
    }

    // COL WALL ODD TESTS ------------------------------------------------------
    @Test
    public void testColWallOddIfEven() {
        row = 0;
        col = 0;
        board = new String[][]{
            {"N", " ", " ", " ", " "},
            {"-", "*", "-", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = NAI.ColWallOdd(row, col, board);
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
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", "N", " ", " ", " "},
            {" ", " ", " ", " ", "-", "*", "-", " "}};
        try {
            Boolean expResult = false;
            Boolean result = NAI.ColWallOdd(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testColWallOddIfOdd() {
        row = 0;
        col = 2;
        board = new String[][]{
            {" ", " ", " ", " ", "N", " ", " ", " "},
            {" ", " ", "-", "*", "-", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "}};
        try {
            Boolean expResult = true;
            Boolean result = NAI.ColWallOdd(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void secondTestColWallOddIfOdd() {
        row = 1;
        col = 2;
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", "N", " ", " ", " "},
            {" ", " ", "-", "*", "-", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", "-", "*", "-", " ", " ", " "}};
        try {
            Boolean expResult = true;
            Boolean result = NAI.ColWallOdd(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }
    
    @Test
    public void testColWallOddIfInvalidData() {
        row = 11;
        col = 11;
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", "N", " ", " ", " "}};
        try {
            Boolean expResult = null;
            Boolean result = NAI.ColWallOdd(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }
}
