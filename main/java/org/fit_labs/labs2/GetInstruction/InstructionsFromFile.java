package org.fit_labs.labs2.GetInstruction;

import org.fit_labs.labs2.CheckCommands.CheckCommand;
import org.fit_labs.labs2.CheckCommands.CheckCommandException;
import org.fit_labs.labs2.Main;
import org.fit_labs.labs2.Toolkit.Pair;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class InstructionsFromFile extends GetInstructions {
    private String[] getLines(String configFilename) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        BufferedReader reader;
        InputStream is;
        try {
            is = classloader.getResourceAsStream(configFilename);
            reader = new BufferedReader(new InputStreamReader(is));
        } catch (NullPointerException ex) {
            throw new IOException(ex + ": " + "The problem with finding the file, you need to config.txt upload to the resource folder");
        }
        return reader.lines().toArray(String[]::new);
    }
    public List<Pair<String, String[]>> getInstruction(String commandsFilename, String configFilename) throws IOException, CheckCommandException {
        Main.logger.info("Start the mode of receiving commands from the configuration file.\n");
        CheckCommand cc = new CheckCommand(commandsFilename);

        List<Pair<String, String[]>> instructions = new ArrayList<>();

        String[] lines = getLines(configFilename);
        String[] parts;

        for (String line : lines) {
            parts = line.split("\\s+");
            if (cc.checkCommandFromFile(parts[0])) {
                instructions.add(new Pair<>(parts[0].toUpperCase(Locale.ROOT), Arrays.copyOfRange(parts, 1, parts.length)));
            } else {
                Main.logger.warning("The commands weren't successfully received from the configuration file.\n");
                throw new CheckCommandException("You entered an incorrect command " + parts[0] + " in file " + configFilename);
            }
        }
        Main.logger.info("The commands were successfully received from the configuration file.\n");
        return instructions;
    }
}
//        reader.lines()
//                .map(line -> line.split("\\s+"))
//                .forEach(parts -> {
//                    if (cc.checkCommandFromFile(parts[0]))
//                        instructions.add(new Pair<>(parts[0], (Arrays.copyOfRange(parts, 1, parts.length))));
//                    else{
//                        throw new CheckCommandException("You enter incorrect command " + parts[0] + " in file " + filename);
//                    }
//                });
//        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\misai\\IdeaProjects\\StackCalculator\\StackCalculator\\src\\main\\java\\org\\fit_labs\\labs2\\calculate.txt"))) {
//            reader.lines()
//                    .map(line -> line.split("\\s+"))
//                    .forEach(parts -> {
//                            if (cc.checkCommandFromFile(parts[0]))
//                                instructions.add(new Pair<>(parts[0], (Arrays.copyOfRange(parts, 1, parts.length))));
//                            else{
//                                throw new CheckCommandException("You enter incorrect command in file " + filename);
//                            }
//                    });
//        } catch 