package org.fit_labs.labs2.Factory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Factory<Base> {
    private final Properties classes = new Properties();
    public Factory(String commandsFilename) throws IOException {
        ClassLoader cl = getClass().getClassLoader();
        try(InputStream in = cl.getResourceAsStream(commandsFilename)){
            classes.load(in);
        } catch (IOException | NullPointerException ex) {
            throw new IOException(ex + ":\n" + "Error loading commands properties file, you need create file with commands in resource folder");
        }
    }
    public Factory() throws IOException {
        ClassLoader cl = getClass().getClassLoader();
        try(InputStream in = cl.getResourceAsStream("commandsFactory.txt");) {
            classes.load(in);
        } catch (IOException | NullPointerException ex) {
            throw new IOException(ex + ":\n" + "Error loading commands properties file," +
                    " you need create file with commands in resource folder");
        }
    }

    public Base get(String id) throws FactoryCommandsException {
        Base product;
        try {
            String className = classes.getProperty(id);
            if (className != null) {
                Class<?> classObject = Class.forName(className);
                Constructor<Base> constructor = (Constructor<Base>) classObject.getConstructor();
                product = constructor.newInstance();
            } else {
                throw new FactoryCommandsException("Class don't found for ID: " + id);
            }
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException | NoSuchMethodException |
                 ClassNotFoundException | SecurityException e) {
            throw new FactoryCommandsException(e);
        }
        return product;
    }
    public boolean containsKeyProperties(String key){
        return classes.containsKey(key);
    }
}
