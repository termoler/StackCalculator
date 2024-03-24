package org.fit_labs.labs2.Instructions;

import org.fit_labs.labs2.ExecutionContext.ExecutionContext;
import org.fit_labs.labs2.ExecutionContext.ExecutionContextException;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {
    ExecutionContext context = new ExecutionContext();
    List<String> args;
    Division div = new Division();

    @org.junit.jupiter.api.Test
    void correctEquals() {
        context.pushStackValue(2.0);
        context.pushStackValue(4.0);

        double x = context.popStackValue();
        double y = context.popStackValue();
        assertEquals(0.5,y/x);
    }

    @org.junit.jupiter.api.Test
    void incorrectEquals(){
        context.pushStackValue(15.0);
        context.pushStackValue(3.0);
        double x = context.popStackValue() / context.popStackValue();
        assertNotEquals(2, x, 0.0);
    }

    @org.junit.jupiter.api.Test
    void divZero(){
        context.pushStackValue(5.0);
        context.pushStackValue(0.0);
        Assertions.assertThrows(ExecutionContextException.class, () -> {
            div.run(context, args);
        });
    }
}