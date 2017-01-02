package vdmtetris;

import java.util.*;
import org.overture.codegen.runtime.*;

import junit.framework.TestCase;

@SuppressWarnings("all")
public class UnitTests extends TestCase {
  private Tetris tetris = new Tetris();

  public void testNoCollision() {

    tetris.begin();
    assertFalse(tetris.tetraminoHasCollisionInCoords(5L, 5L));
  }

  public void testNoCollision2() {

    tetris.begin();
    tetris.tetramino = new Tetramino('I');
    tetris.tetramino.rotation = 2L;
    assertFalse(tetris.tetraminoHasCollisionInCoords(8L, 15L));
  }

  public void testWallCollision() {

    tetris.begin();
    tetris.tetramino = new Tetramino('I');
    assertTrue(tetris.tetraminoHasCollisionInCoords(8L, 15L));
    tetris.tetramino.rotation = 2L;
    assertFalse(tetris.tetraminoHasCollisionInCoords(8L, 15L));
  }

  public void testRightWallKick() {

    tetris.begin();
    tetris.tetramino = new Tetramino('I');
    assertTrue(Utils.equals(tetris.tetramino.x, 4L));
    tetris.moveRight();
    tetris.moveRight();
    tetris.moveRight();
    assertTrue(Utils.equals(tetris.tetramino.x, 7L));
    tetris.moveRight();
    assertTrue(Utils.equals(tetris.tetramino.x, 7L));
    tetris.rotateRight();
    assertTrue(Utils.equals(tetris.tetramino.rotation, 2L));
    assertTrue(Utils.equals(tetris.tetramino.x, 7L));
    tetris.moveRight();
    tetris.moveRight();
    assertTrue(Utils.equals(tetris.tetramino.x, 8L));
    tetris.rotateRight();
    assertTrue(Utils.equals(tetris.tetramino.rotation, 3L));
    assertTrue(Utils.equals(tetris.tetramino.x, 7L));
  }

  public void testLeftWallKick() {

    tetris.begin();
    tetris.tetramino = new Tetramino('I');
    assertTrue(Utils.equals(tetris.tetramino.x, 4L));
    tetris.moveLeft();
    tetris.moveLeft();
    tetris.moveLeft();
    assertTrue(Utils.equals(tetris.tetramino.x, 1L));
    tetris.moveLeft();
    assertTrue(Utils.equals(tetris.tetramino.x, 1L));
    tetris.rotateRight();
    assertTrue(Utils.equals(tetris.tetramino.rotation, 2L));
    assertTrue(Utils.equals(tetris.tetramino.x, 1L));
    tetris.moveLeft();
    tetris.moveLeft();
    tetris.moveLeft();
    assertTrue(Utils.equals(tetris.tetramino.x, -1L));
    tetris.rotateRight();
    assertTrue(Utils.equals(tetris.tetramino.rotation, 2L));
    tetris.moveRight();
    assertTrue(Utils.equals(tetris.tetramino.x, 0L));
    tetris.rotateRight();
    assertTrue(Utils.equals(tetris.tetramino.rotation, 3L));
    assertTrue(Utils.equals(tetris.tetramino.x, 1L));
  }

  public void testAddTetramino() {

    tetris.begin();
    tetris.tetramino = new Tetramino('I');
    assertTrue(Utils.equals(tetris.tetramino.y, 22L));
    tetris.tick();
    assertTrue(Utils.equals(tetris.tetramino.y, 21L));
    long toVar_3 = 19L;

    for (Long i = 1L; i <= toVar_3; i++) {
      tetris.tick();
    }
    assertTrue(Utils.equals(tetris.tetramino.y, 2L));
    tetris.tick();
    assertTrue(
        Utils.equals(
            Utils.get(((VDMSeq) Utils.get(tetris.gameGrid.grid, 1L)), 5L),
            vdmtetris.quotes.CyanQuote.getInstance()));
    assertTrue(Utils.equals(tetris.tetramino.y, 22L));
  }

  public void testAdd2Tetraminos() {

    testAddTetramino();
    tetris.tetramino = new Tetramino('I');
    assertTrue(Utils.equals(tetris.tetramino.y, 22L));
    long toVar_4 = 19L;

    for (Long i = 1L; i <= toVar_4; i++) {
      tetris.tick();
    }
    assertTrue(Utils.equals(tetris.tetramino.y, 3L));
    tetris.tick();
    assertTrue(
        Utils.equals(
            Utils.get(((VDMSeq) Utils.get(tetris.gameGrid.grid, 2L)), 5L),
            vdmtetris.quotes.CyanQuote.getInstance()));
    assertTrue(Utils.equals(tetris.tetramino.y, 22L));
  }

