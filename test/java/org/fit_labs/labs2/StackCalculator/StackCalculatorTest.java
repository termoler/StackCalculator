package org.fit_labs.labs2.StackCalculator;

import org.fit_labs.labs2.ExecutionContext.ExecutionContextException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackCalculatorTest {
    StackCalculator calculator = new StackCalculator();
    String[] args;

    @Test
    void init() {
        args = new String[]{};
        assertThrows(StackCalculatorException.class, () -> {
            calculator.init(args);
        });

        args = new String[]{"1" , "2", "3"};
        assertThrows(StackCalculatorException.class, () -> {
            calculator.init(args);
        });
    }
}