package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDates {
    private static List<Date> dateList = new ArrayList<>();
    private static List<Long> milliList = new ArrayList<>();

    public static void runSortDates() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String menu = "";

        do {
            InputFormat.presentInputFormat();
            OutputFormat.presentOutputFormat();
            System.out.println("1. Add new date.");
            System.out.println("2. Sort Ascending.");
            System.out.println("3. Sort Descending.");
            System.out.println("4. Clear date list.");
            System.out.println("5. Back.");

            try {
                menu = reader.readLine();
            } catch (IOException e) {
                System.out.println("Error.");
            }

            switch (menu) {
                case "1": {
                    Date date = EnterDateMenu.enterDate();
                    if (date == null) break;
                    else dateList.add(date);
                    dateList.stream().forEach(x -> OutputFormat.dateOutput(x));
                    break;
                }

                case "2": {
                    if (dateList.isEmpty()) {
                        System.out.println("No dates to sort.");
                        break;
                    }
                    dateList.stream().forEach(x -> milliList.add(DateDifference.dateToMilliseconds(x)));
                    Collections.sort(milliList);
                    dateList.clear();
                    milliList.stream().forEach(x -> dateList.add(DateDifference.millisecondsToDate(x)));
                    milliList.clear();
                    dateList.stream().forEach(x -> OutputFormat.dateOutput(x));
                    break;
                }

                case "3": {
                    if (dateList.isEmpty()) {
                        System.out.println("No dates to sort.");
                        break;
                    }
                    dateList.stream().forEach(x -> milliList.add(DateDifference.dateToMilliseconds(x)));
                    Collections.sort(milliList, Collections.reverseOrder());
                    dateList.clear();
                    milliList.stream().forEach(x -> dateList.add(DateDifference.millisecondsToDate(x)));
                    milliList.clear();
                    dateList.stream().forEach(x -> OutputFormat.dateOutput(x));
                    break;
                }

                case "4": {
                    dateList.clear();
                    milliList.clear();
                    break;
                }

                case "5": {
                    MainMenu.runMainMenu();
                    break;
                }
            }
        } while (true);
    }
}
