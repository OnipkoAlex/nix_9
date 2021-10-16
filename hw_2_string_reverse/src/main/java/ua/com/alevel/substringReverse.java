package ua.com.alevel;

import ua.com.alevel.custom.stringReverse;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class substringReverse {
    static void startSubstringReverse() {
        String stringInput = "";
        String substringInput = "";

        System.out.println("Enter string: ");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            stringInput = reader.readLine();
        } catch (Exception e) {
            e.getStackTrace();
        }

        System.out.println("Enter substring to reverse: ");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            substringInput = reader.readLine();
        } catch (Exception e) {
            e.getStackTrace();
        }

        if (stringInput.equals(stringReverse.reverse(stringInput, substringInput))) {
            System.out.println("No matches found.");
        }
        else {
            System.out.println(stringReverse.reverse(stringInput, substringInput));
        }
    }
}
