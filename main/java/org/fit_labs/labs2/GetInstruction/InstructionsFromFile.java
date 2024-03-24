package org.fit_labs.labs2.GetInstruction;

import org.fit_labs.labs2.CheckCommands.CheckCommand;
import org.fit_labs.labs2.CheckCommands.CheckCommandException;
import org.fit_labs.labs2.Main;
import org.fit_labs.labs2.Toolkit.Pair;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class InstructionsFromFile {
    private String[] getLines(String configFilename) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        BufferedReader reader;
        String[] lines = new String[]{};
        try(InputStream is = classloader.getResourceAsStream(configFilename)) {
            assert is != null;
            reader = new BufferedReader(new InputStreamReader(is));
            lines = reader.lines().toArray(String[]::new);
        } catch (NullPointerException ex) {
            throw new IOException(ex + ": " + "The problem with finding the file, you need to config.txt upload to the resource folder");
        }
        return lines;
    }
    public List<Pair<String, String[]>> getInstruction(String[] args) throws IOException, CheckCommandException {
        Main.logger.info("Start the mode of receiving commands from the configuration file.\n");
        CheckCommand cc = new CheckCommand();
        String configFilename = args[0];

        List<Pair<String, String[]>> instructions = new ArrayList<>();

        String[] lines = getLines(configFilename);
        String[] parts;

        for (String line : lines) {
            parts = line.split("\\s+");
            if (cc.checkCommandFromFile(parts[0])) {
                instructions.add(new Pair<>(parts[0].toUpperCase(Locale.ROOT), Arrays.copyOfRange(parts, 1, parts.length)));
            } else {
                Main.logger.error("The commands weren't successfully received from the configuration file.\n");
                throw new CheckCommandException("You entered an incorrect command " + parts[0] + " in file " + configFilename);
            }
        }
        Main.logger.info("The commands were successfully received from the configuration file.\n");
        return instructions;
    }
}