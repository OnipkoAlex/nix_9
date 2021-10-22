package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ua.com.alevel.level1.Chess;
import ua.com.alevel.level1.ChessSwing;
import ua.com.alevel.level1.Triangle;
import ua.com.alevel.level1.UniqueNumbers;


public class module_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String menu;
        do {
            System.out.println("1. Level 1.");
            System.out.println("2. Level 2.");
            System.out.println("3. Level 3.");
            System.out.println("4. Exit");
            menu = reader.readLine();
            switch (menu) {
                case "1": {
                    levelOne();
                    menu = "";
                    break;
                }
                case "2": {
                    levelTwo();
                    menu = "";
                    break;
                }
                case "3": {
                    levelThree();
                    menu = "";
                    break;
                }
            }
        } while(menu != "4");
    }
    public static void levelOne() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String menu;
        do {
            System.out.println("1. Array of numbers task.");
            System.out.println("2. Chess task.");
            System.out.println("3. Triangle area task.");
            System.out.println("4. Exit");
            menu = reader.readLine();
            switch (menu) {
                case "1": {
                    UniqueNumbers.startSearchForUniqueNumbers();
                    menu = "";
                    break;
                }
                case "2": {
                    ChessSwing.chessGenerate();
                    menu = "";
                    break;
                }
                case "3": {
                    Triangle.triangleArea();
                    menu = "";
                    break;
                }
            }
        } while(!menu.equals("4"));
    }
    public static void levelTwo() {


    }
    public static void levelThree() {

    }
}
