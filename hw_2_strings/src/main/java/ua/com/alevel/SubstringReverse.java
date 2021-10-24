package ua.com.alevel;

import ua.com.alevel.custom.StringReverse;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubstringReverse {
    
    static void startSubstringReverse() {
        String stringInput = "";
        String substringInput = "";

        System.out.println("Enter string and substring to reverse: ");
        System.out.println("e.g. Hello world, worl");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            stringInput = reader.readLine();
        } catch (Exception e) {
            e.getStackTrace();
        }

        String[] words = stringInput.split("[ !\\\"\\\\#$%&'()*+,-./:;<=>?@\\\\[\\\\]^_`{|}~]+");

        stringInput = "";
        for (int i = 0; i < words.length - 1; i++) {
            stringInput += words[i];
            stringInput += " ";
        }

        substringInput = words[words.length - 1];
        if (stringInput.equals(StringReverse.reverse(stringInput, substringInput))) {
            System.out.println("No matches found.");
        }
        else {
            System.out.println(StringReverse.reverse(stringInput, substringInput));
        }
    }
}
