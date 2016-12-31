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
  private VDMSeq tetraminoesBag = SeqUtil.seq();
  public Number score = 0L;
  public Number level = 0L;
  public Number numberOfLines = 0L;
  public Object gameState = vdmtetris.quotes.NotStartedQuote.getInstance();

  public void begin() {

    gameGrid = new GameGrid();
    tetramino = popTetraminoFromBag();
    nextTetramino = popTetraminoFromBag();
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
      onCollision();
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

    onCollision();
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

  private void onCollision() {

    gameGrid.addTetramino(tetramino);
    removeCompleteLines();
    {
      final VDMSeq line = Utils.copy(((VDMSeq) Utils.get(gameGrid.grid, GameGrid.VISIBLE_HEIGHT)));
      Boolean existsExpResult_1 = false;
      VDMSet set_6 = SeqUtil.inds(line);
      for (Iterator iterator_6 = set_6.iterator(); iterator_6.hasNext() && !(existsExpResult_1); ) {
        Number x = ((Number) iterator_6.next());
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
      nextTetramino = popTetraminoFromBag();
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
          Boolean forAllExpResult_5 = true;
          VDMSet set_9 = SeqUtil.inds(line);
          for (Iterator iterator_9 = set_9.iterator();
              iterator_9.hasNext() && forAllExpResult_5;
              ) {
            Number x = ((Number) iterator_9.next());
            forAllExpResult_5 =
                !(Utils.equals(Utils.get(line, x), vdmtetris.quotes.BlankQuote.getInstance()));
          }
          if (forAllExpResult_5) {
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

  private void tryRotation(final Tetramino.RotationResult rotation) {

    if (!(hasCollision(Utils.copy(rotation.matrix), gameGrid.grid, tetramino.x, tetramino.y))) {
      tetramino.rotation = rotation.rotation;
    } else {
      if (!(hasCollision(
          Utils.copy(rotation.matrix), gameGrid.grid, tetramino.x.longValue() + 1L, tetramino.y))) {
        Number atomicTmp_4 = rotation.rotation;
        Number atomicTmp_5 = tetramino.x.longValue() + 1L;
        {
            /* Start of atomic statement */
          tetramino.rotation = atomicTmp_4;
          tetramino.x = atomicTmp_5;
        } /* End of atomic statement */

      } else {
        if (!(hasCollision(
            Utils.copy(rotation.matrix),
            gameGrid.grid,
            tetramino.x.longValue() - 1L,
            tetramino.y))) {
          Number atomicTmp_6 = rotation.rotation;
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

  public Boolean tetraminoHasCollisionInCoords(final Number x, final Number y) {

    for (Iterator iterator_15 = SeqUtil.inds(tetramino.getCurrentMatrix()).iterator();
        iterator_15.hasNext();
        ) {
      Number tetraminoY = (Number) iterator_15.next();
      {
        final VDMSeq line =
            Utils.copy(((VDMSeq) Utils.get(tetramino.getCurrentMatrix(), tetraminoY)));
        {
          for (Iterator iterator_16 = SeqUtil.inds(line).iterator(); iterator_16.hasNext(); ) {
            Number tetraminoX = (Number) iterator_16.next();
            {
              final Number cellX = x.longValue() - 1L + tetraminoX.longValue();
              final Number cellY = y.longValue() + 1L - tetraminoY.longValue();
              {
                if (!(Utils.equals(
                    Utils.get(line, tetraminoX), vdmtetris.quotes.BlankQuote.getInstance()))) {
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
                                  gameGrid.getCell(cellX, cellY),
                                  vdmtetris.quotes.BlankQuote.getInstance()));
                        }

                        orResult_10 = orResult_11;
                      }

                      orResult_9 = orResult_10;
                    }

                    orResult_8 = orResult_9;
                  }

                  if (orResult_8) {
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

  private VDMSeq generateTetraminosBag() {

    VDMSeq seqCompResult_3 = SeqUtil.seq();
    VDMSet set_10 = SetUtil.range(1L, Tetramino.getNumber());
    for (Iterator iterator_10 = set_10.iterator(); iterator_10.hasNext(); ) {
      Number x = ((Number) iterator_10.next());
      seqCompResult_3.add(x);
    }
    VDMSeq bag = Utils.copy(seqCompResult_3);
    long toVar_2 = Tetramino.getNumber().longValue() - 1L;

    for (Long i = 1L; i <= toVar_2; i++) {
      Number j = MATH.rand(Tetramino.getNumber().longValue() - 1L).longValue() + 1L;
      Number tmp = ((Number) Utils.get(bag, i));
      Utils.mapSeqUpdate(bag, i, ((Number) Utils.get(bag, j)));
      Utils.mapSeqUpdate(bag, j, tmp);
    }
    return Utils.copy(bag);
  }

  private Tetramino popTetraminoFromBag() {

    if (Utils.equals(tetraminoesBag.size(), 0L)) {
      tetraminoesBag = generateTetraminosBag();
    }

    {
      final Tetramino t = new Tetramino(((Number) tetraminoesBag.get(0)));
      {
        tetraminoesBag = SeqUtil.tail(Utils.copy(tetraminoesBag));
        return t;
      }
    }
  }

  public Tetris() {}

  private static Boolean hasCollision(
      final VDMSeq tetraminoMatrix, final VDMSeq gameGrid_1, final Number x, final Number y) {

    Boolean existsExpResult_3 = false;
    VDMSet set_11 = SeqUtil.inds(tetraminoMatrix);
    for (Iterator iterator_11 = set_11.iterator();
        iterator_11.hasNext() && !(existsExpResult_3);
        ) {
      Number tetraminoY = ((Number) iterator_11.next());
      Boolean existsExpResult_4 = false;
      VDMSet set_12 = SeqUtil.inds(((VDMSeq) Utils.get(tetraminoMatrix, tetraminoY)));
      for (Iterator iterator_12 = set_12.iterator();
          iterator_12.hasNext() && !(existsExpResult_4);
          ) {
        Number tetraminoX = ((Number) iterator_12.next());
        Boolean andResult_20 = false;

        if (!(Utils.equals(
            Utils.get(((VDMSeq) Utils.get(tetraminoMatrix, tetraminoY)), tetraminoX),
            vdmtetris.quotes.BlankQuote.getInstance()))) {
          final Number cellX = x.longValue() - 1L + tetraminoX.longValue();
          final Number cellY = y.longValue() + 1L - tetraminoY.longValue();

          Boolean orResult_13 = false;

          if (cellX.longValue() < 1L) {
            orResult_13 = true;
          } else {
            Boolean orResult_14 = false;

            if (cellX.longValue() > GameGrid.WIDTH.longValue()) {
              orResult_14 = true;
            } else {
              Boolean orResult_15 = false;

              if (cellY.longValue() < 1L) {
                orResult_15 = true;
              } else {
                Boolean orResult_16 = false;

                if (cellY.longValue() > GameGrid.HEIGHT.longValue()) {
                  orResult_16 = true;
                } else {
                  orResult_16 =
                      !(Utils.equals(
                          Utils.get(((VDMSeq) Utils.get(gameGrid_1, cellY)), cellX),
                          vdmtetris.quotes.BlankQuote.getInstance()));
                }

                orResult_15 = orResult_16;
              }

              orResult_14 = orResult_15;
            }

            orResult_13 = orResult_14;
          }

          if (orResult_13) {
            andResult_20 = true;
          }
        }

        existsExpResult_4 = andResult_20;
      }
      existsExpResult_3 = existsExpResult_4;
    }
    return existsExpResult_3;
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
        + ", tetraminoesBag := "
        + Utils.toString(tetraminoesBag)
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
