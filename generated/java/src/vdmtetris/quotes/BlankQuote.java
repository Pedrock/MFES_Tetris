package vdmtetris.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class BlankQuote {
  private static int hc = 0;
  private static BlankQuote instance = null;

  public BlankQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static BlankQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new BlankQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof BlankQuote;
  }

  public String toString() {

    return "<Blank>";
  }
}
