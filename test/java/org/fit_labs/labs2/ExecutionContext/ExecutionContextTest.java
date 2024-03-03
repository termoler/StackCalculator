package org.fit_labs.labs2.ExecutionContext;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExecutionContextTest {
    ExecutionContext context = new ExecutionContext();
    @Test
    void pushStackValue() {
        Assertions.assertThrows(ExecutionContextException.class, () -> {
            context.pushStackValue("sdf");
        });
        Assertions.assertThrows(ExecutionContextException.class, () -> {
            context.pushStackValue("1df");
        });
        Assertions.assertThrows(ExecutionContextException.class, () -> {
            context.pushStackValue("1/3");
        });
        Assertions.assertThrows(ExecutionContextException.class, () -> {
            context.pushStackValue("1 1");
        });
    }


    @Test
    void popStackValue() {
        Assertions.assertThrows(ExecutionContextException.class, () -> {
            context.popStackValue();
        });
    }

    @Test
    void addVariable() {
        Assertions.assertThrows(ExecutionContextException.class, () -> {
            context.addVariable("a", "4as");
        });
        Assertions.assertThrows(ExecutionContextException.class, () -> {
            context.addVariable("222", "2222");
        });
        Assertions.assertThrows(ExecutionContextException.class, () -> {
            context.addVariable("asd", "asd");
        });
    }

    @Test
    void getValue() {
        Assertions.assertThrows(ExecutionContextException.class, () -> {
            context.getValue("asd");
        });
        context.addVariable("asd", "123");
        Assertions.assertThrows(ExecutionContextException.class, () -> {
            context.getValue("qwerty");
        });
    }

    @Test
    void getTopStack() {
        Assertions.assertThrows(ExecutionContextException.class, () -> {
            context.getTopStack();
        });
    }

    @Test
    void printValue() {
        Assertions.assertThrows(ExecutionContextException.class, () -> {
            context.printValue("sdf");
        });
    }
}