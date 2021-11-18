package ua.com.alevel.lib;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileToObject {

    private static List<String> output = new ArrayList<>();
    private static List<String[]> finalList = new ArrayList<>();


    public static List runFileToObject(Path path) {
        output.clear();
        finalList.clear();
        if (Files.exists(path)) {
            try {
                Files.lines(path).forEach(output::add);
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (String line : output) {
                finalList.add(line.split("[ !\\\"\\\\#$%&'()*+,./:;<=>?@\\\\[\\\\]^`{|}~]+"));
            }
        }
        return finalList;
    }
}
