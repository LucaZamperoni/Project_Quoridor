package ai;

import org.junit.Test;
import static org.junit.Assert.*;

public class AnalyzerTest {

    @Test
    public void testAnalyzeN() {
        // Cases in which the result should be false.
        int row = 1;
        int col = 1;
        String enemyPawn = "S";
        // Case 1:
        String[][] board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", "-", " ", " "},
            {" ", " ", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeN(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 2:
        board = new String[][]{
            {" ", " ", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeN(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 3:
        board = new String[][]{
            {" ", " ", "N", " ", " "},
            {" ", " ", "-", " ", " "},
            {" ", " ", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeN(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Cases in which the result should be true.
        // Case 1:
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeN(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 2:
        board = new String[][]{
            {" ", " ", " ", "|", " "},
            {" ", " ", " ", "*", " "},
            {" ", " ", "N", "|", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeN(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 3: in this case the north is blocked, but the result is true because I have another method that is responsible for analyzing that specific situation.
        board = new String[][]{
            {" ", " ", "S", "|", " "},
            {" ", " ", " ", "*", " "},
            {" ", " ", "N", "|", " "},
            {" ", "-", "*", "-", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeN(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeJumpN() {
        // Cases in which the result should be false.
        int row = 2;
        int col = 1;
        String enemyPawn = "S";
        // Case 1:
        String[][] board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", "-", " ", " "},
            {" ", " ", "S", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeJumpN(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 2:
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeJumpN(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 3:
        board = new String[][]{
            {" ", " ", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "S", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeJumpN(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Only case where it should be true.
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "S", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " "}};
        try {
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeJumpN(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeS() {
        // Cases in which the result should be false.
        int row = 1;
        int col = 1;
        String enemyPawn = "S";
        // Case 1:
        String[][] board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " "},
            {" ", " ", "-", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeS(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 2:
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeS(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 3:
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " "},
            {" ", " ", "-", " ", " "},
            {" ", " ", "N", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeS(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Cases in which the result should be true.
        // Case 1:
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeS(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 2:
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", "|", " "},
            {" ", " ", " ", "*", " "},
            {" ", " ", " ", "|", " "}};
        try {
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeS(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 3: in this case the south is blocked, but the result is true because I have another method that is responsible for analyzing that specific situation.
        board = new String[][]{
            {" ", " ", " ", "|", " "},
            {" ", " ", " ", "*", " "},
            {" ", "|", "N", "|", " "},
            {" ", "*", " ", " ", " "},
            {" ", "|", "S", " ", " "}};
        try {
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeS(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeJumpS() {
        // Cases in which the result should be false.
        int row = 0;
        int col = 1;
        String enemyPawn = "S";
        // Case 1:
        String[][] board = new String[][]{
            {" ", " ", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "S", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeJumpS(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 2:
        board = new String[][]{
            {" ", " ", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "S", " ", " "},
            {" ", " ", "-", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeJumpS(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 3:
        board = new String[][]{
            {" ", " ", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeJumpS(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Only case where it should be true.
        board = new String[][]{
            {" ", " ", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "S", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeJumpS(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeE() {
        // Cases in which the result should be false.
        int row = 1;
        int col = 1;
        String enemyPawn = "S";
        // Case 1:
        String[][] board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", "|", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeE(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 2:
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", " ", "N"},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeE(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 3:
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", "|", "N"},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeE(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Cases in which the result should be true.
        // Case 1:
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeE(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 2:
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " "},
            {" ", " ", "-", "*", "-"},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeE(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 3: in this case the east is blocked, but the result is true because I have another method that is responsible for analyzing that specific situation.
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", "|", "N", " ", "S"},
            {" ", "*", " ", " ", " "},
            {" ", "|", "S", " ", " "}};
        try {
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeE(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeJumpE() {
        // Cases in which the result should be false.
        int row = 0;
        int col = 0;
        String enemyPawn = "N";
        // Case 1:
        String[][] board = new String[][]{
            {"S", " ", "S", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeJumpE(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 2:
        board = new String[][]{
            {"S", " ", "N", "|", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeJumpE(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 3:
        board = new String[][]{
            {"S", " ", "N", " ", "S"},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeJumpE(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Only case where it should be true.
        board = new String[][]{
            {"S", " ", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeJumpE(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeW() {
        // Cases in which the result should be false.
        int row = 1;
        int col = 1;
        String enemyPawn = "N";
        // Case 1:
        String[][] board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", "|", "S", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeW(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 2:
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {"S", " ", "S", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeW(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 3:
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {"S", "|", "S", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeW(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Cases in which the result should be true.
        // Case 1:
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "S", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeW(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 2:
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "S", " ", " "},
            {" ", " ", "-", "*", "-"},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeW(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 3: in this case the west is blocked, but the result is true because I have another method that is responsible for analyzing that specific situation.
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {"N", " ", "S", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeW(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("Test: analizeW threw an Exception.");
        }
    }

    @Test
    public void testAnalyzeJumpW() {
        // Cases in which the result should be false.
        int row = 0;
        int col = 2;
        String enemyPawn = "S";
        // Case 1:
        String[][] board = new String[][]{
            {" ", " ", "N", " ", "N"},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeJumpW(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 2:
        board = new String[][]{
            {" ", "|", "S", " ", "N"},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeJumpW(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case 3:
        board = new String[][]{
            {"N", " ", "S", " ", "N"},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeJumpW(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Only case where it should be true.
        board = new String[][]{
            {" ", " ", "S", " ", "N"},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeJumpW(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testScanNEHorWall() {
        int row = 1;
        int col = 1;
        // Case in which the result should be 0.
        String[][] board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", "*", " "},
            {" ", " ", "S", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            int expResult = 0;
            int result = Analyzer.scanNEHorWall(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case in which the result should be 1.
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", "-", "*", "-"},
            {" ", " ", "S", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            int expResult = 1;
            int result = Analyzer.scanNEHorWall(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case in which the result should be 2.
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "S", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            int expResult = 2;
            int result = Analyzer.scanNEHorWall(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testScanNWHorWall() {
        int row = 1;
        int col = 1;
        // Case in which the result should be 0.
        String[][] board = new String[][]{
            {" ", "|", " ", " ", " "},
            {" ", "*", " ", " ", " "},
            {" ", "|", "S", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            int expResult = 0;
            int result = Analyzer.scanNWHorWall(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case in which the result should be 1.
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {"-", "*", "-", " ", " "},
            {" ", " ", "S", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            int expResult = 1;
            int result = Analyzer.scanNWHorWall(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case in which the result should be 2.
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "S", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            int expResult = 2;
            int result = Analyzer.scanNWHorWall(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testScanSEHorWall() {
        int row = 1;
        int col = 1;
        // Case in which the result should be 0.
        String[][] board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "S", " ", " "},
            {"-", "*", "-", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            int expResult = 0;
            int result = Analyzer.scanSEHorWall(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case in which the result should be 1.
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", "-", "*", "-"},
            {" ", " ", "S", " ", " "},
            {" ", " ", "-", "*", "-"},
            {" ", " ", " ", " ", " "}};
        try {
            int expResult = 1;
            int result = Analyzer.scanSEHorWall(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case in which the result should be 2.
        board = new String[][]{
            {" ", " ", " ", "|", " "},
            {" ", " ", " ", "*", " "},
            {" ", " ", "S", "|", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            int expResult = 2;
            int result = Analyzer.scanSEHorWall(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testScanSWHorWall() {
        int row = 1;
        int col = 1;
        // Case in which the result should be 0.
        String[][] board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", "|", "S", " ", " "},
            {" ", "*", " ", " ", " "},
            {" ", "|", " ", " ", " "}};
        try {
            int expResult = 0;
            int result = Analyzer.scanSWHorWall(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case in which the result should be 1.
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", "-", "*", "-"},
            {" ", " ", "S", " ", " "},
            {"-", "*", "-", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            int expResult = 1;
            int result = Analyzer.scanSWHorWall(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
        // Case in which the result should be 2.
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "S", "|", " "},
            {" ", " ", " ", "*", " "},
            {" ", " ", " ", "|", " "}};
        try {
            int expResult = 2;
            int result = Analyzer.scanSWHorWall(row, col, board);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }
}
