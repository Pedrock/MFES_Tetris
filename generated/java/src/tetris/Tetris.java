package tetris;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Tetris {
  public GameGrid gameGrid = new GameGrid();
  public Tetramino tetramino = getRandomTetramino();

  public void begin() {

    gameGrid = new GameGrid();
    tetramino = getRandomTetramino();
  }

  public void tick() {

    if (!(tetraminoHasCollisionInCoords(tetramino.x, tetramino.y.longValue() - 1L))) {
      tetramino.y = tetramino.y.longValue() - 1L;
    } else {
      gameGrid.addTetramino(tetramino);
      tetramino = getRandomTetramino();
    }
  }

  public void moveRight() {

    if (!(tetraminoHasCollisionInCoords(tetramino.x.longValue() + 1L, tetramino.y))) {
      tetramino.x = tetramino.x.longValue() + 1L;
    }
  }

  public void moveLeft() {

    if (!(tetraminoHasCollisionInCoords(tetramino.x.longValue() - 1L, tetramino.y))) {
      tetramino.x = tetramino.x.longValue() - 1L;
    }
  }

  public void rotateRight() {

    tryRotation(tetramino.getRightRotation());
  }

  public void rotateLeft() {

    tryRotation(tetramino.getLeftRotation());
  }

  private void tryRotation(final Tetramino.RotationResult result) {

    if (!(hasCollision(Utils.copy(result.matrix), gameGrid.grid, tetramino.x, tetramino.y))) {
      tetramino.rotation = result.rotation;
    } else {
      if (!(hasCollision(
          Utils.copy(result.matrix), gameGrid.grid, tetramino.x.longValue() + 1L, tetramino.y))) {
        Number atomicTmp_1 = result.rotation;
        Number atomicTmp_2 = tetramino.x.longValue() + 1L;
        {
            /* Start of atomic statement */
          tetramino.rotation = atomicTmp_1;
          tetramino.x = atomicTmp_2;
        } /* End of atomic statement */

      } else {
        if (!(hasCollision(
            Utils.copy(result.matrix), gameGrid.grid, tetramino.x.longValue() - 1L, tetramino.y))) {
          Number atomicTmp_3 = result.rotation;
          Number atomicTmp_4 = tetramino.x.longValue() - 1L;
          {
              /* Start of atomic statement */
            tetramino.rotation = atomicTmp_3;
            tetramino.x = atomicTmp_4;
          } /* End of atomic statement */
        }
      }
    }
  }

  public Tetramino getRandomTetramino() {

    return new Tetramino(MATH.rand(Tetramino.getNumber().longValue() - 1L).longValue() + 1L);
  }

  public Boolean tetraminoHasCollisionInCoords(final Number x, final Number y) {

    for (Iterator iterator_7 = SeqUtil.inds(tetramino.getCurrentMatrix()).iterator();
        iterator_7.hasNext();
        ) {
      Number tetraminoY = (Number) iterator_7.next();
      {
        final VDMSeq line =
            Utils.copy(((VDMSeq) Utils.get(tetramino.getCurrentMatrix(), tetraminoY)));
        {
          for (Iterator iterator_8 = SeqUtil.inds(line).iterator(); iterator_8.hasNext(); ) {
            Number tetraminoX = (Number) iterator_8.next();
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

  public static Boolean hasCollision(
      final VDMSeq tetraminoMatrix, final VDMSeq gameGrid_1, final Number x, final Number y) {

    Boolean existsExpResult_1 = false;
    VDMSet set_3 = SeqUtil.inds(tetraminoMatrix);
    for (Iterator iterator_3 = set_3.iterator(); iterator_3.hasNext() && !(existsExpResult_1); ) {
      Number tetraminoY = ((Number) iterator_3.next());
      Boolean existsExpResult_2 = false;
      VDMSet set_4 = SeqUtil.inds(((VDMSeq) Utils.get(tetraminoMatrix, tetraminoY)));
      for (Iterator iterator_4 = set_4.iterator(); iterator_4.hasNext() && !(existsExpResult_2); ) {
        Number tetraminoX = ((Number) iterator_4.next());
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

        existsExpResult_2 = andResult_7;
      }
      existsExpResult_1 = existsExpResult_2;
    }
    return existsExpResult_1;
  }

  public String toString() {

    return "Tetris{"
        + "gameGrid := "
        + Utils.toString(gameGrid)
        + ", tetramino := "
        + Utils.toString(tetramino)
        + "}";
  }
}
