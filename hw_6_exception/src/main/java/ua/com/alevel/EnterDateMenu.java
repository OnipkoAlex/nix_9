package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterDateMenu {

    public static Date enterDate() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String stringInput = "";

        InputFormat.presentInputFormat();
        System.out.println("Enter new date:");
        try {
            stringInput = reader.readLine();
        } catch (IOException e) {
            System.out.println("Error.");
        }
        if (!InputFormat.isValidInputFormat(stringInput)) {
            System.out.println("Invalid input.");
            return null;
        }
        Date date = StringToDate.runStringToDate(stringInput);

        if (InputFormat.isValidDate(date)) return date;
        else {
            System.out.println("Invalid input.");
            return null;
        }
    }
}
