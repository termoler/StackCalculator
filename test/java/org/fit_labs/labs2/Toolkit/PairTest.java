package org.fit_labs.labs2.Toolkit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    @Test
    void testToString() {
        Pair<Integer, String> x = new Pair<>(1, "one");
        assertEquals(x.toString(), "1 one");
    }

    @Test
    void testEquals() {
        var x1 = new Pair<>(1, "one");
        var x2 = new Pair<>(1, "one");
        assertTrue(x1.equals(x2));
    }
}