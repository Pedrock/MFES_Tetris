package vdmtetris.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CyanQuote {
  private static int hc = 0;
  private static CyanQuote instance = null;

  public CyanQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static CyanQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new CyanQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof CyanQuote;
  }

  public String toString() {

    return "<Cyan>";
  }
}
