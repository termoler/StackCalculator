package org.fit_labs.labs2.Instructions;

import org.fit_labs.labs2.ExecutionContext.ExecutionContext;

import java.util.List;

public interface Command {
    void run(ExecutionContext context, List<String> args);
}
