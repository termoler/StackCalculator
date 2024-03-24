package org.fit_labs.labs2.Instructions;

import org.fit_labs.labs2.ExecutionContext.ExecutionContext;

import static org.junit.jupiter.api.Assertions.*;

class PopTest {
    ExecutionContext context = new ExecutionContext();

    @org.junit.jupiter.api.Test
    void correctEquals() {
        context.pushStackValue(1.0);
        assertEquals(1, context.popStackValue());
    }

    @org.junit.jupiter.api.Test
    void incorrectEquals() {
        context.pushStackValue(5.0);
        assertNotEquals(1, context.popStackValue(), 0.0);
    }
}