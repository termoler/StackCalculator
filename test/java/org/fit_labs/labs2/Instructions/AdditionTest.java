package org.fit_labs.labs2.Instructions;

import org.fit_labs.labs2.ExecutionContext.ExecutionContext;
import static org.junit.jupiter.api.Assertions.*;

class AdditionTest {

    ExecutionContext context = new ExecutionContext();

    @org.junit.jupiter.api.Test
    void correctEquals() {
        context.pushStackValue(1);
        context.pushStackValue(2);
        double x = context.popStackValue() + context.popStackValue();
        assertEquals(3, x);
    }

    @org.junit.jupiter.api.Test
    void incorrectEquals(){
        context.pushStackValue(5);
        context.pushStackValue(10);
        double x = context.popStackValue() + context.popStackValue();
        assertNotEquals(16, x, 0.0);
    }
}