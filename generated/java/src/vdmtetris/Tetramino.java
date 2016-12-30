package vdmtetris;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Tetramino {
  private static final VDMSeq tetraminoes =
      SeqUtil.seq(
          SeqUtil.seq(
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.CyanQuote.getInstance(),
                      vdmtetris.quotes.CyanQuote.getInstance(),
                      vdmtetris.quotes.CyanQuote.getInstance(),
                      vdmtetris.quotes.CyanQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.CyanQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.CyanQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.CyanQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.CyanQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.CyanQuote.getInstance(),
                      vdmtetris.quotes.CyanQuote.getInstance(),
                      vdmtetris.quotes.CyanQuote.getInstance(),
                      vdmtetris.quotes.CyanQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.CyanQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.CyanQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.CyanQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.CyanQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()))),
          SeqUtil.seq(
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlueQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlueQuote.getInstance(),
                      vdmtetris.quotes.BlueQuote.getInstance(),
                      vdmtetris.quotes.BlueQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlueQuote.getInstance(),
                      vdmtetris.quotes.BlueQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlueQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlueQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlueQuote.getInstance(),
                      vdmtetris.quotes.BlueQuote.getInstance(),
                      vdmtetris.quotes.BlueQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlueQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlueQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlueQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlueQuote.getInstance(),
                      vdmtetris.quotes.BlueQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()))),
          SeqUtil.seq(
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.OrangeQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.OrangeQuote.getInstance(),
                      vdmtetris.quotes.OrangeQuote.getInstance(),
                      vdmtetris.quotes.OrangeQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.OrangeQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.OrangeQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.OrangeQuote.getInstance(),
                      vdmtetris.quotes.OrangeQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.OrangeQuote.getInstance(),
                      vdmtetris.quotes.OrangeQuote.getInstance(),
                      vdmtetris.quotes.OrangeQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.OrangeQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.OrangeQuote.getInstance(),
                      vdmtetris.quotes.OrangeQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.OrangeQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.OrangeQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()))),
          SeqUtil.seq(
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.YellowQuote.getInstance(),
                      vdmtetris.quotes.YellowQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.YellowQuote.getInstance(),
                      vdmtetris.quotes.YellowQuote.getInstance()))),
          SeqUtil.seq(
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.GreenQuote.getInstance(),
                      vdmtetris.quotes.GreenQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.GreenQuote.getInstance(),
                      vdmtetris.quotes.GreenQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.GreenQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.GreenQuote.getInstance(),
                      vdmtetris.quotes.GreenQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.GreenQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.GreenQuote.getInstance(),
                      vdmtetris.quotes.GreenQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.GreenQuote.getInstance(),
                      vdmtetris.quotes.GreenQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.GreenQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.GreenQuote.getInstance(),
                      vdmtetris.quotes.GreenQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.GreenQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()))),
          SeqUtil.seq(
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.PurpleQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.PurpleQuote.getInstance(),
                      vdmtetris.quotes.PurpleQuote.getInstance(),
                      vdmtetris.quotes.PurpleQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.PurpleQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.PurpleQuote.getInstance(),
                      vdmtetris.quotes.PurpleQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.PurpleQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.PurpleQuote.getInstance(),
                      vdmtetris.quotes.PurpleQuote.getInstance(),
                      vdmtetris.quotes.PurpleQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.PurpleQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.PurpleQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.PurpleQuote.getInstance(),
                      vdmtetris.quotes.PurpleQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.PurpleQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()))),
          SeqUtil.seq(
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.RedQuote.getInstance(),
                      vdmtetris.quotes.RedQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.RedQuote.getInstance(),
                      vdmtetris.quotes.RedQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.RedQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.RedQuote.getInstance(),
                      vdmtetris.quotes.RedQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.RedQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.RedQuote.getInstance(),
                      vdmtetris.quotes.RedQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.RedQuote.getInstance(),
                      vdmtetris.quotes.RedQuote.getInstance())),
              SeqUtil.seq(
                  SeqUtil.seq(
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.RedQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.RedQuote.getInstance(),
                      vdmtetris.quotes.RedQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()),
                  SeqUtil.seq(
                      vdmtetris.quotes.RedQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance(),
                      vdmtetris.quotes.BlankQuote.getInstance()))));
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
