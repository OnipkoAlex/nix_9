package ua.com.alevel;

import java.lang.String;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class LessonEnd {
    static void lessonEnd() {
        int lessonNumber = 0;
        int lessonEndHour;
        int lessonEndMinute;
        int lessonCounter;

        do {
            System.out.println("Enter valid lesson number: ");

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                lessonNumber = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                e.getStackTrace();
            }

            if (lessonNumber > 0) {
                break;
            }
            else {
                continue;
            }
        }while (true);

        lessonCounter = lessonNumber - 1;
        lessonEndHour = (540 + lessonNumber * 45 + lessonCounter / 2 * 15 + (lessonCounter - lessonCounter / 2) * 5) / 60;
        lessonEndMinute = (540 + lessonNumber * 45 + lessonCounter / 2 * 5 + (lessonCounter - lessonCounter / 2) * 15) - lessonEndHour * 60;
        System.out.println("Lesson ends at: " + lessonEndHour + ":" + lessonEndMinute);
        System.out.println();
    }
}