package org.fit_labs.labs2.GetInstruction;

import org.fit_labs.labs2.CheckCommands.CheckCommandException;
import org.fit_labs.labs2.ExecutionContext.ExecutionContextException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InstructionsFromFileTxtTest {
    InstructionsFromFile iff = new InstructionsFromFile();
    @Test
    void getInstruction() {
        Assertions.assertThrows(IOException.class, () -> {
            iff.getInstruction(new String[]{"sdfs"});
        });
        Assertions.assertThrows(CheckCommandException.class, () -> {
            iff.getInstruction(new String[]{"noExistCommands.txt"});
        });

    }
}