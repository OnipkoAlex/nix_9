package ua.com.alevel;

import ua.com.alevel.lib.MathSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class ConstructorMenu {

    public static MathSet<Number> runConstructorMenu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String menu = "";
        String stringInput = "";

        do {
            System.out.println("1. Run with default constructor.");
            System.out.println("2. Run with capacity constructor.");
            System.out.println("3. Run with Number array constructor.");
            System.out.println("4. Run with MathSet constructor.");
            System.out.println("5. Back to main menu.");
            try {
                menu = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (menu) {
                case "1": {
                    System.out.println("Default constructor.");
                    return new MathSet<>();
                }

                case "2": {
                    System.out.println("Constructor with capacity.");
                    System.out.print("Enter max capacity (int): ");
                    try {
                        stringInput = reader.readLine();
                        if (Integer.parseInt(stringInput) > 0) return new MathSet<>(Integer.parseInt(stringInput));
                        else {
                            System.out.println("Invalid input. Creating default MathSet.");
                            return new MathSet<>();
                        }
                    } catch (IOException | NumberFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                }

                case "3": {
                    System.out.println("Constructor with Number array.");
                    MathSet<Number> mathSet = new MathSet<>();
                    mathSet.add(Objects.requireNonNull(NumberArrayEnterFromConsole.runNumberArrayEnterFromConsole()));
                    if (mathSet.sizeOf() == 0) {
                        System.out.println("Nothing was entered.");
                    }
                    do {
                        System.out.println("1. Add new array.");
                        System.out.println("2. Run constructor.");
                        try {
                            menu = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (menu.equals("1")) mathSet.add(Objects.requireNonNull(NumberArrayEnterFromConsole.runNumberArrayEnterFromConsole()));
                        if (menu.equals("2")) {
                            if (mathSet.sizeOf() == 0) {
                                System.out.println("Nothing was entered. Creating default MathSet.");
                            }
                            return mathSet;
                        }
                    }while(true);
                }

                case "4": {
                    System.out.println("Constructor with MathSet.");
                    MathSet<Number> mathSet = new MathSet<>();
                    mathSet.join(Objects.requireNonNull(MathSetEnterFromConsole.runMathSetEnterFromConsole()));
                    if (mathSet.sizeOf() == 0) {
                        System.out.println("Nothing was entered.");
                    }
                    do {
                        System.out.println("1. Add new MathSet.");
                        System.out.println("2. Run constructor.");
                        try {
                            menu = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (menu.equals("1")) mathSet.join(Objects.requireNonNull(MathSetEnterFromConsole.runMathSetEnterFromConsole()));
                        if (menu.equals("2")) {
                            if (mathSet.sizeOf() == 0) {
                                System.out.println("Nothing was entered. Creating default MathSet.");
                            }
                            return mathSet;
                        }
                    }while(true);
                }

                case "5": {
                    MainMenu.runMainMenu(null);
                }
            }
        } while(true);
    }
}
