package org.fit_labs.labs2.Instructions;

import org.fit_labs.labs2.ExecutionContext.ExecutionContext;
import org.fit_labs.labs2.ExecutionContext.ExecutionContextException;

import java.util.List;

public class Sqrt implements Commands {
    @Override
    public void run(ExecutionContext context, List<String> args) {
        double x = context.popStackValue();
        if(x > 0){
            x = Math.sqrt(x);
            context.pushStackValue(x);
        } else{
            throw new ExecutionContextException("Sqrt with negative number can't complete, number can be > 0");
        }

    }
}
