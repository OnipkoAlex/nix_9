package ua.com.alevel.lib;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ObjectToFile {

    public static void runObjectToFile(Object object, Path path) {
        String value = "";

        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (Class objectClass = object.getClass(); objectClass != null; objectClass = objectClass.getSuperclass()) {
                for (Field field : objectClass.getDeclaredFields()) {
                    field.setAccessible(true);
                    try {
                        value += field.get(object) + ", ";
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            value += "\n";
            try {
                Files.write(path, value.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            for (Class objectClass = object.getClass(); objectClass != null; objectClass = objectClass.getSuperclass()) {
                for (Field field : objectClass.getDeclaredFields()) {
                    field.setAccessible(true);
                    try {
                        value += field.get(object) + ", ";
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            value += "\n";
            try {
                Files.write(path, value.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
