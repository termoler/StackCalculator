package org.fit_labs.labs2.Instructions;

import org.fit_labs.labs2.ExecutionContext.ExecutionContext;
import java.util.List;

public class Pop implements Command {
    @Override
    public void run(ExecutionContext context, List<String> args) {
        context.popStackValue();
    }
}
