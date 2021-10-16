package ua.com.alevel;

import ua.com.alevel.custom.stringReverse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class positionReverse {
    static void startPositionReverse() {
        String stringInput = "";
        int substringStart;
        int substringEnd;
        int wordsReverse;
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
        System.out.println(Arrays.toString(words));
        System.out.println(words.length);
        substringStart = Integer.parseInt(words[words.length - 3]);
        substringEnd = Integer.parseInt(words[words.length - 2]) + 1;
        wordsReverse = Integer.parseInt(words[words.length - 1]);
        stringInput = stringInput.toString();
        System.out.println(substringStart + " " + substringEnd);

        if ((substringEnd > stringInput.length()) || (substringStart > stringInput.length())) valid = false;
        if (substringEnd < substringStart) valid = false;
        if ((substringEnd < 0) || (substringStart < 0)) valid = false;
        if ((wordsReverse < 0) || (wordsReverse > 1)) valid = false;

        if (valid) {
            System.out.println(stringReverse.reverse(stringInput, substringStart, substringEnd, wordsReverse));
        }
        else {
            System.out.println("Invalid enter.");
        }
    }
}
