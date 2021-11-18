package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {
    private static Boolean firstRun = true;

    public static void runMainMenu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String menu = "";

        if (firstRun) {
            InputFormat.runInputFormat();
            OutputFormat.runOutputFormat();
            firstRun = false;
        }

        do {
            InputFormat.presentInputFormat();
            OutputFormat.presentOutputFormat();
            System.out.println("1. Find the difference between two dates.");
            System.out.println("2. Increase date.");
            System.out.println("3. Decrease date.");
            System.out.println("4. Sort dates.");
            System.out.println("5. Change date input format.");
            System.out.println("6. Change date output format.");
            System.out.println("7. Exit.");
            System.out.println("Your choice: ");
            try {
                menu = reader.readLine();
            } catch (IOException e) {
                System.out.println("Error.");
            }

            switch (menu) {
                case "1": {
                    DateDifference.runDateDiff();
                    menu = "";
                    break;
                }

                case "2": {
                    IncreaseDecreaseDate.runIncreaseDate();
                    menu = "";
                    break;
                }

                case "3": {
                    IncreaseDecreaseDate.runDecreaseDate();
                    menu = "";
                    break;
                }

                case "4": {
                    SortDates.runSortDates();
                    menu = "";
                    break;
                }

                case "5":{
                    InputFormat.runInputFormat();
                    menu = "";
                    break;
                }

                case "6":{
                    OutputFormat.runOutputFormat();
                    menu = "";
                    break;
                }

                case "7":{
                    System.exit(0);
                    menu = "";
                    break;
                }
            }
        }while(true);
    }
}
