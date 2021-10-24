package ua.com.alevel;

import ua.com.alevel.custom.StringReverse;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SimpleReverse {

    static void startSimpleReverse() {
        String stringInput = new String();

        System.out.println("Enter string: ");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            stringInput = reader.readLine();
        } catch (Exception e) {
            e.getStackTrace();
        }

        System.out.println(StringReverse.reverse(stringInput));
    }
}
