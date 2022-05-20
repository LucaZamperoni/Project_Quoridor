package ai;

import entities.Pawn;
import entities.Position;
import entities.Wall;
import org.junit.Test;
import static org.junit.Assert.*;

public class SAITest {

    @Test
    public void testCalculateProfit() {
        int row = 2;
        try {
            Integer expResult = 128;
            Integer result = SAI.calculateProfit(row);
            assertEquals(expResult, result);
        } catch (NullPointerException e) {
            fail("Test: CalculateBenefit threw an exception.");
        }
        row = 4;
        try {
            Integer expResult = 32;
            Integer result = SAI.calculateProfit(row);
            assertEquals(expResult, result);
        } catch (NullPointerException e) {
            fail("Test: CalculateBenefit threw an exception.");
        }
    }

    @Test
    public void testBlockPath() {
        Pawn enemyPawn = new Pawn("N", 3, 0, 0, true, true, false, false);
        String[][] board = new String[][]{
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
        } catch (NullPointerException e) {
            fail("Test: blockPath threw an exception.");
        }
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
        } catch (NullPointerException e) {
            fail("Test: blockPath threw an exception.");
        }
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
        } catch (NullPointerException e) {
            fail("Test: blockPath threw an exception.");
        }
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
        } catch (NullPointerException e) {
            fail("Test: blockPath threw an exception.");
        }
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
        } catch (NullPointerException e) {
            fail("Test: blockPath threw an exception.");
        }
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
        } catch (NullPointerException e) {
            fail("Test: blockPath threw an exception.");
        }
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
        } catch (NullPointerException e) {
            fail("Test: blockPath threw an exception.");
        }
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
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}};
        try {
            Wall expResult = null;
            Wall result = SAI.blockPath(enemyPawn, board);
            assertEquals(expResult, result);
        } catch (NullPointerException e) {
            fail("Test: blockPath threw an exception.");
        }
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "*", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", "N", " ", " "},
            {" ", " ", "-", "*", "-", " ", " ", " ", " ", " ", " ", " ", " ", "*", "-", "*", "-"},
            {" ", " ", "S", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", "S", " ", " "}};
        try {
            Wall expResult = null;
            Wall result = SAI.blockPath(enemyPawn, board);
            assertEquals(expResult, result);
        } catch (NullPointerException e) {
            fail("Test: blockPath threw an exception.");
        }
    }

    @Test
    public void testAnalyzeQuadrant() {
        Pawn pawn = new Pawn("S", 4, 0, 0, false, true, false, false);
        String[][] board = new String[][]{
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
        } catch (NullPointerException e) {
            fail("Test: analizeQuadrant threw an exception.");
        }
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
        } catch (NullPointerException e) {
            fail("Test: analizeQuadrant threw an exception.");
        }
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
        } catch (NullPointerException e) {
            fail("Test: analizeQuadrant threw an exception.");
        }
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
        } catch (NullPointerException e) {
            fail("Test: analizeQuadrant threw an exception.");
        }
        pawn = new Pawn("S", 2, 1, 0, false, false, true, false);
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {"-", "*", "-", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", "S", "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", " ", " ", " "},
            {" ", " ", "-", "*", "-", " ", " ", " ", " ", " ", " ", " ", " ", "*", "-", "*", "-"},
            {" ", " ", "S", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", "S", " ", " "}};
        try {
            Position expResult = null;
            Position result = SAI.analyzeQuadrant(pawn, board);
            assertEquals(expResult, result);
        } catch (NullPointerException e) {
            fail("Test: analizeQuadrant threw an exception.");
        }
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
        } catch (NullPointerException e) {
            fail("Test: analizeQuadrant threw an exception.");
        }
    }

    @Test
    public void testColWallOdd() {
        int row = 1;
        int col = 0;
        String[][] board = new String[][]{
            {" ", " ", " ", " ", " "},
            {"-", "*", "-", " ", " "},
            {"S", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = SAI.ColWallOdd(row, col, board);
            assertEquals(expResult, result);
        } catch (NullPointerException e) {
            fail("Test: ColWallOdd threw an exception.");
        }
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
        } catch (NullPointerException e) {
            fail("Test: ColWallOdd threw an exception.");
        }
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
        } catch (NullPointerException e) {
            fail("Test: ColWallOdd threw an exception.");
        }
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
        } catch (NullPointerException e) {
            fail("Test: ColWallOdd threw an exception.");
        }
    }
}
