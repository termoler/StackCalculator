package org.fit_labs.labs2.GetInstruction;

import org.fit_labs.labs2.CheckCommands.CheckCommand;
import org.fit_labs.labs2.Main;
import org.fit_labs.labs2.Toolkit.Pair;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

public class InstructionsFromStream extends GetInstructions {
    public List<Pair<String, String[]>> getInstruction(String commandsFilename) throws IOException {
        Main.logger.info("Starting the mode of receiving commands from the stream.\n");
        CheckCommand cc = new CheckCommand(commandsFilename);
        List<Pair<String, String[]>> instructions = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String line;
        String[] lines;
        System.out.println("Enter command, if it's all, then you need to enter EXIT");

        while (true) {
            System.out.print("# ");
            line = in.nextLine().toUpperCase();
            if ("exit" .equalsIgnoreCase(line)) break;
            else {
                lines = line.split("\\s+");
                if (cc.checkCommandFromStream(lines[0])) {
                    instructions.add(new Pair<>(lines[0], (Arrays.copyOfRange(lines, 1, lines.length))));
                } else System.out.println("Enter command again");
            }
        }
        Main.logger.info("The commands were successfully received from stream.\n");
        return instructions;
    }
}

      