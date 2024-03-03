package org.fit_labs.labs2.Instructions;

import org.fit_labs.labs2.ExecutionContext.ExecutionContext;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DefineTest {
    ExecutionContext context = new ExecutionContext();
    List<String> args = new ArrayList<>();

    @org.junit.jupiter.api.Test
    void correctEquals() {
        args.add("x");
        args.add("2");
        context.addVariable(args.get(0), args.get(1));
        assertEquals(2, context.getValue(args.get(0)));
    }

    @org.junit.jupiter.api.Test
    void incorrectEquals(){
        args.add("x");
        args.add("2");
        context.addVariable(args.get(0), args.get(1));
        assertNotEquals(3, context.getValue(args.get(0))); 
    }
}