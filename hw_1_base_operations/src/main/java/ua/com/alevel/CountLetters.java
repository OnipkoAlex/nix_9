package ua.com.alevel;

import java.lang.String;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class CountLetters {
    static void charLetters() {
        String stringInput = new String();
        int arrSize = 0;
        int arrIter = 0;
        int valChange;
        char charChange;

        System.out.println("Enter string: ");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            stringInput = reader.readLine();
        } catch (Exception e) {
            e.getStackTrace();
        }

        char[] charArray = new char[stringInput.length()];
        stringInput.getChars(0, stringInput.length(), charArray, 0);

        for (int i = 0; i < stringInput.length(); i++) {
            if (Character.isLetter(charArray[i])) arrSize++;
        }

        char[] charLettersArr = new char[arrSize];
        int[] intOcurr = new int[arrSize];

        for (int i = 0; i < stringInput.length(); i++) {
            if (Character.isLetter(charArray[i])) {
                for (int j = 0; j <= arrIter; j++) {
                    if (Character.compare(charLettersArr[j], charArray[i]) == 0) {
                        intOcurr[j]++;
                        break;
                    } else {
                        if (j == arrIter) {
                            charLettersArr[arrIter] = charArray[i];
                            intOcurr[arrIter] = 1;
                            arrIter++;
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < arrIter; i++) {
            for (int j = i + 1; j < arrIter; j++) {
                if (intOcurr[j] > intOcurr[i]) {
                    valChange = intOcurr[j];
                    charChange = charLettersArr[j];
                    intOcurr[j] = intOcurr[i];
                    charLettersArr[j] = charLettersArr[i];
                    intOcurr[i] = valChange;
                    charLettersArr[i] = charChange;
                }
            }
        }

        for (int i = 0; i < arrIter; i++) {
            System.out.println(charLettersArr[i] + "=" + intOcurr[i]);
        }
    }
}