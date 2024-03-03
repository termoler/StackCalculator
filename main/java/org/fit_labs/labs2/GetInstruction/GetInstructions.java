package org.fit_labs.labs2.GetInstruction;

import org.fit_labs.labs2.CheckCommands.CheckCommandException;
import org.fit_labs.labs2.Toolkit.Pair;
import org.fit_labs.labs2.Main;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class GetInstructions {
    public static List<Pair<String, String[]>> of(String commandsFilename,String configFilename) throws IOException, CheckCommandException {
        Main.logger.info("Selecting the mode for getting a list of commands and their arguments.\n");
        if (!configFilename.isEmpty()) {
            InstructionsFromFile iff = new InstructionsFromFile();
            return iff.getInstruction(commandsFilename, configFilename);
        } else {
            InstructionsFromStream ifs = new InstructionsFromStream();
            return ifs.getInstruction(commandsFilename);
        }
    }
}