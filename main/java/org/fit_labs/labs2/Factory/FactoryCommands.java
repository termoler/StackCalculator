package org.fit_labs.labs2.Factory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class FactoryCommands<Base> {
    private final Properties classes = new Properties();
    public FactoryCommands(String commandsFilename) throws IOException {
        try {
            ClassLoader cl = getClass().getClassLoader();
            InputStream in = cl.getResourceAsStream(commandsFilename);
            classes.load(in);
        } catch (IOException | NullPointerException ex) {
            throw new IOException(ex + ":\n" + "Error loading commands properties file, you need create file with commands in resource folder");
        }
    }
    public FactoryCommands() throws IOException {
        try {
            ClassLoader cl = getClass().getClassLoader();
            InputStream in = cl.getResourceAsStream("commandsFactory.txt");
            classes.load(in);
        } catch (IOException | NullPointerException ex) {
            throw new IOException(ex + ":\n" + "Error loading commands properties file, you need create file with commands in resource folder");
        }
    }

    public Base get(String id) throws FactoryCommandsException {
        Base product = null;
        try {
            String className = classes.getProperty(id);
            if (className != null) {
                Class<?> classObject = Class.forName(className);
                Constructor<Base> constructor = (Constructor<Base>) classObject.getConstructor();
                product = constructor.newInstance();
            } else {
                throw new RuntimeException("Class don't found for ID: " + id);
            }
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new FactoryCommandsException(e);
        }
        return product;
    }
    public boolean containsKeyProperties(String key){
        return classes.containsKey(key);
    }
}
//public class FactoryCommands<Base> {
//    private final Properties classes = new Properties();
//    FactoryCommands(String commandsFilename) {
//        try {
//            ClassLoader cl = getClass().getClassLoader();
//            InputStream in = cl.getResourceAsStream(commandsFilename);
//            classes.load(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    FactoryCommands() {
//        try {
//            ClassLoader cl = getClass().getClassLoader();
//            InputStream in = cl.getResourceAsStream("commandsFactory.txt");
//            classes.load(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Base get(String id) {
//        Base product = null;
//        try {
//            String className = classes.getProperty(id);
//            if (className != null) {
//                product = (Base) Class.forName(className).newInstance();
//            } else {
//                System.out.println("Класс не найден для идентификатора: " + id);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e.toString());
//        }
//        return product;
//    }
//    public boolean containsKeyProperties(String key){
//        return classes.containsKey(key);
//    }
//}
//
//
////public class FactoryCommands<ID, Base, Args> {
////    private final Properties classes = new Properties();
////    private final Map<ID, Base> classes;
////    FactoryCommands(){
////        classes = new HashMap<>();
////    }
////    public Base get(ID id){
////        return classes.get(id);
////    }
////    public void add(ID id, Base derived){
////        classes.put(id, derived);
////    }
////}
