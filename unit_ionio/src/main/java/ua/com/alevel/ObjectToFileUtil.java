package ua.com.alevel;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ObjectToFileUtil {

    public static void runObjectToFile(Object object, Path path) {
        String value = "";
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
                for (Field field : object.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    value += field.get(object) + ", ";
                }
                value += "\n";
                Files.write(path, value.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                for (Field field : object.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    value += field.get(object) + ", ";
                }
                value += "\n";
                Files.write(path, value.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
