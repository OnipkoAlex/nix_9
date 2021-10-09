package ua.com.alevel;

import java.lang.String;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int menu;

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("1. Summarize numbers in String.");
            System.out.println("2. Count letters in String.");
            System.out.println("3. School task.");
            System.out.println("4. Exit.");
            menu = input.nextInt();

            switch (menu)
            {
                case 1: {
                    charNumbers();
                    break;
                }
                case 2: {
                    charLetters();
                    break;
                }
                case 3: {
                    lectionEnd();
                    break;
                }
            }
        }while (menu < 4);
    }

    static void charNumbers() {
        int sumNumber = 0;

        String stringInput = new String();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter string: ");
        try {
            stringInput = input.nextLine();
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
        String stringInput = new String();
        Scanner input = new Scanner(System.in);
        int arrSize = 0;
        int arrIter = 0;
        int valChange;
        char charChange;

        System.out.println("Enter string: ");

        try {
            stringInput = input.nextLine();
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
                    }
                    else {
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

    static void lectionEnd() {
        int lectionNumber;
        int lectionEndHour;
        int lectionEndMinute;
        int lectionCounter;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter lection number: ");
        lectionNumber = input.nextInt();
        lectionCounter = lectionNumber - 1;
        lectionEndHour = (540 + lectionNumber * 45 + lectionCounter / 2 * 15 + (lectionCounter - lectionCounter / 2) * 5)/60;
        lectionEndMinute = (540 + lectionNumber * 45 + lectionCounter / 2 * 5 + (lectionCounter - lectionCounter / 2) * 15) - lectionEndHour * 60;
        System.out.println("Lection ends at: " + lectionEndHour + ":" + lectionEndMinute);
        System.out.println();
    }
}