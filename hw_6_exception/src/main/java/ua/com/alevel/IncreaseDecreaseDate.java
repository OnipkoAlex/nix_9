package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IncreaseDecreaseDate {

    public static void runIncreaseDate() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String menu = "";

        Date date = EnterDateMenu.enterDate();
        if (date == null) return;

        do {
            OutputFormat.dateOutput(date);
            System.out.println("Choose what to increase.");
            System.out.println("1. Year.");
            System.out.println("2. Month.");
            System.out.println("3. Day.");
            System.out.println("4. Hour.");
            System.out.println("5. Minute.");
            System.out.println("6. Second.");
            System.out.println("7. Millisecond.");
            System.out.println("8. Back.");
            System.out.println("Your choice: ");
            try {
                menu = reader.readLine();
            } catch (IOException e) {
                System.out.println("Error.");
            }
            int value = increase();

            switch (menu) {
                case "1": {
                    OutputFormat.dateOutput(DateDifference.millisecondsToDate(DateDifference.dateToMilliseconds(date) + value * 31557600000L));
                    break;
                }

                case "2": {
                    OutputFormat.dateOutput(DateDifference.millisecondsToDate(DateDifference.dateToMilliseconds(date) + value * 2629800000L));
                    break;
                }

                case "3": {
                    OutputFormat.dateOutput(DateDifference.millisecondsToDate(DateDifference.dateToMilliseconds(date) + value * 86400000L));
                    break;
                }

                case "4": {
                    OutputFormat.dateOutput(DateDifference.millisecondsToDate(DateDifference.dateToMilliseconds(date) + value * 3600000L));
                    break;
                }

                case "5": {
                    OutputFormat.dateOutput(DateDifference.millisecondsToDate(DateDifference.dateToMilliseconds(date) + value * 60000L));
                    break;
                }

                case "6": {
                    OutputFormat.dateOutput(DateDifference.millisecondsToDate(DateDifference.dateToMilliseconds(date) + value * 1000L));
                    break;
                }

                case "7": {
                    OutputFormat.dateOutput(DateDifference.millisecondsToDate(DateDifference.dateToMilliseconds(date) + value));
                    break;
                }

                case "8": {
                    return;
                }
            }
        }while(true);
    }

    public static void runDecreaseDate() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String menu = "";

        Date date = EnterDateMenu.enterDate();
        if (date == null) return;

        do {
            OutputFormat.dateOutput(date);
            System.out.println("Choose what to decrease.");
            System.out.println("1. Year.");
            System.out.println("2. Month.");
            System.out.println("3. Day.");
            System.out.println("4. Hour.");
            System.out.println("5. Minute.");
            System.out.println("6. Second.");
            System.out.println("7. Millisecond.");
            System.out.println("Your choice: ");
            try {
                menu = reader.readLine();
            } catch (IOException e) {
                System.out.println("Error.");
            }
            int value = increase();

            /**
             * ну что это за зло - выноси это в константы как статики или енамы
             * */
            switch (menu) {
                case "1": {
                    if (DateDifference.dateToMilliseconds(date) - value * 31557600000L > 0) OutputFormat.dateOutput(DateDifference.millisecondsToDate(DateDifference.dateToMilliseconds(date) - value * 31557600000L));
                    else System.out.println("Gone to before Christ.");
                    break;
                }

                case "2": {
                    if (DateDifference.dateToMilliseconds(date) - value * 2629800000L > 0) OutputFormat.dateOutput(DateDifference.millisecondsToDate(DateDifference.dateToMilliseconds(date) - value * 2629800000L));
                    else System.out.println("Gone to before Christ.");
                    break;
                }

                case "3": {
                    if (DateDifference.dateToMilliseconds(date) - value * 86400000L > 0) OutputFormat.dateOutput(DateDifference.millisecondsToDate(DateDifference.dateToMilliseconds(date) - value * 86400000L));
                    else System.out.println("Gone to before Christ.");
                    break;
                }

                case "4": {
                    if (DateDifference.dateToMilliseconds(date) - value * 3600000L > 0) OutputFormat.dateOutput(DateDifference.millisecondsToDate(DateDifference.dateToMilliseconds(date) - value * 3600000L));
                    else System.out.println("Gone to before Christ.");
                    break;
                }

                case "5": {
                    if (DateDifference.dateToMilliseconds(date) - value * 60000L > 0) OutputFormat.dateOutput(DateDifference.millisecondsToDate(DateDifference.dateToMilliseconds(date) - value * 60000L));
                    else System.out.println("Gone to before Christ.");
                    break;
                }

                case "6": {
                    if (DateDifference.dateToMilliseconds(date) - value * 1000L > 0) OutputFormat.dateOutput(DateDifference.millisecondsToDate(DateDifference.dateToMilliseconds(date) - value * 1000L));
                    else System.out.println("Gone to before Christ.");
                    break;
                }

                case "7": {
                    if (DateDifference.dateToMilliseconds(date) - value > 0) OutputFormat.dateOutput(DateDifference.millisecondsToDate(DateDifference.dateToMilliseconds(date) - value));
                    else System.out.println("Gone to before Christ.");
                    break;
                }
            }
        }while(true);
    }

    public static int increase() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String strValue;
        int value = 0;

        System.out.println("Enter value: ");

        try {
            strValue = reader.readLine();
            if (strValue != null) value = Integer.parseInt(strValue);
            else {
                System.out.println("Invalid input.");
                return 0;
            }
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Invalid input.");
        }

        return value;
    }
}
