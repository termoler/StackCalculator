package org.fit_labs.labs2;

import org.fit_labs.labs2.CheckCommands.CheckCommandException;
import org.fit_labs.labs2.GetInstruction.InstructionsFromFile;
import org.fit_labs.labs2.GetInstruction.InstructionsFromStream;
import org.fit_labs.labs2.StackCalculator.*;
import org.fit_labs.labs2.Toolkit.Pair;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import java.io.IOException;
import java.util.List;

public class Main {
    public final static Logger logger = LogManager.getLogger(Main.class.getName());
    public static void main(String[] args){
        if(args.length == 0) args = new String[]{"calculate.txt"};

        Main.logger.info("Request for a list of commands and their arguments.\n");
        List<Pair<String, String[]>> instructions;
        try{
            Main.logger.info("Selecting the mode for getting a list of commands and their arguments.\n");
            if(args.length == 1){
                InstructionsFromFile iff = new InstructionsFromFile();
                instructions = iff.getInstruction(args);
            } else{
                InstructionsFromStream ifs = new InstructionsFromStream();
                instructions = ifs.getInstruction(args);
            }
            Main.logger.info("Instructions have been received.\n");
        } catch (IOException | CheckCommandException ex){
            Main.logger.error("Instructions haven't been received:\n" + ex + "\n");
            Main.logger.error("The calculation wasn't completed successfully.\n");
            System.out.println(ex);
            return;
        }

        logger.info("Create calculator\n");
        StackCalculator calculator = new StackCalculator();
        try {
            calculator.completeCalculate(instructions);
        } catch (IOException | StackCalculatorException ex) {
            System.out.println(ex);
            return;
        }
        System.out.println("Hello world!");
    }
}