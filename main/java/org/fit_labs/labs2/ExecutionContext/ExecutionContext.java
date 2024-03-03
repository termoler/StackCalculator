package org.fit_labs.labs2.ExecutionContext;

import org.fit_labs.labs2.Toolkit.*;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExecutionContext {
    private final Stack<Double> stack = new Stack<>();
    private final Map<String, Double> variables = new HashMap<>();
    private final CorrectValueUtil correctValueUtil = new CorrectValueUtil();
    private final PrintStream streamOut;

    public ExecutionContext(OutputStream stream){
        streamOut = new PrintStream(stream);
    }

    public ExecutionContext(){
        streamOut = System.out;
    }

    public void pushStackValue(Object value) {
        try {
            stack.push(Double.parseDouble(value.toString()));
        } catch (NumberFormatException ex) {
            throw new ExecutionContextException("Value is incorrect", ex);
        }

    }
    public Double popStackValue() {
        try {
            return stack.pop();
        } catch (EmptyStackException ex) {
            throw new ExecutionContextException(ex + "\n" + "The stack is empty, you need to PUSH the value of the variable to make a POP");
        } catch (ArrayIndexOutOfBoundsException ex){
            throw new ExecutionContextException(ex.toString());
        }
    }

    public void addVariable(Object name, Object value) {
        String nameData;
        double val;
        try {
            nameData = name.toString();
            val = Double.parseDouble(value.toString());
        } catch (NumberFormatException ex) {
            throw new ExecutionContextException("Value is incorrect: " + value.toString() + ". It isn't number");
        }

        if (!correctValueUtil.isAlphaWord(name.toString())) {
            throw new ExecutionContextException("Invalid variable name. The variable name must consist of letters.");
        }

        if (!correctValueUtil.isDigitWord(value.toString())) {
            throw new ExecutionContextException("Invalid numerical value for the variable.");
        }
        variables.put(nameData, val);
    }

    public Double getValue(String key) {
        if (variables.isEmpty()) {
            throw new ExecutionContextException("You have not fixed this variable and value, you need to add DEFINE in the config file before PUSH");
        }
        if (!correctValueUtil.isAlphaWord(key)) {
            throw new ExecutionContextException("You enter an incorrect argument to command PUSH: " + key + ", the name of the value must consist of letters");
        }

        if (!variables.containsKey(key)) {
            throw new ExecutionContextException("You have not fixed this variable {" + key + "} and value, you need to add DEFINE in the config file before PUSH");
        }
        return variables.get(key);
    }

    public Double getTopStack() {
        try {
            return stack.peek();
        } catch (java.util.EmptyStackException ex) {
            throw new ExecutionContextException(ex + "\n" + "The stack is empty, you need to PUSH the value of the variable to make a POP");
        }
    }

    public void printValue(String str) {
        if (stack.isEmpty()) {
            throw new ExecutionContextException("You need to do a DEFINE of the name of the" +
                    "value and the value, and then do a PUSH of the name of the value");
        }
        streamOut.println(str);
//        System.out.println(str);
    }
}
      