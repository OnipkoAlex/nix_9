package ua.com.alevel.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Triangle {
    public static void triangleArea() throws IOException {
        long area;
        int i = 0;
        int[] coordinatesX = new int[3];
        int[] coordinatesY = new int[3];;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Enter coordinate X of point #" + (i + 1));
            if (digitCheck(reader.readLine())) coordinatesX[i] = Integer.parseInt(reader.readLine());
            else System.out.println("Invalid input");
            System.out.println("Enter coordinate Y of point #" + (i + 1));
            if (digitCheck(reader.readLine())) coordinatesY[i] = Integer.parseInt(reader.readLine());
            else System.out.println("Invalid input");
            System.out.println("Coordinates of point #" + (i + 1) + ": (" + coordinatesX[i] + ", " + coordinatesY[i] + ")");
            i++;
        } while(i != 3);

        area = ((coordinatesX[1] - coordinatesX[0])*(coordinatesY[2] - coordinatesY[0]) - (coordinatesX[2] - coordinatesX[1])*(coordinatesY[1] - coordinatesY[0])) / 2;

        System.out.println("Area = " + area);
    }

    public static boolean digitCheck(String stringInput) {
        boolean isDigit = true;
        if (stringInput.isEmpty() || stringInput.isBlank()) isDigit = false;
        for (int i = 0; i < stringInput.length(); i++) {
            if (!Character.isDigit(stringInput.charAt(i))) {
                isDigit = false;
            }
        }
        return isDigit;
    }
}
