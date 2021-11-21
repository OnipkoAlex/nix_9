package ua.com.alevel.dates;

import ua.com.alevel.util.FileToStringList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class DateFormat {

    private static final Path path = Paths.get("module_2/inputDatesFormat.txt");
    private static final Path pathOut = Paths.get("module_2/outputDatesFormat.txt");

    public static void isValidFormat() {
        List<String> list = FileToStringList.fileToStringList(path);
        if (list == null) return;

        LocalDate ld;
        String[] format = {"dd/MM/yyyy", "MM/dd/yyyy", "yyyy/MM/dd", "dd-MM-yyyy", "MM-dd-yyyy", "yyyy-MM-dd"};
        DateTimeFormatter outFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        String result;

        if (Files.exists(pathOut)) {
            try {
                Files.delete(pathOut);
                Files.createFile(pathOut);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                Files.createFile(pathOut);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (String line : list) {
            for (String formats : format) {
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formats);
                    ld = LocalDate.parse(line, formatter);
                    result = ld.format(outFormat) + "\n";
                    Files.write(pathOut, result.getBytes(), StandardOpenOption.APPEND);
                } catch (DateTimeParseException e) {
                    e.getErrorIndex();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
