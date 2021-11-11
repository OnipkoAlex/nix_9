package ua.com.alevel;

import ua.com.alevel.lib.MathSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToArrayCutClearMethods {

    public static void runToArrayCutClearMethods(MathSet<Number> mathSet) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstIndex = "";
        String lastIndex = "";
        String menu = "";
        String index = "";
        String numberInput = "";

        if (mathSet.sizeOf() == 0) {
            System.out.println("MathSet is empty, fill it first.");
            return;
        }

        do {
            System.out.print("MathSet: ");
            mathSet.print();
            System.out.println("1. ToArray().");
            System.out.println("2. ToArray(int firstIndex, int lastIndex.");
            System.out.println("3. Cut(int firstIndex, int lastIndex).");
            System.out.println("4. Clear().");
            System.out.println("5. Clear(Number[] numbers).");
            System.out.println("6. Increase capacity.");
            System.out.println("7. Back to main menu.");
            try {
                menu = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (menu) {
                case "1": {
                    System.out.print("Before: ");
                    mathSet.print();
                    System.out.print("After: ");
                    mathSet.print();
                    menu = "";
                    break;
                }

                case "2": {
                    Number[] numbers = {};
                    System.out.print("Before: ");
                    mathSet.print();
                    System.out.println("Enter first index: ");
                    try {
                        firstIndex = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Enter last index: ");
                    try {
                        lastIndex = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.print("After: ");
                    try {
                        if (Integer.parseInt(firstIndex) >= 0 && Integer.parseInt(lastIndex) >= 0 && Integer.parseInt(firstIndex) < mathSet.sizeOf() && Integer.parseInt(lastIndex) < mathSet.sizeOf())
                            numbers = mathSet.toArray(Integer.parseInt(firstIndex), Integer.parseInt(lastIndex));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid input.");
                    }
                    for (int i = 0; i < numbers.length; i++) {
                        System.out.println(numbers[i]);
                    }
                    menu = "";
                    break;
                }

                case "3": {
                    System.out.print("Before: ");
                    mathSet.print();
                    System.out.println("Enter first index: ");
                    try {
                        firstIndex = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Enter last index: ");
                    try {
                        lastIndex = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.print("After: ");
                    try {
                        if (Integer.parseInt(firstIndex) >= 0 && Integer.parseInt(lastIndex) >= 0 && Integer.parseInt(firstIndex) < mathSet.sizeOf() && Integer.parseInt(lastIndex) < mathSet.sizeOf()) {
                            mathSet.cut(Integer.parseInt(firstIndex), Integer.parseInt(lastIndex));
                            mathSet.print();
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid input.");
                    }
                    System.out.println("Min = " + mathSet.getMin());
                    menu = "";
                    break;
                }

                case "4": {
                    System.out.print("Before: ");
                    mathSet.print();
                    mathSet.clear();
                    System.out.print("After: ");
                    mathSet.print();
                    menu = "";
                    break;
                }

                case "5": {
                    System.out.print("Before: ");
                    mathSet.print();
                    mathSet.clear(NumberArrayEnterFromConsole.runNumberArrayEnterFromConsole());
                    System.out.print("After: ");
                    mathSet.print();
                    menu = "";
                    break;
                }

                case "6": {
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

                case "7": {
                    MainMenu.runMainMenu(mathSet);
                    menu = "";
                    break;
                }
            }
        } while (true);
    }
}
