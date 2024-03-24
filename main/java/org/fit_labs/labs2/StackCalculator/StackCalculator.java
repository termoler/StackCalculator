package org.fit_labs.labs2.StackCalculator;

import org.fit_labs.labs2.ExecutionContext.*;
import org.fit_labs.labs2.Factory.Factory;
import org.fit_labs.labs2.Factory.FactoryCommandsException;
import org.fit_labs.labs2.Main;
import org.fit_labs.labs2.Instructions.Command;
import org.fit_labs.labs2.Toolkit.Pair;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class StackCalculator {
    private final ExecutionContext context = new ExecutionContext();
    public void completeCalculate(List<Pair<String, String[]>> instructions) throws IOException, StackCalculatorException {
        Command command;
        Method action;
        Main.logger.info("The beginning of the calculation:\n");

        Factory<Command> factoryCommands = new Factory<>();
        for (var instruction : instructions) {
            Main.logger.info("Performing a " + instruction.first + "\n");
            try{
                command = factoryCommands.get(instruction.first);
                action = Command.class.getMethod("run", ExecutionContext.class, List.class);
                action.invoke(command, context, Arrays.asList(instruction.second));
                Main.logger.info("The " + instruction.first + " was executed successfully\n");
            } catch(FactoryCommandsException ex){
                Main.logger.error("Mistake in Factory\n" + ex.getCause() + "\n");
                Main.logger.error("The calculation wasn't completed successfully.\n");
                throw new StackCalculatorException(ex.toString());
            } catch (ExecutionContextException | NoSuchMethodException | IllegalAccessException ex){
                Main.logger.error("Mistake from Reflection Class\n" + ex.getCause() + "\n");
                Main.logger.error("The calculation wasn't completed successfully.\n");
                throw new StackCalculatorException(ex.toString());
            } catch (InvocationTargetException ex){
                Main.logger.error(ex.getCause() + "\n");
                Main.logger.error("The calculation wasn't completed successfully.\n");
                throw new StackCalculatorException(ex.toString());
            }
        }
        Main.logger.info("The calculation was completed successfully.\n");
    }
}
