package org.fit_labs.labs2.StackCalculator;

import org.fit_labs.labs2.CheckCommands.CheckCommandException;
import org.fit_labs.labs2.ExecutionContext.*;
import org.fit_labs.labs2.Factory.FactoryCommands;
import org.fit_labs.labs2.Factory.FactoryCommandsException;
import org.fit_labs.labs2.Main;
import org.fit_labs.labs2.Instructions.Commands;
import org.fit_labs.labs2.Toolkit.Pair;
import org.fit_labs.labs2.GetInstruction.GetInstructions;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class StackCalculator {
    private final ExecutionContext context = new ExecutionContext();
    private FactoryCommands<Commands> factoryCommands;
    private String commandsFilename;
    private String configFilename;
    public void init(String[] args) throws StackCalculatorException {
        if (args.length == 0) {
            throw new StackCalculatorException("You didn't enter filename with commands");
        }
        if (args.length > 2) {
            throw new StackCalculatorException("""
                You entered too many arguments.
                Please provide:
                1) Filename with commands.
                2) Filename with configuration(optional).
                """);
        }
        commandsFilename = args[0];
        configFilename = (args.length == 2) ? args[1] : "";
    }

    public void completeCalculate() throws IOException {
        Main.logger.info("Request for a list of commands and their arguments.\n");
        List<Pair<String, String[]>> instructions = null;
        try {
            instructions = GetInstructions.of(commandsFilename, configFilename);
            Main.logger.info("Instructions have been received.\n");
        } catch (CheckCommandException | IOException ex){
            Main.logger.warning("Instructions haven't been received:\n" + ex + "\n");
            Main.logger.warning("The calculation wasn't completed successfully.\n");
            System.exit(1);
        }

        Commands command;
        Method action;
        Main.logger.info("The beginning of the calculation:\n");


        factoryCommands = new FactoryCommands<>(commandsFilename);
        for (var instruction : instructions) {
            Main.logger.info("Performing a " + instruction.first + "\n");
            try{
                command = factoryCommands.get(instruction.first);
                action = Commands.class.getMethod("run", ExecutionContext.class, List.class);
                action.invoke(command, context, Arrays.asList(instruction.second));
                Main.logger.info("The " + instruction.first + " was executed successfully\n");
            } catch(FactoryCommandsException ex){
                Main.logger.warning("Mistake in Factory\n" + ex.getCause() + "\n");
                Main.logger.warning("The calculation wasn't completed successfully.\n");
                System.exit(1);
            } catch (ExecutionContextException | NoSuchMethodException | IllegalAccessException ex){
                Main.logger.warning("Mistake from Reflection Class\n" + ex.getCause() + "\n");
                Main.logger.warning("The calculation wasn't completed successfully.\n");
                System.exit(1);
            } catch (InvocationTargetException ex){
                Main.logger.warning(ex.getCause() + "\n");
                Main.logger.warning("The calculation wasn't completed successfully.\n");
                System.exit(1);
            }

//            Commands action = factoryCommands.get(instruction.first);
////            action.print();
//            action.run(context, Arrays.asList(instruction.second));

        }
        Main.logger.info("The calculation was completed successfully.\n");
    }
}
