package org.fit_labs.labs2.GetInstruction;

import org.fit_labs.labs2.CheckCommands.CheckCommandException;
import org.fit_labs.labs2.Toolkit.Pair;
import org.fit_labs.labs2.Main;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public interface Instruction {
    List<Pair<String, String[]>> getInstruction(String[] args) throws IOException, CheckCommandException;
}