  public void testHardDrop() {

    tetris.begin();
    tetris.tetramino = new Tetramino('J');
    assertTrue(Utils.equals(tetris.tetramino.y, 22L));
    tetris.hardDrop();
    assertTrue(
        Utils.equals(
            Utils.get(((VDMSeq) Utils.get(tetris.gameGrid.grid, 1L)), 5L),
            vdmtetris.quotes.BlueQuote.getInstance()));
    assertTrue(Utils.equals(tetris.tetramino.y, 22L));
  }

  public void testCompletedLine() {

    tetris.begin();
    tetris.tetramino = new Tetramino('I');
    tetris.moveLeft();
    tetris.moveLeft();
    tetris.moveLeft();
    tetris.hardDrop();
    tetris.tetramino = new Tetramino('I');
    tetris.moveRight();
    tetris.hardDrop();
    assertTrue(
        Utils.equals(
            Utils.get(((VDMSeq) Utils.get(tetris.gameGrid.grid, 1L)), 1L),
            vdmtetris.quotes.CyanQuote.getInstance()));
    assertTrue(
        Utils.equals(
            Utils.get(((VDMSeq) Utils.get(tetris.gameGrid.grid, 1L)), 8L),
            vdmtetris.quotes.CyanQuote.getInstance()));
    tetris.tetramino = new Tetramino('O');
    tetris.moveRight();
    tetris.moveRight();
    tetris.moveRight();
    tetris.moveRight();
    tetris.hardDrop();
    long toVar_5 = GameGrid.HEIGHT.longValue();

    for (Long i = 1L; i <= toVar_5; i++) {
      assertTrue(
          Utils.equals(
              Utils.get(((VDMSeq) Utils.get(tetris.gameGrid.grid, i)), 1L),
              vdmtetris.quotes.BlankQuote.getInstance()));
      assertTrue(
          Utils.equals(
              Utils.get(((VDMSeq) Utils.get(tetris.gameGrid.grid, i)), 8L),
              vdmtetris.quotes.BlankQuote.getInstance()));
    }
    assertTrue(
        Utils.equals(
            Utils.get(((VDMSeq) Utils.get(tetris.gameGrid.grid, 1L)), 10L),
            vdmtetris.quotes.YellowQuote.getInstance()));
    assertTrue(
        Utils.equals(
            Utils.get(((VDMSeq) Utils.get(tetris.gameGrid.grid, 2L)), 10L),
            vdmtetris.quotes.BlankQuote.getInstance()));
    assertTrue(Utils.equals(tetris.level, 0L));
    assertTrue(Utils.equals(tetris.score, 40L));
  }

  public void testGameOver() {

    tetris.begin();
    long toVar_6 =
        Math.round(
            Utils.floor(Utils.divide((1.0 * (GameGrid.VISIBLE_HEIGHT.longValue() + 1L)), 2L)));

    for (Long i = 1L; i <= toVar_6; i++) {
      tetris.tetramino = new Tetramino('O');
      assertTrue(Utils.equals(tetris.gameState, vdmtetris.quotes.GameQuote.getInstance()));
      tetris.hardDrop();
    }
    assertTrue(Utils.equals(tetris.gameState, vdmtetris.quotes.GameOverQuote.getInstance()));
  }

  public void testRotations() {

    tetris.begin();
    tetris.tetramino = new Tetramino('Z');
    assertTrue(Utils.equals(tetris.tetramino.rotation, 1L));
    long toVar_7 = 4L;

    for (Long i = 1L; i <= toVar_7; i++) {
      tetris.rotateLeft();
    }
    assertTrue(Utils.equals(tetris.tetramino.rotation, 1L));
    long toVar_8 = 4L;

    for (Long i = 1L; i <= toVar_8; i++) {
      tetris.rotateRight();
    }
    assertTrue(Utils.equals(tetris.tetramino.rotation, 1L));
  }

  public void testGhostPiece() {

    tetris.begin();
    tetris.tetramino = new Tetramino('I');
    assertTrue(Utils.equals(tetris.getGhostPieceHeight(), 2L));
  }

  public void testTickDelays() {

    Number prevDelay = 0L;
    Number curDelay = 0L;
    tetris.begin();
    prevDelay = tetris.getTickDelay();
    long toVar_9 = 50L;

    for (Long level = 1L; level <= toVar_9; level++) {
      tetris.level = level;
      curDelay = tetris.getTickDelay();
      assertTrue(curDelay.longValue() <= prevDelay.longValue());
      prevDelay = curDelay;
    }
  }

  public UnitTests() {}

  public String toString() {

    return "UnitTests{" + "tetris := " + Utils.toString(tetris) + "}";
  }
}
