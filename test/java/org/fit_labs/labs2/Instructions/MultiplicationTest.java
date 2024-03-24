package org.fit_labs.labs2.Instructions;

import org.fit_labs.labs2.ExecutionContext.ExecutionContext;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {
    ExecutionContext context = new ExecutionContext();

    @org.junit.jupiter.api.Test
    void correctEquals() {
        context.pushStackValue(10.0);
        context.pushStackValue(2.0);
        double x = context.popStackValue() * context.popStackValue();
        assertEquals(20, x);
    }

    @org.junit.jupiter.api.Test
    void incorrectEquals(){
        context.pushStackValue(5.0);
        context.pushStackValue(10.0);
        double x = context.popStackValue() * context.popStackValue();
        assertNotEquals(4, x, 0.0);
    }
}