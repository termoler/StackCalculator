package org.fit_labs.labs2.Instructions;

import org.fit_labs.labs2.ExecutionContext.ExecutionContext;

import java.util.List;

public class Push implements Command {
    @Override
    public void run(ExecutionContext context, List<String> args) {
        String nameValue = args.getFirst();
        context.pushStackValue(context.getValue(nameValue));
    }
}
