package ua.com.alevel.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ObjectToFileUtil {

    public static void runObjectToFile(List<String> line, Path path) {
        String value = "";
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
                for (String i : line) {
                    value += i + ", ";
                }
                value += "\n";
                Files.write(path, value.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                for (String i : line) {
                    value += i + ", ";
                }
                value += "\n";
                Files.write(path, value.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
