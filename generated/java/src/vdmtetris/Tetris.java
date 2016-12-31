package vdmtetris;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Tetris {
  public static final Number LINES_PER_LEVEL = 20L;
  private static final VDMMap mapNumLinesToScorePerLevel =
      MapUtil.map(
          new Maplet(1L, 40L), new Maplet(2L, 100L), new Maplet(3L, 300L), new Maplet(4L, 1200L));
  public GameGrid gameGrid = new GameGrid();
  public Tetramino tetramino = null;
  public Tetramino nextTetramino = null;
  public Number score = 0L;
  public Number level = 0L;
  public Number numberOfLines = 0L;
  public Object gameState = vdmtetris.quotes.NotStartedQuote.getInstance();

  public void begin() {

    gameGrid = new GameGrid();
    tetramino = getRandomTetramino();
    nextTetramino = getRandomTetramino();
    score = 0L;
    level = 0L;
    numberOfLines = 0L;
    gameState = vdmtetris.quotes.GameQuote.getInstance();
  }

  public void tick() {

    if (!(Utils.equals(gameState, vdmtetris.quotes.GameQuote.getInstance()))) {
      return;
    }

    if (!(tetraminoHasCollisionInCoords(tetramino.x, tetramino.y.longValue() - 1L))) {
      tetramino.y = tetramino.y.longValue() - 1L;
    } else {
      addTetraminoToGrid();
    }
  }

  public Number getTickDelay() {

    if (level.longValue() <= 8L) {
      return Math.round(Utils.floor(-83.5 * level.longValue() + 800.67));

    } else if (level.longValue() <= 29L) {
      return Math.round(Utils.floor(-3.5325 * level.longValue() + 115.69));

    } else {
      return 13L;
    }
  }

  public void moveRight() {

    if (!(Utils.equals(gameState, vdmtetris.quotes.GameQuote.getInstance()))) {
      return;
    }

    if (!(tetraminoHasCollisionInCoords(tetramino.x.longValue() + 1L, tetramino.y))) {
      tetramino.x = tetramino.x.longValue() + 1L;
    }
  }

  public void moveLeft() {

    if (!(Utils.equals(gameState, vdmtetris.quotes.GameQuote.getInstance()))) {
      return;
    }

    if (!(tetraminoHasCollisionInCoords(tetramino.x.longValue() - 1L, tetramino.y))) {
      tetramino.x = tetramino.x.longValue() - 1L;
    }
  }

  public void rotateRight() {

    if (!(Utils.equals(gameState, vdmtetris.quotes.GameQuote.getInstance()))) {
      return;
    }

    tryRotation(tetramino.getRightRotation());
  }

  public void rotateLeft() {

    if (!(Utils.equals(gameState, vdmtetris.quotes.GameQuote.getInstance()))) {
      return;
    }

    tryRotation(tetramino.getLeftRotation());
  }

  public void hardDrop() {

    if (!(Utils.equals(gameState, vdmtetris.quotes.GameQuote.getInstance()))) {
      return;
    }

    Boolean whileCond_1 = true;
    while (whileCond_1) {
      whileCond_1 = canMoveDown();
      if (!(whileCond_1)) {
        break;
      }

      {
        tetramino.y = tetramino.y.longValue() - 1L;
      }
    }

    addTetraminoToGrid();
  }

  public Number getGhostPieceHeight() {

    if (!(Utils.equals(gameState, vdmtetris.quotes.GameQuote.getInstance()))) {
      return null;

    } else {
      Number y = tetramino.y;
      VDMSeq matrix = tetramino.getCurrentMatrix();
      Boolean whileCond_2 = true;
      while (whileCond_2) {
        whileCond_2 =
            !(hasCollision(Utils.copy(matrix), gameGrid.grid, tetramino.x, y.longValue() - 1L));
        if (!(whileCond_2)) {
          break;
        }

        y = y.longValue() - 1L;
      }

      return y;
    }
  }

  private Boolean canMoveDown() {

    return !(tetraminoHasCollisionInCoords(tetramino.x, tetramino.y.longValue() - 1L));
  }

  private void addTetraminoToGrid() {

    gameGrid.addTetramino(tetramino);
    removeCompleteLines();
    {
      final VDMSeq line = Utils.copy(((VDMSeq) Utils.get(gameGrid.grid, GameGrid.HEIGHT)));
      Boolean existsExpResult_1 = false;
      VDMSet set_5 = SeqUtil.inds(line);
      for (Iterator iterator_5 = set_5.iterator(); iterator_5.hasNext() && !(existsExpResult_1); ) {
        Number x = ((Number) iterator_5.next());
        existsExpResult_1 =
            !(Utils.equals(Utils.get(line, x), vdmtetris.quotes.BlankQuote.getInstance()));
      }
      if (existsExpResult_1) {
        gameState = vdmtetris.quotes.GameOverQuote.getInstance();
        tetramino = null;
      }
    }

    if (Utils.equals(gameState, vdmtetris.quotes.GameQuote.getInstance())) {
      tetramino = nextTetramino;
      nextTetramino = getRandomTetramino();
    }
  }

  private void removeCompleteLines() {

    Number linesRemoved = 0L;
    Number y = 1L;
    Boolean whileCond_3 = true;
    while (whileCond_3) {
      whileCond_3 = y.longValue() <= gameGrid.grid.size();
      if (!(whileCond_3)) {
        break;
      }

      {
        {
          final VDMSeq line = Utils.copy(((VDMSeq) Utils.get(gameGrid.grid, y)));
          Boolean forAllExpResult_3 = true;
          VDMSet set_6 = SeqUtil.inds(line);
          for (Iterator iterator_6 = set_6.iterator();
              iterator_6.hasNext() && forAllExpResult_3;
              ) {
            Number x = ((Number) iterator_6.next());
            forAllExpResult_3 =
                !(Utils.equals(Utils.get(line, x), vdmtetris.quotes.BlankQuote.getInstance()));
          }
          if (forAllExpResult_3) {
            gameGrid.removeLine(y);
            linesRemoved = linesRemoved.longValue() + 1L;
            y = y.longValue() - 1L;
          }
        }

        y = y.longValue() + 1L;
      }
    }

    if (linesRemoved.longValue() > 0L) {
      Number atomicTmp_1 = score.longValue() + calcScore(linesRemoved, level).longValue();
      Number atomicTmp_2 = numberOfLines.longValue() + linesRemoved.longValue();
      Number atomicTmp_3 =
          Math.round(
              Utils.floor(
                  Utils.divide(
                      (1.0 * numberOfLines.longValue()), Tetris.LINES_PER_LEVEL.longValue())));
      {
          /* Start of atomic statement */
        score = atomicTmp_1;
        numberOfLines = atomicTmp_2;
        level = atomicTmp_3;
      } /* End of atomic statement */
    }
  }

  private void tryRotation(final Tetramino.RotationResult result) {

    if (!(hasCollision(Utils.copy(result.matrix), gameGrid.grid, tetramino.x, tetramino.y))) {
      tetramino.rotation = result.rotation;
    } else {
      if (!(hasCollision(
          Utils.copy(result.matrix), gameGrid.grid, tetramino.x.longValue() + 1L, tetramino.y))) {
        Number atomicTmp_4 = result.rotation;
        Number atomicTmp_5 = tetramino.x.longValue() + 1L;
        {
            /* Start of atomic statement */
          tetramino.rotation = atomicTmp_4;
          tetramino.x = atomicTmp_5;
        } /* End of atomic statement */

      } else {
        if (!(hasCollision(
            Utils.copy(result.matrix), gameGrid.grid, tetramino.x.longValue() - 1L, tetramino.y))) {
          Number atomicTmp_6 = result.rotation;
          Number atomicTmp_7 = tetramino.x.longValue() - 1L;
          {
              /* Start of atomic statement */
            tetramino.rotation = atomicTmp_6;
            tetramino.x = atomicTmp_7;
          } /* End of atomic statement */
        }
      }
    }
  }

  private Tetramino getRandomTetramino() {

    return new Tetramino(MATH.rand(Tetramino.getNumber().longValue() - 1L).longValue() + 1L);
  }

  public Boolean tetraminoHasCollisionInCoords(final Number x, final Number y) {

    for (Iterator iterator_11 = SeqUtil.inds(tetramino.getCurrentMatrix()).iterator();
        iterator_11.hasNext();
        ) {
      Number tetraminoY = (Number) iterator_11.next();
      {
        final VDMSeq line =
            Utils.copy(((VDMSeq) Utils.get(tetramino.getCurrentMatrix(), tetraminoY)));
        {
          for (Iterator iterator_12 = SeqUtil.inds(line).iterator(); iterator_12.hasNext(); ) {
            Number tetraminoX = (Number) iterator_12.next();
            {
              final Number cellX = x.longValue() - 1L + tetraminoX.longValue();
              final Number cellY = y.longValue() + 1L - tetraminoY.longValue();
              {
                if (!(Utils.equals(
                    Utils.get(line, tetraminoX), vdmtetris.quotes.BlankQuote.getInstance()))) {
                  Boolean orResult_4 = false;

                  if (cellX.longValue() < 1L) {
                    orResult_4 = true;
                  } else {
                    Boolean orResult_5 = false;

                    if (cellX.longValue() > GameGrid.WIDTH.longValue()) {
                      orResult_5 = true;
                    } else {
                      Boolean orResult_6 = false;

                      if (cellY.longValue() < 1L) {
                        orResult_6 = true;
                      } else {
                        Boolean orResult_7 = false;

                        if (cellY.longValue() > GameGrid.HEIGHT.longValue()) {
                          orResult_7 = true;
                        } else {
                          orResult_7 =
                              !(Utils.equals(
                                  gameGrid.getCell(cellX, cellY),
                                  vdmtetris.quotes.BlankQuote.getInstance()));
                        }

                        orResult_6 = orResult_7;
                      }

                      orResult_5 = orResult_6;
                    }

                    orResult_4 = orResult_5;
                  }

                  if (orResult_4) {
                    return true;
                  }
                }
              }
            }
          }
        }
      }
    }
    return false;
  }

  public Tetris() {}

  private static Boolean hasCollision(
      final VDMSeq tetraminoMatrix, final VDMSeq gameGrid_1, final Number x, final Number y) {

    Boolean existsExpResult_2 = false;
    VDMSet set_7 = SeqUtil.inds(tetraminoMatrix);
    for (Iterator iterator_7 = set_7.iterator(); iterator_7.hasNext() && !(existsExpResult_2); ) {
      Number tetraminoY = ((Number) iterator_7.next());
      Boolean existsExpResult_3 = false;
      VDMSet set_8 = SeqUtil.inds(((VDMSeq) Utils.get(tetraminoMatrix, tetraminoY)));
      for (Iterator iterator_8 = set_8.iterator(); iterator_8.hasNext() && !(existsExpResult_3); ) {
        Number tetraminoX = ((Number) iterator_8.next());
        Boolean andResult_10 = false;

        if (!(Utils.equals(
            Utils.get(((VDMSeq) Utils.get(tetraminoMatrix, tetraminoY)), tetraminoX),
            vdmtetris.quotes.BlankQuote.getInstance()))) {
          final Number cellX = x.longValue() - 1L + tetraminoX.longValue();
          final Number cellY = y.longValue() + 1L - tetraminoY.longValue();

          Boolean orResult_8 = false;

          if (cellX.longValue() < 1L) {
            orResult_8 = true;
          } else {
            Boolean orResult_9 = false;

            if (cellX.longValue() > GameGrid.WIDTH.longValue()) {
              orResult_9 = true;
            } else {
              Boolean orResult_10 = false;

              if (cellY.longValue() < 1L) {
                orResult_10 = true;
              } else {
                Boolean orResult_11 = false;

                if (cellY.longValue() > GameGrid.HEIGHT.longValue()) {
                  orResult_11 = true;
                } else {
                  orResult_11 =
                      !(Utils.equals(
                          Utils.get(((VDMSeq) Utils.get(gameGrid_1, cellY)), cellX),
                          vdmtetris.quotes.BlankQuote.getInstance()));
                }

                orResult_10 = orResult_11;
              }

              orResult_9 = orResult_10;
            }

            orResult_8 = orResult_9;
          }

          if (orResult_8) {
            andResult_10 = true;
          }
        }

        existsExpResult_3 = andResult_10;
      }
      existsExpResult_2 = existsExpResult_3;
    }
    return existsExpResult_2;
  }

  private static Number calcScore(final Number lines, final Number level_1) {

    return ((Number) Utils.get(mapNumLinesToScorePerLevel, lines)).longValue()
        * (level_1.longValue() + 1L);
  }

  public String toString() {

    return "Tetris{"
        + "LINES_PER_LEVEL = "
        + Utils.toString(LINES_PER_LEVEL)
        + ", mapNumLinesToScorePerLevel = "
        + Utils.toString(mapNumLinesToScorePerLevel)
        + ", gameGrid := "
        + Utils.toString(gameGrid)
        + ", tetramino := "
        + Utils.toString(tetramino)
        + ", nextTetramino := "
        + Utils.toString(nextTetramino)
        + ", score := "
        + Utils.toString(score)
        + ", level := "
        + Utils.toString(level)
        + ", numberOfLines := "
        + Utils.toString(numberOfLines)
        + ", gameState := "
        + Utils.toString(gameState)
        + "}";
  }

  public static class Point implements Record {
    public Number x;
    public Number y;

    public Point(final Number _x, final Number _y) {

      x = _x;
      y = _y;
    }

    public boolean equals(final Object obj) {

      if (!(obj instanceof Point)) {
        return false;
      }

      Point other = ((Point) obj);

      return (Utils.equals(x, other.x)) && (Utils.equals(y, other.y));
    }

    public int hashCode() {

      return Utils.hashCode(x, y);
    }

    public Point copy() {

      return new Point(x, y);
    }

    public String toString() {

      return "mk_Tetris`Point" + Utils.formatFields(x, y);
    }
  }
}
