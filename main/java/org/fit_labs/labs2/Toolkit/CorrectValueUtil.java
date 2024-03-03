package org.fit_labs.labs2.Toolkit;

public class CorrectValueUtil {
    public boolean isAlphaWord(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public boolean isDigitWord(String name) {
        return name.matches("[-0-9]+");
    }
}
  