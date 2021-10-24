package ua.com.alevel.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Triangle {

    public static void triangleArea() throws IOException {
        double area;
        int[] coordinatesX = new int[3];
        int[] coordinatesY = new int[3];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 3; i ++) {
            do {
                try {
                    System.out.println("Enter coordinate X of point #" + (i + 1));
                    coordinatesX[i] = Integer.parseInt(reader.readLine());
                    System.out.println("Enter coordinate Y of point #" + (i + 1));
                    coordinatesY[i] = Integer.parseInt(reader.readLine());
                    break;
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid input. Try again.");
                }
            } while(true);
            System.out.println("Coordinates of point #" + (i + 1) + ": (" + coordinatesX[i] + ", " + coordinatesY[i] + ")");
        }
        System.out.print("Coordinates: ");

        for(int i = 0; i < 3; i ++) {
            System.out.print("(" + coordinatesX[i] + "," + coordinatesY[i] + ")");
        }

        System.out.println();
        area = Math.abs((coordinatesX[0] * (coordinatesY[1] - coordinatesY[2]) + coordinatesX[1] * (coordinatesY[2] - coordinatesY[0]) + coordinatesX[2] * (coordinatesY[0] - coordinatesY[1])) / (double) 2);
        System.out.println("Area = " + area);
    }
}
