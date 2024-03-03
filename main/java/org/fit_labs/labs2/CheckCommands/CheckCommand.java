package org.fit_labs.labs2.CheckCommands;

import org.fit_labs.labs2.Instructions.Commands;
import java.io.IOException;
import org.fit_labs.labs2.Factory.FactoryCommands;

public class CheckCommand {
    private final FactoryCommands<Commands> factory;
    public CheckCommand(String commandsFilename) throws IOException {
        factory = new FactoryCommands<>(commandsFilename);
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
