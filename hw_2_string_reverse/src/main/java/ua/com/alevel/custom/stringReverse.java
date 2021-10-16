package ua.com.alevel.custom;

import java.lang.String;
import java.util.Arrays;

public class stringReverse {
    public static char[] reverse(String stringInput) {
        char[] charArray = stringInput.toCharArray();
        char[] charResult = new char[stringInput.length()];
        int counter = 0;

        for (int i = charArray.length - 1; i >= 0; i--) {
            charResult[counter] = charArray[i];
            counter++;
        }

        return charResult;
    }

    public static char[] reverse(String stringInput, String substringInput) {
        char[] charArray = stringInput.toCharArray();
        char[] charSubArray = reverse(substringInput);
        int counter = 0;
        int substringLength = substringInput.length();

        for (int i = 0; i <= (stringInput.length() - substringLength); i++) {
            if (stringInput.length() < substringLength) {
                break;
            }
            if (stringInput.substring(i, i + substringLength).equals(substringInput)) {
                for (int j = i; j < i + charSubArray.length; j++) {
                    charArray[j] = charSubArray[counter];
                    counter++;
                }
                counter = 0;
            }
        }

        return charArray;
    }

    public static char[] reverse(String stringInput, int substringStart, int substringEnd, int wordsReverse) {
        char[] charArray = stringInput.toCharArray();
        int counter = 0;
        String substring = "";

        String[] words = stringInput.split("[ !\\\"\\\\#$%&'()*+,-./:;<=>?@\\\\[\\\\]^_`{|}~]+");

        if (wordsReverse == 0) {
            substring = stringInput.substring(substringStart, substringEnd);
            char[] charSubArray = reverse(substring);
            int substringLength = substring.length();
            for (int i = 0; i <= (stringInput.length() - substringLength); i++) {
                if (stringInput.length() < substringLength) {
                    break;
                }
                if (stringInput.substring(i, i + substringLength).equals(substring)) {
                    for (int j = i; j < i + charSubArray.length; j++) {
                        charArray[j] = charSubArray[counter];
                        counter++;
                    }
                    counter = 0;
                }
            }
            return charArray;
        }
        else {

        }

        return charArray;
    }
}
