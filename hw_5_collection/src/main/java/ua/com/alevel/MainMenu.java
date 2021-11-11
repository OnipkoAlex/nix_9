package ua.com.alevel;

import ua.com.alevel.lib.MathSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {

    public static void runMainMenu(MathSet mathSet) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String menu = "";

        do {
            System.out.println("1. Add/Join/Intersection methods.");
            System.out.println("2. Sort Asc/Desc methods.");
            System.out.println("3. Get methods.");
            System.out.println("4. ToArray/Cut/Clear methods.");
            System.out.println("5. Exit.");
            try {
                menu = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (menu) {
                case "1": {
                    if (mathSet == null) AddJoinIntersectionMethods.runAddJoinIntersectionMethods(ConstructorMenu.runConstructorMenu());
                    else AddJoinIntersectionMethods.runAddJoinIntersectionMethods(mathSet);
                    menu = "";
                    break;
                }

                case "2": {
                    if (mathSet == null) SortAscDescMethods.runSortAscDescMethods(ConstructorMenu.runConstructorMenu());
                    else SortAscDescMethods.runSortAscDescMethods(mathSet);
                    menu = "";
                    break;
                }

                case "3": {
                    if (mathSet == null) GetMethods.runGetMethods(ConstructorMenu.runConstructorMenu());
                    else GetMethods.runGetMethods(mathSet);
                    menu = "";
                    break;
                }

                case "4": {
                    if (mathSet == null) ToArrayCutClearMethods.runToArrayCutClearMethods(ConstructorMenu.runConstructorMenu());
                    else ToArrayCutClearMethods.runToArrayCutClearMethods(mathSet);
                    menu = "";
                    break;
                }

                case "5": {
                    System.exit(0);
                }
            }
        } while(true);
    }
}
