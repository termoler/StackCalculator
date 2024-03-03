package org.fit_labs.labs2;

import org.fit_labs.labs2.StackCalculator.*;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args){
        if(args.length == 0) args = new String[]{"commandsFactory.txt", "calculate.txt"};
        logger.info("Create calculator\n");
        StackCalculator calculator = new StackCalculator();
        try {
            calculator.init(args);
            calculator.completeCalculate();
        } catch (IOException | StackCalculatorException ex) {
            ex.printStackTrace();
        }
        System.out.println("Hello world!");
    }
}


//        try{
//            Handler hnd = new FileHandler();
//            logger.addHandler(hnd);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }