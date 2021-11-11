package ua.com.alevel;

import ua.com.alevel.lib.MathSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class AddJoinIntersectionMethods {

    public static void runAddJoinIntersectionMethods(MathSet<Number> mathSet) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String menu = "";
        String numberInput = "";

        do {
            System.out.print("MathSet: ");
            mathSet.print();
            System.out.println("1. Add(Number... n).");
            System.out.println("2. Join(MathSet... ms).");
            System.out.println("3. Intersection(MathSet... ms).");
            System.out.println("4. Increase capacity.");
            System.out.println("5. Back to main menu.");
            try {
                menu = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (menu) {
                case "1": {
                    System.out.print("Before: ");
                    mathSet.print();
                    mathSet.add(Objects.requireNonNull(NumberArrayEnterFromConsole.runNumberArrayEnterFromConsole()));
                    System.out.print("After: ");
                    mathSet.print();
                    menu = "";
                    break;
                }

                case "2": {
                    System.out.print("Before: ");
                    mathSet.print();
                    do {
                        System.out.println("1. Join new MathSet.");
                        System.out.println("2. Stop.");
                        try {
                            menu = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (menu.equals("1"))
                            mathSet.join(Objects.requireNonNull(MathSetEnterFromConsole.runMathSetEnterFromConsole()));
                        else break;
                    } while (true);
                    System.out.print("After: ");
                    mathSet.print();
                    menu = "";
                    break;
                }

                case "3": {
                    System.out.print("Before: ");
                    mathSet.print();
                    do {
                        System.out.println("1. Intersection with a new MathSet.");
                        System.out.println("2. Stop.");
                        try {
                            menu = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (menu.equals("1"))
                            mathSet.intersection(Objects.requireNonNull(MathSetEnterFromConsole.runMathSetEnterFromConsole()));
                        else break;
                    } while (true);
                    System.out.print("After: ");
                    mathSet.print();
                    menu = "";
                    break;
                }

                case "4": {
                    System.out.println("Current max capacity: " + mathSet.getCapacity());
                    System.out.println("Enter capacity increment: ");
                    try {
                        menu = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        if (Integer.parseInt(menu) >= 0) mathSet.increaseCapacity(Integer.parseInt(menu));
                        else System.out.println("Invalid input.");
                    } catch(IllegalArgumentException e) {
                        System.out.println("Invalid input.");
                    }
                    System.out.println("New max capacity: " + mathSet.getCapacity());
                    menu = "";
                    break;
                }

                case "5": {
                    MainMenu.runMainMenu(mathSet);
                    menu = "";
                    break;
                }
            }
        } while (true);
    }
}
