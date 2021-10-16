package ua.com.alevel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class stringCustomReverse {
    public static void main(String[] args) {
        int menu = 0;

        do {
            System.out.println("1. Simple reverse.");
            System.out.println("2. Reverse substring.");
            System.out.println("3. Reverse from position to position.");
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
                        simpleReverse.startSimpleReverse();
                        menu = 0;
                        break;
                    }
                    case 2: {
                        substringReverse.startSubstringReverse();
                        menu = 0;
                        break;
                    }
                    case 3: {
                        positionReverse.startPositionReverse();
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
