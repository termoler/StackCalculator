package org.fit_labs.labs2.Toolkit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorrectValueUtilTest {
    CorrectValueUtil cvu = new CorrectValueUtil();

    @Test
    void isAlphaWord() {
        assertFalse(cvu.isAlphaWord("1234"));
        assertFalse(cvu.isAlphaWord("  112"));
        assertFalse(cvu.isAlphaWord("\r\n\t"));
        assertFalse(cvu.isAlphaWord("   "));
        assertFalse(cvu.isAlphaWord("$%^@#$"));
    }

    @Test
    void isDigitWord() {
        assertFalse(cvu.isDigitWord("asdfq"));
        assertFalse(cvu.isDigitWord("  112"));
        assertFalse(cvu.isDigitWord("\r\n\t"));
        assertFalse(cvu.isDigitWord("   "));
        assertFalse(cvu.isDigitWord("$%^@#$"));
    }
}