package ua.com.alevel.names;

import ua.com.alevel.util.FileToStringList;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UniqueNames {
    private static final Path path = Paths.get("module_2/inputNames.txt");

    public static void runUniqueNames() {
        List<String> list = FileToStringList.fileToStringList(path);
        if (list == null) return;

        String[] strArray = new String[list.size()];
        strArray = list.toArray(strArray);

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(strArray.length);

        for (String str : strArray) {
            Integer count = map.getOrDefault(str, 0);
            map.put(str, count + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                break;
            }
        }

    }
}
