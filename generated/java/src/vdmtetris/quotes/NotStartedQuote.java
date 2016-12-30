package vdmtetris.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class NotStartedQuote {
  private static int hc = 0;
  private static NotStartedQuote instance = null;

  public NotStartedQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static NotStartedQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new NotStartedQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof NotStartedQuote;
  }

  public String toString() {

    return "<NotStarted>";
  }
}
