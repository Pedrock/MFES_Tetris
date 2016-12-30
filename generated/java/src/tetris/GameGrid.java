package tetris;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class GameGrid {
  public static final Number HEIGHT = 22L;
  public static final Number WIDTH = 10L;
  public VDMSeq grid = buildEmptyGrid(GameGrid.WIDTH, GameGrid.HEIGHT);

  public Object getCell(final Number x, final Number y) {

    return Utils.get(((VDMSeq) Utils.get(grid, y)), x);
  }

  public void addTetramino(final Tetramino tetramino) {

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
              final Number cellX = tetramino.x.longValue() - 1L + tetraminoX.longValue();
              final Number cellY = tetramino.y.longValue() + 1L - tetraminoY.longValue();
              {
                if (!(Utils.equals(
                    Utils.get(line, tetraminoX), tetris.quotes.BlankQuote.getInstance()))) {
                  Utils.mapSeqUpdate(
                      ((VDMSeq) Utils.get(grid, cellY)), cellX, Utils.get(line, tetraminoX));
                }
              }
            }
          }
        }
      }
    }
  }

  public void removeLine(final Number y) {

    long toVar_1 = GameGrid.HEIGHT.longValue() - 1L;

    for (Long i = y.longValue(); i <= toVar_1; i++) {
      Utils.mapSeqUpdate(grid, i, Utils.copy(((VDMSeq) Utils.get(grid, i.longValue() + 1L))));
    }
    Utils.mapSeqUpdate(grid, GameGrid.HEIGHT, buildEmptyRow(GameGrid.WIDTH));
  }

  public GameGrid() {}

  private static VDMSeq buildEmptyRow(final Number length) {

    VDMSeq seqCompResult_1 = SeqUtil.seq();
    VDMSet set_1 = SetUtil.range(1L, length);
    for (Iterator iterator_1 = set_1.iterator(); iterator_1.hasNext(); ) {
      Number v = ((Number) iterator_1.next());
      if (v.longValue() > 0L) {
        seqCompResult_1.add(tetris.quotes.BlankQuote.getInstance());
      }
    }
    return Utils.copy(seqCompResult_1);
  }

  private static VDMSeq buildEmptyGrid(final Number width, final Number height) {

    VDMSeq seqCompResult_2 = SeqUtil.seq();
    VDMSet set_2 = SetUtil.range(1L, height);
    for (Iterator iterator_2 = set_2.iterator(); iterator_2.hasNext(); ) {
      Number v = ((Number) iterator_2.next());
      if (v.longValue() > 0L) {
        seqCompResult_2.add(buildEmptyRow(width));
      }
    }
    return Utils.copy(seqCompResult_2);
  }

  public String toString() {

    return "GameGrid{"
        + "HEIGHT = "
        + Utils.toString(HEIGHT)
        + ", WIDTH = "
        + Utils.toString(WIDTH)
        + ", grid := "
        + Utils.toString(grid)
        + "}";
  }
}
