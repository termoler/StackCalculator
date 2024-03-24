package org.fit_labs.labs2.Instructions;

import org.fit_labs.labs2.ExecutionContext.ExecutionContext;

import java.util.List;

public class Define implements Command {
    @Override
    public void run(ExecutionContext context, List<String> args) {
        context.addVariable(args.get(0), args.get(1));
    }
}
