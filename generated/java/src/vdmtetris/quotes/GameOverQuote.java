package vdmtetris.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class GameOverQuote {
  private static int hc = 0;
  private static GameOverQuote instance = null;

  public GameOverQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static GameOverQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new GameOverQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof GameOverQuote;
  }

  public String toString() {

    return "<GameOver>";
  }
}
