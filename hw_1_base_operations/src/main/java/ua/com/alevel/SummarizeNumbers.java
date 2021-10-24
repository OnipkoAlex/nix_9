package ua.com.alevel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class SummarizeNumbers {

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
}