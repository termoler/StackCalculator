package org.fit_labs.labs2.Instructions;

import org.fit_labs.labs2.ExecutionContext.ExecutionContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PushTest {
    ExecutionContext context = new ExecutionContext();
    List<String> args = new ArrayList<>();

    @org.junit.jupiter.api.Test
    void correctEquals() {
        context.addVariable("a", 5);

        args.add("a");
        String nameValue = args.getFirst();

        context.pushStackValue(context.getValue(nameValue));

        assertEquals(5, context.popStackValue());
    }

    @org.junit.jupiter.api.Test
    void incorrectEquals(){
        context.addVariable("a", 5);

        args.add("a");
        String nameValue = args.getFirst();

        context.pushStackValue(context.getValue(nameValue));

        assertNotEquals(6, context.popStackValue());
    }
}