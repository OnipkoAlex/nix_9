package ua.com.alevel.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;

public class UniqueNumbers {
    public static void startSearchForUniqueNumbers() throws IOException {
        String stringInput = "";
        int arrSize = 0;
        int arrIter = 0;

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
            if (Character.isDigit(charArray[i])) arrSize++;
        }

        char[] charNumbersArr = new char[arrSize];

        for (int i = 0; i < stringInput.length(); i++) {
            if (Character.isDigit(charArray[i])) {
                for (int j = 0; j <= arrIter; j++) {
                    if (Character.compare(charNumbersArr[j], charArray[i]) == 0) {
                        break;
                    } else {
                        if (j == arrIter) {
                            charNumbersArr[arrIter] = charArray[i];
                            arrIter++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.print("Number of unique numbers: " + arrIter);
        System.out.println();
    }
}
