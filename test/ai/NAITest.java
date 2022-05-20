package ai;

import entities.Pawn;
import entities.Position;
import entities.Wall;
import org.junit.Test;
import static org.junit.Assert.*;

public class NAITest {

    @Test
    public void testCalculateProfit() {
        int row = 1;
        try {
            Integer expResult = 4;
            Integer result = NAI.calculateProfit(row);
            assertEquals(expResult, result);
        } catch (NullPointerException e) {
            fail("Test: CalculateBenefit threw an exception.");
        }
        row = 4;
        try {
            Integer expResult = 32;
            Integer result = NAI.calculateProfit(row);
            assertEquals(expResult, result);
        } catch (NullPointerException e) {
            fail("Test: CalculateBenefit threw an exception.");
        }
    }

    @Test
    public void testBlockPath() {
        Pawn enemyPawn = new Pawn("S", 4, 0, 0, true, false, false, false);
        String[][] board = new String[][]{
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
            {" ", "|", " ", " ", " "},
            {" ", "*", " ", " ", " "},
            {"S", "|", " ", " ", " "}};
        try {
            Wall expResult = null;
            Wall result = NAI.blockPath(enemyPawn, board);
            assertEquals(expResult, result);
        } catch (NullPointerException e) {
            fail("Test: blockPath threw an exception.");
        }
        enemyPawn = new Pawn("S", 4, 8, 0, true, false, false, false);
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
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", "S"}};
        try {
            Wall expResult = null;
            Wall result = NAI.blockPath(enemyPawn, board);
            assertEquals(expResult, result);
        } catch (NullPointerException e) {
            fail("Test: blockPath threw an exception.");
        }
        enemyPawn = new Pawn("S", 4, 4, 0, true, false, false, false);
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
        } catch (NullPointerException e) {
            fail("Test: blockPath threw an exception.");
        }
        enemyPawn = new Pawn("S", 4, 2, 0, true, false, false, false);
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
            {" ", " ", " ", " ", " ", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", "*", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", "S", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}};
        try {
            Wall expResult = new Wall(enemyPawn.getRow() - 1, enemyPawn.getCol() - 1, "h");
            Wall result = NAI.blockPath(enemyPawn, board);
            assertEquals(expResult.toString(), result.toString());
        } catch (NullPointerException e) {
            fail("Test: blockPath threw an exception.");
        }
        enemyPawn = new Pawn("S", 5, 3, 0, false, false, false, false);
        board = new String[][]{
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {"-", "*", "-", " ", "-", "*", "-", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", "S", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}};
        try {
            Wall expResult = null;
            Wall result = NAI.blockPath(enemyPawn, board);
            assertEquals(expResult, result);
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
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {"-", "*", "-", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", "S", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}};
        try {
            Wall expResult = null;
            Wall result = NAI.blockPath(enemyPawn, board);
            assertEquals(expResult, result);
        } catch (NullPointerException e) {
            fail("Test: blockPath threw an exception.");
        }
    }

    @Test
    public void testAnalyzeQuadrant() {
        Pawn pawn = new Pawn("N", 0, 0, 0, false, true, false, false);
        String[][] board = new String[][]{
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
        } catch (NullPointerException e) {
            fail("Test: analizeQuadrant threw an exception.");
        }
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
        } catch (NullPointerException e) {
            fail("Test: analizeQuadrant threw an exception.");
        }
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
        } catch (NullPointerException e) {
            fail("Test: analizeQuadrant threw an exception.");
        }
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
        } catch (NullPointerException e) {
            fail("Test: analizeQuadrant threw an exception.");
        }
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
        } catch (NullPointerException e) {
            fail("Test: analizeQuadrant threw an exception.");
        }
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
        } catch (NullPointerException e) {
            fail("Test: analizeQuadrant threw an exception.");
        }
    }

    @Test
    public void testColWallOdd() {
        int row = 0;
        int col = 0;
        String[][] board = new String[][]{
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
            Boolean expResult = false;
            Boolean result = NAI.ColWallOdd(row, col, board);
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
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", "N", " ", " ", " "},
            {" ", " ", " ", " ", "-", "*", "-", " "}};
        try {
            Boolean expResult = false;
            Boolean result = NAI.ColWallOdd(row, col, board);
            assertEquals(expResult, result);
        } catch (NullPointerException e) {
            fail("Test: ColWallOdd threw an exception.");
        }
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
        } catch (NullPointerException e) {
            fail("Test: ColWallOdd threw an exception.");
        }
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
        } catch (NullPointerException e) {
            fail("Test: ColWallOdd threw an exception.");
        }
    }
}
