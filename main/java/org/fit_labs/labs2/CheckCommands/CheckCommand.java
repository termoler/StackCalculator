package org.fit_labs.labs2.CheckCommands;

import org.fit_labs.labs2.Instructions.Command;
import java.io.IOException;
import org.fit_labs.labs2.Factory.Factory;

public class CheckCommand {
    private final Factory<Command> factory;
    public CheckCommand() throws IOException {
        factory = new Factory<>();
    }
    private boolean isSharp(char symbol){
        return symbol == '#';
    }
    public boolean checkCommandFromFile(String command) {
        if(factory.containsKeyProperties(command.toUpperCase())){
            return true;
        } else return command.isEmpty() || isSharp(command.charAt(0));
    }

    public boolean checkCommandFromStream(String command){
        return factory.containsKeyProperties(command);
    }
}
