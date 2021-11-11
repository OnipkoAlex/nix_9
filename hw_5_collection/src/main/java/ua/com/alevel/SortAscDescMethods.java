package ua.com.alevel;

import ua.com.alevel.lib.MathSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortAscDescMethods {

    public static void runSortAscDescMethods(MathSet<Number> mathSet) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstIndex = "";
        String lastIndex = "";
        String value = "";
        String menu = "";
        String numberInput = "";

        if (mathSet.sizeOf() == 0) {
            System.out.println("MathSet is empty, fill it first.");
            return;
        }

        do {
            System.out.print("MathSet: ");
            mathSet.print();
            System.out.println("1. SortDesc().");
            System.out.println("2. SortDesc(int firstIndex, int lastIndex).");
            System.out.println("3. SortDesc(Number value).");
            System.out.println("4. SortAsc().");
            System.out.println("5. SortAsc(int firstIndex, int lastIndex).");
            System.out.println("6. SortAsc(Number value).");
            System.out.println("7. Increase capacity.");
            System.out.println("8. Back to main menu.");
            try {
                menu = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (menu) {
                case "1": {
                    System.out.print("Before: ");
                    mathSet.print();
                    mathSet.sortDesc();
                    System.out.print("After: ");
                    mathSet.print();
                    menu = "";
                    break;
                }

                case "2": {
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
                    try {
                        if (Integer.parseInt(firstIndex) >= 0 && Integer.parseInt(lastIndex) >= 0 && Integer.parseInt(firstIndex) < mathSet.sizeOf() && Integer.parseInt(lastIndex) < mathSet.sizeOf())
                            mathSet.sortDesc(Integer.parseInt(firstIndex), Integer.parseInt(lastIndex));
                        else System.out.println("Invalid input.");
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Invalid input.");
                    }
                    System.out.print("After: ");
                    mathSet.print();
                    menu = "";
                    break;
                }

                case "3": {
                    System.out.print("Before: ");
                    mathSet.print();
                    System.out.println("Enter value: ");
                    try {
                        value = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        if (value.contains(".")) mathSet.sortDesc(Double.parseDouble(value));
                        else mathSet.sortDesc(Long.parseLong(value));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid input.");
                    }
                    System.out.print("After: ");
                    mathSet.print();
                    menu = "";
                    break;
                }

                case "4": {
                    System.out.print("Before: ");
                    mathSet.print();
                    mathSet.sortAsc();
                    System.out.print("After: ");
                    mathSet.print();
                    menu = "";
                    break;
                }

                case "5": {
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
                    try {
                        if (Integer.parseInt(firstIndex) >= 0 && Integer.parseInt(lastIndex) >= 0 && Integer.parseInt(firstIndex) < mathSet.sizeOf() && Integer.parseInt(lastIndex) < mathSet.sizeOf())
                            mathSet.sortAsc(Integer.parseInt(firstIndex), Integer.parseInt(lastIndex));
                        else System.out.println("Invalid input.");
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Invalid input.");
                    }
                    System.out.print("After: ");
                    mathSet.print();
                    menu = "";
                    break;
                }

                case "6": {
                    System.out.print("Before: ");
                    mathSet.print();
                    System.out.println("Enter value: ");
                    try {
                        value = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        if (value.contains(".")) mathSet.sortAsc(Double.parseDouble(value));
                        else mathSet.sortAsc(Long.parseLong(value));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid input.");
                    }
                    System.out.print("After: ");
                    mathSet.print();
                    menu = "";
                    break;
                }

                case "7": {
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

                case "8": {
                    MainMenu.runMainMenu(mathSet);
                    menu = "";
                    break;
                }
            }
        } while (true);
    }
}
