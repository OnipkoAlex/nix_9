package ua.com.alevel.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileToStringList {

    public static List<String> fileToStringList(Path path) {
        List<String> list;
        if (Files.exists(path)) {
            try {
                list = Files.lines(path).toList();
            } catch (IOException e) {
                return null;
            }
        }
        else {
            System.out.println("Create and fill file first.");
            return null;
        }

        if (list.isEmpty()) {
            System.out.println("Fill file first.");
            return null;
        }
        else return list;
    }
}
