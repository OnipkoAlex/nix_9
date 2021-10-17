package ua.com.alevel;

import ua.com.alevel.custom.stringReverse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class positionReverse {
    static void startPositionReverse() {
        String stringInput = "";
        int substringStart = 0;
        int substringEnd = 0;
        int wordsReverse = 0;
        boolean valid = true;


        System.out.println("Enter string, start position of reverse, end position of reverse");
        System.out.println("and [0 or 1] for simple or by words reverse: ");
        System.out.println("e.g. Hello world, 3, 7, 0");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            stringInput = reader.readLine();
        } catch (Exception e) {
            e.getStackTrace();
        }

        String[] words = stringInput.split("[ !\\\"\\\\#$%&'()*+,-./:;<=>?@\\\\[\\\\]^_`{|}~]+");

        if (words.length < 4) {
            valid = false;
        }
        else {
            if (Character.isDigit(words[words.length - 3].charAt(0))) substringStart = Integer.parseInt(words[words.length - 3]); else valid = false;
            if (Character.isDigit(words[words.length - 2].charAt(0))) substringEnd = Integer.parseInt(words[words.length - 2]); else valid = false;
            if (Character.isDigit(words[words.length - 1].charAt(0))) wordsReverse = Integer.parseInt(words[words.length - 1]); else valid = false;
        }

        stringInput = "";
        for (int i = 0; i < words.length - 3; i++) {
            stringInput += words[i];
            stringInput += " ";
        }

        if ((substringEnd > stringInput.length()) || (substringStart > stringInput.length())) valid = false;
        if (substringEnd < substringStart) valid = false;
        if ((substringEnd < 0) || (substringStart < 0)) valid = false;
        if ((wordsReverse < 0) || (wordsReverse > 1)) valid = false;

        if ((words.length == 4) && (wordsReverse == 1)) {
            System.out.println("By words reverse chosen but only one word found. Starting simple reverse: ");
            System.out.println(stringReverse.reverse(stringInput, substringStart, substringEnd + 1, 0));
        }
        else {
            if (valid) {
                if (wordsReverse == 0) substringEnd++;
                System.out.println(stringReverse.reverse(stringInput, substringStart, substringEnd, wordsReverse));
            }
            else {
                System.out.println("Invalid input.");
            }
        }

    }
}
