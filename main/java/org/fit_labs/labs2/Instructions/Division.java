package org.fit_labs.labs2.Instructions;

import org.fit_labs.labs2.ExecutionContext.ExecutionContext;
import org.fit_labs.labs2.ExecutionContext.ExecutionContextException;

import java.util.List;

public class Division implements Commands {
    @Override
    public void run(ExecutionContext context, List<String> args) {
        double x = context.popStackValue();
        double y = context.popStackValue();
        if(x != 0){
            context.pushStackValue(y/x);
        } else throw new ExecutionContextException("/ by zero");
    }
}
