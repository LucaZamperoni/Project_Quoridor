package implement;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class AnalyzerTest {

    private int row;
    private int col;
    private String enemyPawn;
    private String[][] board;

    @Before
    public void init() {
        row = 0;
        col = 0;
        enemyPawn = "S";
        board = null;
    }

    // NORTH TESTS -------------------------------------------------------------
    @Test
    public void testAnalyzeNIfWall() {
        row = 1;
        col = 1;
        board = new String[][]{
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
    }

    @Test
    public void testAnalyzeNIfAllyPawn() {
        row = 1;
        col = 1;
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
    }

    @Test
    public void testAnalyzeNIfWallAndAllyPawn() {
        row = 1;
        col = 1;
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
    }

    @Test
    public void testAnalyzeNIfEmpty() {
        row = 1;
        col = 1;
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
    }

    @Test
    public void testAnalyzeNIfBlockedButTrue() {
        row = 1;
        col = 1;
        board = new String[][]{
            {" ", " ", "S", "|", " "},
            {" ", " ", " ", "*", " "},
            {" ", " ", "N", "|", " "},
            {" ", "-", "*", "-", " "},
            {" ", " ", " ", " ", " "}};
        try {
            // In this case the north is blocked, but the result is true because I have another method that is responsible for analyzing that specific situation.
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeN(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeJumpNIfWall() {
        row = 2;
        col = 1;
        board = new String[][]{
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
    }

    @Test
    public void testAnalyzeJumpNIfAllyPawn() {
        row = 2;
        col = 1;
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
    }

    @Test
    public void testAnalyzeJumpNIfNextPositionIsNotEmpty() {
        row = 2;
        col = 1;
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
    }

    @Test
    public void testAnalyzeJumpNIfEmpty() {
        row = 2;
        col = 1;
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

    // SOUTH TESTS -------------------------------------------------------------
    @Test
    public void testAnalyzeSIfWall() {
        row = 1;
        col = 1;
        board = new String[][]{
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
    }

    @Test
    public void testAnalyzeSIfAllyPawn() {
        row = 1;
        col = 1;
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
    }

    @Test
    public void testAnalyzeSIfWallAndAllyPawn() {
        row = 1;
        col = 1;
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
    }

    @Test
    public void testAnalyzeSIfEmpty() {
        row = 1;
        col = 1;
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
    }

    @Test
    public void testAnalyzeSIfBlockedButTrue() {
        row = 1;
        col = 1;
        board = new String[][]{
            {" ", " ", " ", "|", " "},
            {" ", " ", " ", "*", " "},
            {" ", "|", "N", "|", " "},
            {" ", "*", " ", " ", " "},
            {" ", "|", "S", " ", " "}};
        try {
            // In this case the south is blocked, but the result is true because I have another method that is responsible for analyzing that specific situation.
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeS(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeJumpSIfWall() {
        row = 0;
        col = 1;
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
    }

    @Test
    public void testAnalyzeJumpSIfAllyPawn() {
        row = 0;
        col = 1;
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
    }

    @Test
    public void testAnalyzeJumpSIfNextPositionIsNotEmpty() {
        row = 0;
        col = 1;
        board = new String[][]{
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
    }

    @Test
    public void testAnalyzeJumpSIfEmpty() {
        row = 0;
        col = 1;
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

    // EAST TESTS --------------------------------------------------------------
    @Test
    public void testAnalyzeEIfWall() {
        row = 1;
        col = 1;
        board = new String[][]{
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
    }

    @Test
    public void testAnalyzeEIfAllyPawn() {
        row = 1;
        col = 1;
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
    }

    @Test
    public void testAnalyzeEIfWallAndAllyPawn() {
        row = 1;
        col = 1;
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
    }

    @Test
    public void testAnalyzeEIfEmpty() {
        row = 1;
        col = 1;
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
    }

    @Test
    public void testAnalyzeEIfBlockedButTrue() {
        row = 1;
        col = 1;
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", "|", "N", " ", "S"},
            {" ", "*", " ", " ", " "},
            {" ", "|", "S", " ", " "}};
        try {
            // In this case the east is blocked, but the result is true because I have another method that is responsible for analyzing that specific situation.
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeE(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeJumpEIfWall() {
        row = 0;
        col = 0;
        board = new String[][]{
            {"N", " ", "S", "|", " "},
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
    }

    @Test
    public void testAnalyzeJumpEIfAllyPawn() {
        row = 0;
        col = 0;
        board = new String[][]{
            {"N", " ", "N", " ", " "},
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
    }

    @Test
    public void testAnalyzeJumpEIfNextPositionIsNotEmpty() {
        row = 0;
        col = 0;
        board = new String[][]{
            {"N", " ", "S", " ", "N"},
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
    }

    @Test
    public void testAnalyzeJumpEIfEmpty() {
        row = 0;
        col = 0;
        board = new String[][]{
            {"N", " ", "S", " ", " "},
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

    // WEST TESTS --------------------------------------------------------------
    @Test
    public void testAnalyzeWIfWall() {
        row = 1;
        col = 1;
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", "|", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeW(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeWIfAllyPawn() {
        row = 1;
        col = 1;
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {"N", " ", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeW(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeWIfWallAndAllyPawn() {
        row = 1;
        col = 1;
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {"N", "|", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = false;
            Boolean result = Analyzer.analyzeW(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeWIfEmpty() {
        row = 1;
        col = 1;
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeW(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeWIfBlockedButTrue() {
        row = 1;
        col = 1;
        board = new String[][]{
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {"S", " ", "N", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "}};
        try {
            // In this case the west is blocked, but the result is true because I have another method that is responsible for analyzing that specific situation.
            Boolean expResult = true;
            Boolean result = Analyzer.analyzeW(row, col, board, enemyPawn);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAnalyzeJumpWIfWall() {
        row = 0;
        col = 2;
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
    }

    @Test
    public void testAnalyzeJumpWIfAllyPawn() {
        row = 0;
        col = 2;
        board = new String[][]{
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
    }

    @Test
    public void testAnalyzeJumpWIfNextPositionIsNotEmpty() {
        row = 0;
        col = 2;
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
    }

    @Test
    public void testAnalyzeJumpWIfEmpty() {
        row = 0;
        col = 2;
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

    // NE HORIZONTAL WALL TESTS ------------------------------------------------
    @Test
    public void testScanNEHorWallIfNotWallOrEmpty() {
        row = 1;
        col = 1;
        board = new String[][]{
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
    }

    @Test
    public void testScanNEHorWallIfWall() {
        row = 1;
        col = 1;
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
    }

    @Test
    public void testScanNEHorWallIfEmpty() {
        row = 1;
        col = 1;
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

    // NW HORIZONTAL WALL TESTS ------------------------------------------------
    @Test
    public void testScanNWHorWallIfNotWallOrEmpty() {
        row = 1;
        col = 1;
        board = new String[][]{
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
    }

    @Test
    public void testScanNWHorWallIfWall() {
        row = 1;
        col = 1;
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
    }

    @Test
    public void testScanNWHorWallIfEmpty() {
        row = 1;
        col = 1;
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

    // SE HORIZONTAL WALL TESTS ------------------------------------------------
    @Test
    public void testScanSEHorWallIfNotWallOrEmpty() {
        row = 1;
        col = 1;
        board = new String[][]{
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
    }

    @Test
    public void testScanSEHorWallIfWall() {
        row = 1;
        col = 1;
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
    }

    @Test
    public void testScanSEHorWallIfEmpty() {
        row = 1;
        col = 1;
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

    // SW HORIZONTAL WALL TESTS ------------------------------------------------
    @Test
    public void testScanSWHorWallIfNotWallOrEmpty() {
        row = 1;
        col = 1;
        board = new String[][]{
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
    }

    @Test
    public void testScanSWHorWallIfWall() {
        row = 1;
        col = 1;
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
    }

    @Test
    public void testScanSWHorWallIfEmpty() {
        row = 1;
        col = 1;
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
