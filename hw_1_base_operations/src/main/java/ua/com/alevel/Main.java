package ua.com.alevel;

import java.lang.String;
import java.io.IOException;
/*import java.util.regex.Pattern;
import java.util.regex.Matcher;*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int menu = 0;

        do {
            System.out.println("1. Summarize numbers in String.");
            System.out.println("2. Count letters in String.");
            System.out.println("3. School task.");
            System.out.println("4. Exit.");
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                menu = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                e.getStackTrace();
            }

            switch (menu) {
                case 1: {
                    charNumbers();
                    break;
                }
                case 2: {
                    charLetters();
                    break;
                }
                case 3: {
                    lessonEnd();
                    break;
                }
            }
        } while (menu < 4);
    }

    static void charNumbers() {
        int sumNumber = 0;

        String stringInput = new String();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter string: ");
        try {
            stringInput = reader.readLine();
        } catch (Exception e) {
            e.getStackTrace();
        }
        char[] charArray = new char[stringInput.length()];
        stringInput.getChars(0, stringInput.length(), charArray, 0);
        for (int i = 0; i < stringInput.length(); i++) {
            if (Character.isDigit(charArray[i])) {
                sumNumber += Character.getNumericValue(charArray[i]);
            }
        }
        System.out.println("Sum = " + sumNumber);
    }

    static void charLetters() {
/*        Pattern engRegex = Pattern.compile("[A-Za-z]");
        Pattern rusRegex = Pattern.compile("[А-Яа-я]");*/

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
        System.out.println(stringInput);
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

    static void lessonEnd() {
        int lessonNumber = 0;
        int lessonEndHour;
        int lessonEndMinute;
        int lessonCounter;

        System.out.println("Enter lesson number: ");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            lessonNumber = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            e.getStackTrace();
        }

        lessonCounter = lessonNumber - 1;
        lessonEndHour = (540 + lessonNumber * 45 + lessonCounter / 2 * 15 + (lessonCounter - lessonCounter / 2) * 5) / 60;
        lessonEndMinute = (540 + lessonNumber * 45 + lessonCounter / 2 * 5 + (lessonCounter - lessonCounter / 2) * 15) - lessonEndHour * 60;
        System.out.println("Lesson ends at: " + lessonEndHour + ":" + lessonEndMinute);
        System.out.println();
    }
}