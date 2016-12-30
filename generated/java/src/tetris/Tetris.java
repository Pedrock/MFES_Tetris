package tetris;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Tetris {
  public static final Number LINES_PER_LEVEL = 20L;
  public GameGrid gameGrid = new GameGrid();
  public Tetramino tetramino = null;
  public Number score = 0L;
  public Number level = 0L;
  public Number numberOfLines = 0L;
  public Object gameState = tetris.quotes.NotStartedQuote.getInstance();

  public void begin() {

    gameGrid = new GameGrid();
    tetramino = getRandomTetramino();
    score = 0L;
    level = 0L;
    numberOfLines = 0L;
    gameState = tetris.quotes.GameQuote.getInstance();
  }

  public void tick() {

    if (!(Utils.equals(gameState, tetris.quotes.GameQuote.getInstance()))) {
      return;
    }

    if (!(tetraminoHasCollisionInCoords(tetramino.x, tetramino.y.longValue() - 1L))) {
      tetramino.y = tetramino.y.longValue() - 1L;
    } else {
      addTetraminoToGrid();
    }
  }

  public void moveRight() {

    if (!(Utils.equals(gameState, tetris.quotes.GameQuote.getInstance()))) {
      return;
    }

    if (!(tetraminoHasCollisionInCoords(tetramino.x.longValue() + 1L, tetramino.y))) {
      tetramino.x = tetramino.x.longValue() + 1L;
    }
  }

  public void moveLeft() {

    if (!(Utils.equals(gameState, tetris.quotes.GameQuote.getInstance()))) {
      return;
    }

    if (!(tetraminoHasCollisionInCoords(tetramino.x.longValue() - 1L, tetramino.y))) {
      tetramino.x = tetramino.x.longValue() - 1L;
    }
  }

  public void rotateRight() {

    if (!(Utils.equals(gameState, tetris.quotes.GameQuote.getInstance()))) {
      return;
    }

    tryRotation(tetramino.getRightRotation());
  }

  public void rotateLeft() {

    if (!(Utils.equals(gameState, tetris.quotes.GameQuote.getInstance()))) {
      return;
    }

    tryRotation(tetramino.getLeftRotation());
  }

  public void hardDrop() {

    if (!(Utils.equals(gameState, tetris.quotes.GameQuote.getInstance()))) {
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

  private Boolean canMoveDown() {

    return !(tetraminoHasCollisionInCoords(tetramino.x, tetramino.y.longValue() - 1L));
  }

  private void addTetraminoToGrid() {

    gameGrid.addTetramino(tetramino);
    removeCompleteLines();
    {
      final VDMSeq line = Utils.copy(((VDMSeq) Utils.get(gameGrid.grid, GameGrid.HEIGHT)));
      Boolean existsExpResult_1 = false;
      VDMSet set_3 = SeqUtil.inds(line);
      for (Iterator iterator_3 = set_3.iterator(); iterator_3.hasNext() && !(existsExpResult_1); ) {
        Number x = ((Number) iterator_3.next());
        existsExpResult_1 =
            !(Utils.equals(Utils.get(line, x), tetris.quotes.BlankQuote.getInstance()));
      }
      if (existsExpResult_1) {
        gameState = tetris.quotes.GameOverQuote.getInstance();
        tetramino = null;
      }
    }

    if (Utils.equals(gameState, tetris.quotes.GameQuote.getInstance())) {
      tetramino = getRandomTetramino();
    }
  }

  private void removeCompleteLines() {

    Number linesRemoved = 0L;
    Number y = 1L;
    Boolean whileCond_2 = true;
    while (whileCond_2) {
      whileCond_2 = y.longValue() <= gameGrid.grid.size();
      if (!(whileCond_2)) {
        break;
      }

      {
        {
          final VDMSeq line = Utils.copy(((VDMSeq) Utils.get(gameGrid.grid, y)));
          Boolean forAllExpResult_1 = true;
          VDMSet set_4 = SeqUtil.inds(line);
          for (Iterator iterator_4 = set_4.iterator();
              iterator_4.hasNext() && forAllExpResult_1;
              ) {
            Number x = ((Number) iterator_4.next());
            forAllExpResult_1 =
                !(Utils.equals(Utils.get(line, x), tetris.quotes.BlankQuote.getInstance()));
          }
          if (forAllExpResult_1) {
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

    for (Iterator iterator_9 = SeqUtil.inds(tetramino.getCurrentMatrix()).iterator();
        iterator_9.hasNext();
        ) {
      Number tetraminoY = (Number) iterator_9.next();
      {
        final VDMSeq line =
            Utils.copy(((VDMSeq) Utils.get(tetramino.getCurrentMatrix(), tetraminoY)));
        {
          for (Iterator iterator_10 = SeqUtil.inds(line).iterator(); iterator_10.hasNext(); ) {
            Number tetraminoX = (Number) iterator_10.next();
            {
              final Number cellX = x.longValue() - 1L + tetraminoX.longValue();
              final Number cellY = y.longValue() + 1L - tetraminoY.longValue();
              {
                if (!(Utils.equals(
                    Utils.get(line, tetraminoX), tetris.quotes.BlankQuote.getInstance()))) {
                  Boolean orResult_3 = false;

                  if (cellX.longValue() < 1L) {
                    orResult_3 = true;
                  } else {
                    Boolean orResult_4 = false;

                    if (cellX.longValue() > GameGrid.WIDTH.longValue()) {
                      orResult_4 = true;
                    } else {
                      Boolean orResult_5 = false;

                      if (cellY.longValue() < 1L) {
                        orResult_5 = true;
                      } else {
                        Boolean orResult_6 = false;

                        if (cellY.longValue() > GameGrid.HEIGHT.longValue()) {
                          orResult_6 = true;
                        } else {
                          orResult_6 =
                              !(Utils.equals(
                                  gameGrid.getCell(cellX, cellY),
                                  tetris.quotes.BlankQuote.getInstance()));
                        }

                        orResult_5 = orResult_6;
                      }

                      orResult_4 = orResult_5;
                    }

                    orResult_3 = orResult_4;
                  }

                  if (orResult_3) {
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
    VDMSet set_5 = SeqUtil.inds(tetraminoMatrix);
    for (Iterator iterator_5 = set_5.iterator(); iterator_5.hasNext() && !(existsExpResult_2); ) {
      Number tetraminoY = ((Number) iterator_5.next());
      Boolean existsExpResult_3 = false;
      VDMSet set_6 = SeqUtil.inds(((VDMSeq) Utils.get(tetraminoMatrix, tetraminoY)));
      for (Iterator iterator_6 = set_6.iterator(); iterator_6.hasNext() && !(existsExpResult_3); ) {
        Number tetraminoX = ((Number) iterator_6.next());
        Boolean andResult_7 = false;

        if (!(Utils.equals(
            Utils.get(((VDMSeq) Utils.get(tetraminoMatrix, tetraminoY)), tetraminoX),
            tetris.quotes.BlankQuote.getInstance()))) {
          final Number cellX = x.longValue() - 1L + tetraminoX.longValue();
          final Number cellY = y.longValue() + 1L - tetraminoY.longValue();

          Boolean orResult_7 = false;

          if (cellX.longValue() < 1L) {
            orResult_7 = true;
          } else {
            Boolean orResult_8 = false;

            if (cellX.longValue() > GameGrid.WIDTH.longValue()) {
              orResult_8 = true;
            } else {
              Boolean orResult_9 = false;

              if (cellY.longValue() < 1L) {
                orResult_9 = true;
              } else {
                Boolean orResult_10 = false;

                if (cellY.longValue() > GameGrid.HEIGHT.longValue()) {
                  orResult_10 = true;
                } else {
                  orResult_10 =
                      !(Utils.equals(
                          Utils.get(((VDMSeq) Utils.get(gameGrid_1, cellY)), cellX),
                          tetris.quotes.BlankQuote.getInstance()));
                }

                orResult_9 = orResult_10;
              }

              orResult_8 = orResult_9;
            }

            orResult_7 = orResult_8;
          }

          if (orResult_7) {
            andResult_7 = true;
          }
        }

        existsExpResult_3 = andResult_7;
      }
      existsExpResult_2 = existsExpResult_3;
    }
    return existsExpResult_2;
  }

  private static Number calcScore(final Number lines, final Number level_1) {

    if (Utils.equals(lines, 0L)) {
      return 0L;

    } else {
      if (Utils.equals(lines, 1L)) {
        return 40L * (level_1.longValue() + 1L);

      } else {
        if (Utils.equals(lines, 2L)) {
          return 100L * (level_1.longValue() + 1L);

        } else {
          if (Utils.equals(lines, 3L)) {
            return 300L * (level_1.longValue() + 1L);

          } else {
            return 1200L * (level_1.longValue() + 1L);
          }
        }
      }
    }
  }

  public String toString() {

    return "Tetris{"
        + "LINES_PER_LEVEL = "
        + Utils.toString(LINES_PER_LEVEL)
        + ", gameGrid := "
        + Utils.toString(gameGrid)
        + ", tetramino := "
        + Utils.toString(tetramino)
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
}
