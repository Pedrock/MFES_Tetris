package tetris;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Tetramino {
  private static final VDMSeq tetraminoes =
      SeqUtil.seq(
          SeqUtil.seq(
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.CyanQuote.getInstance(),
                      tetris.quotes.CyanQuote.getInstance(),
                      tetris.quotes.CyanQuote.getInstance(),
                      tetris.quotes.CyanQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.CyanQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.CyanQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.CyanQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.CyanQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.CyanQuote.getInstance(),
                      tetris.quotes.CyanQuote.getInstance(),
                      tetris.quotes.CyanQuote.getInstance(),
                      tetris.quotes.CyanQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.CyanQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.CyanQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.CyanQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.CyanQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()))),
          SeqUtil.seq(
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlueQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlueQuote.getInstance(),
                      tetris.quotes.BlueQuote.getInstance(),
                      tetris.quotes.BlueQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlueQuote.getInstance(),
                      tetris.quotes.BlueQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlueQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlueQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlueQuote.getInstance(),
                      tetris.quotes.BlueQuote.getInstance(),
                      tetris.quotes.BlueQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlueQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlueQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlueQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlueQuote.getInstance(),
                      tetris.quotes.BlueQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()))),
          SeqUtil.seq(
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.OrangeQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.OrangeQuote.getInstance(),
                      tetris.quotes.OrangeQuote.getInstance(),
                      tetris.quotes.OrangeQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.OrangeQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.OrangeQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.OrangeQuote.getInstance(),
                      tetris.quotes.OrangeQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.OrangeQuote.getInstance(),
                      tetris.quotes.OrangeQuote.getInstance(),
                      tetris.quotes.OrangeQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.OrangeQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.OrangeQuote.getInstance(),
                      tetris.quotes.OrangeQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.OrangeQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.OrangeQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()))),
          SeqUtil.seq(
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.YellowQuote.getInstance(),
                      tetris.quotes.YellowQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.YellowQuote.getInstance(),
                      tetris.quotes.YellowQuote.getInstance()))),
          SeqUtil.seq(
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.GreenQuote.getInstance(),
                      tetris.quotes.GreenQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.GreenQuote.getInstance(),
                      tetris.quotes.GreenQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.GreenQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.GreenQuote.getInstance(),
                      tetris.quotes.GreenQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.GreenQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.GreenQuote.getInstance(),
                      tetris.quotes.GreenQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.GreenQuote.getInstance(),
                      tetris.quotes.GreenQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.GreenQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.GreenQuote.getInstance(),
                      tetris.quotes.GreenQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.GreenQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()))),
          SeqUtil.seq(
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.PurpleQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.PurpleQuote.getInstance(),
                      tetris.quotes.PurpleQuote.getInstance(),
                      tetris.quotes.PurpleQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.PurpleQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.PurpleQuote.getInstance(),
                      tetris.quotes.PurpleQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.PurpleQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.PurpleQuote.getInstance(),
                      tetris.quotes.PurpleQuote.getInstance(),
                      tetris.quotes.PurpleQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.PurpleQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.PurpleQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.PurpleQuote.getInstance(),
                      tetris.quotes.PurpleQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.PurpleQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()))),
          SeqUtil.seq(
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.RedQuote.getInstance(),
                      tetris.quotes.RedQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.RedQuote.getInstance(),
                      tetris.quotes.RedQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.RedQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.RedQuote.getInstance(),
                      tetris.quotes.RedQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.RedQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.RedQuote.getInstance(),
                      tetris.quotes.RedQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.RedQuote.getInstance(),
                      tetris.quotes.RedQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.RedQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.RedQuote.getInstance(),
                      tetris.quotes.RedQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      tetris.quotes.RedQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance(),
                      tetris.quotes.BlankQuote.getInstance()))));
  public Number rotation = 1L;
  public VDMSeq rotationsList;
  public Number x = Utils.divide((1.0 * GameGrid.WIDTH.longValue()), 2L);
  public Number y = GameGrid.HEIGHT;

  public void cg_init_Tetramino_1(final Number number) {

    rotationsList = Utils.copy(((VDMSeq) Utils.get(tetraminoes, number)));
    x =
        Utils.divide((1.0 * GameGrid.WIDTH.longValue()), 2L)
            - Math.round(
                Utils.floor(
                    Utils.divide((1.0 * ((VDMSeq) Utils.get(tetraminoes, number)).size()), 4L)));
    return;
  }

  public Tetramino(final Number number) {

    cg_init_Tetramino_1(number);
  }

  public RotationResult getRightRotation() {

    {
      final Number newRotation = Utils.mod(rotation.longValue(), rotationsList.size()) + 1L;
      {
        return new RotationResult(newRotation, ((VDMSeq) Utils.get(rotationsList, newRotation)));
      }
    }
  }

  public RotationResult getLeftRotation() {

    if (Utils.equals(rotation, 1L)) {
      return new RotationResult(
          rotationsList.size(), ((VDMSeq) Utils.get(rotationsList, rotationsList.size())));

    } else {
      return new RotationResult(
          rotation.longValue() - 1L,
          ((VDMSeq) Utils.get(rotationsList, rotation.longValue() - 1L)));
    }
  }

  public VDMSeq getCurrentMatrix() {

    return Utils.copy(((VDMSeq) Utils.get(rotationsList, rotation)));
  }

  public Tetramino() {}

  public static Number getNumber() {

    return Tetramino.tetraminoes.size();
  }

  public String toString() {

    return "Tetramino{"
        + "tetraminoes = "
        + Utils.toString(tetraminoes)
        + ", rotation := "
        + Utils.toString(rotation)
        + ", rotationsList := "
        + Utils.toString(rotationsList)
        + ", x := "
        + Utils.toString(x)
        + ", y := "
        + Utils.toString(y)
        + "}";
  }

  public static class RotationResult implements Record {
    public Number rotation;
    public VDMSeq matrix;

    public RotationResult(final Number _rotation, final VDMSeq _matrix) {

      rotation = _rotation;
      matrix = _matrix != null ? Utils.copy(_matrix) : null;
    }

    public boolean equals(final Object obj) {

      if (!(obj instanceof RotationResult)) {
        return false;
      }

      RotationResult other = ((RotationResult) obj);

      return (Utils.equals(rotation, other.rotation)) && (Utils.equals(matrix, other.matrix));
    }

    public int hashCode() {

      return Utils.hashCode(rotation, matrix);
    }

    public RotationResult copy() {

      return new RotationResult(rotation, matrix);
    }

    public String toString() {

      return "mk_Tetramino`RotationResult" + Utils.formatFields(rotation, matrix);
    }
  }
}
