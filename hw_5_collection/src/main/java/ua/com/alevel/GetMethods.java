package ua.com.alevel;

import ua.com.alevel.lib.MathSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetMethods {

    public static void runGetMethods(MathSet<Number> mathSet) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
            System.out.println("1. Get(int index).");
            System.out.println("2. GetMax().");
            System.out.println("3. GetMin().");
            System.out.println("4. GetAverage().");
            System.out.println("5. GetMedian().");
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
                    System.out.println("Enter index (int) less than " + mathSet.sizeOf() + " :");
                    try {
                        index = reader.readLine();
                        if (Integer.parseInt(index) >= mathSet.sizeOf() || Integer.parseInt(index) < 0 || index == null) throw new IllegalArgumentException();
                        else System.out.print("MathSet's " + Integer.parseInt(index) + " element: " + mathSet.get(Integer.parseInt(index))) ;
                    } catch (IOException | IllegalArgumentException e) {
                        e.printStackTrace();
                        System.out.println("Invalid input.");
                    }
                    menu = "";
                    break;
                }

                case "2": {
                    System.out.print("Before: ");
                    mathSet.print();
                    System.out.println("Max = " + mathSet.getMax());
                    menu = "";
                    break;
                }

                case "3": {
                    System.out.print("Before: ");
                    mathSet.print();
                    System.out.println("Min = " + mathSet.getMin());
                    menu = "";
                    break;
                }

                case "4": {
                    System.out.print("Before: ");
                    mathSet.print();
                    System.out.println("Average = " + mathSet.getAverage());
                    menu = "";
                    break;
                }

                case "5": {
                    System.out.print("Before: ");
                    mathSet.print();
                    System.out.println("Median = " + mathSet.getMedian());
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
