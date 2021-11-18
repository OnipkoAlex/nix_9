package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OutputFormat {
    private static final String[] monthStrings = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private static int outputFormat = 1;

    public static int getOutputFormat() {
        return outputFormat;
    }

    public static void setOutputFormat(int outputFormat) {
        OutputFormat.outputFormat = outputFormat;
    }

    public static void runOutputFormat() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String menu = "";

        do {
            System.out.println("Choose output format:");
            System.out.println("1. dd/mm/yyyy");
            System.out.println("2. m/d/yyyy");
            System.out.println("3. mmm-d-yyyy");
            System.out.println("4. dd-mmm-yyyy");
            System.out.println("Your choice: ");
            try {
                menu = reader.readLine();
            } catch (IOException e) {
                System.out.println("Error.");
            }
            try {
                if (Integer.parseInt(menu) > 0 && Integer.parseInt(menu) < 5) {
                    setOutputFormat(Integer.parseInt(menu));
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input.");
                System.out.println("Setting default output format.");
                break;
            }
        } while (true);
    }

    public static void presentOutputFormat() {
        switch (getOutputFormat()) {
            case 1: {
                System.out.println("Output: dd/mm/yyyy");
                break;
            }
            case 2: {
                System.out.println("Output: m/d/yyyy");
                break;
            }
            case 3: {
                System.out.println("Output: mmm-d-yyyy");
                break;
            }
            case 4: {
                System.out.println("Output: dd-mmm-yyyy");
                break;
            }
        }
    }

    public static void dateOutput(Date date) {
        switch (getOutputFormat()) {
            case 1: {
                if (date.getDay() < 10 && date.getMonth() < 10)
                    System.out.println("0" + date.getDay() + "/0" + date.getMonth() + "/" + date.getYear() + " " + date.getHour() + ":" + date.getMinute() + ":" + date.getSecond() + ":" + date.getMillisecond());
                else if (date.getDay() < 10)
                    System.out.println("0" + date.getDay() + "/" + date.getMonth() + "/" + date.getYear() + " " + date.getHour() + ":" + date.getMinute() + ":" + date.getSecond() + ":" + date.getMillisecond());
                else if (date.getMonth() < 10)
                    System.out.println(date.getDay() + "/0" + date.getMonth() + "/" + date.getYear() + " " + date.getHour() + ":" + date.getMinute() + ":" + date.getSecond() + ":" + date.getMillisecond());
                else
                    System.out.println(date.getDay() + "/" + date.getMonth() + "/" + date.getYear() + " " + date.getHour() + ":" + date.getMinute() + ":" + date.getSecond() + ":" + date.getMillisecond());
                break;
            }

            case 2: {
                System.out.println(date.getMonth() + "/" + date.getDay() + "/" + date.getYear() + " " + date.getHour() + ":" + date.getMinute() + ":" + date.getSecond() + ":" + date.getMillisecond());
                break;
            }
            case 3: {
                System.out.println(monthStrings[date.getMonth() - 1] + "-" + date.getDay() + "-" + date.getYear() + " " + date.getHour() + ":" + date.getMinute() + ":" + date.getSecond() + ":" + date.getMillisecond());
                break;
            }
            case 4: {
                if (date.getDay() < 10)
                    System.out.println("0" + date.getDay() + "-" + monthStrings[date.getMonth() - 1] + "-" + date.getYear() + " " + date.getHour() + ":" + date.getMinute() + ":" + date.getSecond() + ":" + date.getMillisecond());
                else
                    System.out.println(date.getDay() + "-" + monthStrings[date.getMonth() - 1] + "-" + date.getYear() + " " + date.getHour() + ":" + date.getMinute() + ":" + date.getSecond() + ":" + date.getMillisecond());
                break;
            }
        }
    }
}
