package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberArrayEnterFromConsole {

    public static Number[] runNumberArrayEnterFromConsole() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String stringInput = "";
        int pointer = 0;

        System.out.println("Enter string of numbers.");
        try {
            stringInput = reader.readLine();
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
            return null;
        }

        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(stringInput);
        String[] strArray = new String[20];

        while (matcher.find()) {
            strArray[pointer] = matcher.group();
            pointer++;
        }
        Number[] nfNumbers = new Number[pointer];

        try {
            for (int i = 0; i < pointer; i++) {
                if (strArray[i].contains(".")) nfNumbers[i] = Double.parseDouble(strArray[i]);
                else nfNumbers[i] = Long.parseLong(strArray[i]);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input.");
        }

        if (nfNumbers.length > 0) return nfNumbers;
        else {
            return new Number[0];
        }
    }
}
