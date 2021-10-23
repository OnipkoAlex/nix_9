package ua.com.alevel.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tags {
    public static void startTags() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean validString = true;

        System.out.println("Enter string: ");
        String stringInput = reader.readLine();
        char[] charArray = stringInput.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (!validString) break;
            switch (charArray[i]) {
                case ')': {
                    for (int j = i; j >= 0; j--) {
                        if (!validString) break;
                        if (charArray[j] == '(') {
                            charArray[i] = 0;
                            charArray[j] = 0;
                            break;
                        }
                        if (charArray[j] == '{') {
                            System.out.println("String is invalid. Wrong opening tag.");
                            validString = false;
                            break;
                        }
                        if (charArray[j] == '[') {
                            System.out.println("String is invalid. Wrong opening tag.");
                            validString = false;
                            break;
                        }
                        if (j == 0) {
                            System.out.println("String is invalid. No opening tag.");
                            validString = false;
                            break;
                        }
                    }
                    break;
                }
                case '}': {
                    for (int j = i; j >= 0; j--) {
                        if (!validString) break;
                        if (charArray[j] == '(') {
                            System.out.println("String is invalid. Wrong opening tag.");
                            validString = false;
                            break;
                        }
                        if (charArray[j] == '{') {
                            charArray[i] = 0;
                            charArray[j] = 0;
                            break;
                        }
                        if (charArray[j] == '[') {
                            System.out.println("String is invalid. Wrong opening tag.");
                            validString = false;
                            break;
                        }
                        if (j == 0) {
                            System.out.println("String is invalid. No opening tag.");
                            validString = false;
                            break;
                        }
                    }
                    break;
                }
                case ']': {
                    for (int j = i; j >= 0; j--) {
                        if (!validString) break;
                        if (charArray[j] == '(') {
                            System.out.println("String is invalid. Wrong opening tag.");
                            validString = false;
                            break;
                        }
                        if (charArray[j] == '{') {
                            System.out.println("String is invalid. Wrong opening tag.");
                            validString = false;
                            break;
                        }
                        if (charArray[j] == '[') {
                            charArray[i] = 0;
                            charArray[j] = 0;
                            break;
                        }
                        if (j == 0) {
                            System.out.println("String is invalid. No opening tag.");
                            validString = false;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (!validString) break;
            switch (charArray[i]) {
                case '(': {
                    for (int j = i; j < charArray.length; j++) {
                        if (!validString) break;
                        if (charArray[j] == ')') {
                            charArray[i] = 0;
                            charArray[j] = 0;
                            break;
                        }
                        if (charArray[j] == '}') {
                            System.out.println("String is invalid. Wrong closing tag.");
                            validString = false;
                            break;
                        }
                        if (charArray[j] == ']') {
                            System.out.println("String is invalid. Wrong closing tag.");
                            validString = false;
                            break;
                        }
                        if (j == charArray.length - 1) {
                            System.out.println("String is invalid. No closing tag.");
                            validString = false;
                            break;
                        }
                    }
                    break;
                }
                case '{': {
                    for (int j = i; j < charArray.length; j++) {
                        if (!validString) break;
                        if (charArray[j] == ')') {
                            System.out.println("String is invalid. Wrong closing tag.");
                            validString = false;
                            break;
                        }
                        if (charArray[j] == '}') {
                            charArray[i] = 0;
                            charArray[j] = 0;
                            break;
                        }
                        if (charArray[j] == ']') {
                            System.out.println("String is invalid. Wrong closing tag.");
                            validString = false;
                            break;
                        }
                        if (j == charArray.length - 1) {
                            System.out.println("String is invalid. No closing tag.");
                            validString = false;
                            break;
                        }
                    }
                    break;
                }
                case '[': {
                    for (int j = i; j < charArray.length; j++) {
                        if (!validString) break;
                        if (charArray[j] == ')') {
                            System.out.println("String is invalid. Wrong closing tag.");
                            validString = false;
                            break;
                        }
                        if (charArray[j] == '}') {
                            System.out.println("String is invalid. Wrong closing tag.");
                            validString = false;
                            break;
                        }
                        if (charArray[j] == ']') {
                            charArray[i] = 0;
                            charArray[j] = 0;
                            break;
                        }
                        if (j == charArray.length - 1) {
                            System.out.println("String is invalid. No closing tag.");
                            validString = false;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        if (validString) {
            System.out.println("Valid string.");
        }
    }
}
