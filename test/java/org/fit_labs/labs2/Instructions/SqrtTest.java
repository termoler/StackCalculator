package org.fit_labs.labs2.Instructions;

import org.fit_labs.labs2.ExecutionContext.ExecutionContext;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {
    ExecutionContext context = new ExecutionContext();

    @org.junit.jupiter.api.Test
    void correctEquals() {
        context.pushStackValue(4);
        double x = Math.sqrt(context.popStackValue());
        assertEquals(2, x);
    }

    @org.junit.jupiter.api.Test
    void incorrectEquals(){
        context.pushStackValue(4);
        double x = Math.sqrt(context.popStackValue());
        assertNotEquals(3, x);
    }
}