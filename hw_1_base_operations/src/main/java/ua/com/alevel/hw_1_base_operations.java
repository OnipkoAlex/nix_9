package ua.com.alevel;

import java.lang.String;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import ua.com.alevel.SummarizeNumbers;
import ua.com.alevel.CountLetters;
import ua.com.alevel.LessonEnd;

public class hw_1_base_operations {
    public static void main(String[] args) {
        int menu = 0;

        do {
            System.out.println("1. Summarize numbers in String.");
            System.out.println("2. Count letters in String.");
            System.out.println("3. School task.");
            System.out.println("4. Exit.");
            System.out.println("Make your choice: ");

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                menu = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                e.getStackTrace();
            }

            if (menu > 0) {
                switch (menu) {
                    case 1: {
                        SummarizeNumbers.charNumbers();
                        menu = 0;
                        break;
                    }
                    case 2: {
                        CountLetters.charLetters();
                        menu = 0;
                        break;
                    }
                    case 3: {
                        LessonEnd.lessonEnd();
                        menu = 0;
                        break;
                    }
                }
            }
            else {
                continue;
            }
        } while (menu != 4);
    }
}