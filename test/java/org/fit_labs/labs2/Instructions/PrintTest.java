package org.fit_labs.labs2.Instructions;

import org.fit_labs.labs2.ExecutionContext.ExecutionContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PrintTest {
    @org.junit.jupiter.api.Test
    void correctEquals() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ExecutionContext context = new ExecutionContext(baos);

        context.pushStackValue(4.0);
        try(PrintStream stream = new PrintStream(baos))
        {
            context.printValue(context.getTopStack().toString());
        }
        String result = baos.toString();
        assertEquals("4.0\r\n", result);
    }

    @org.junit.jupiter.api.Test
    void incorrectEquals(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ExecutionContext context = new ExecutionContext(baos);

        context.pushStackValue(4.0);
        try(PrintStream stream = new PrintStream(baos))
        {
            context.printValue(context.getTopStack().toString());
        }
        String result = baos.toString();
        assertNotEquals("3.0\r\n", result);
    }

}