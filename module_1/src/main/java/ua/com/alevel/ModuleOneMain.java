package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ua.com.alevel.level1.ChessSwing;
import ua.com.alevel.level1.Triangle;
import ua.com.alevel.level1.UniqueNumbers;
import ua.com.alevel.level2.BinaryTree;
import ua.com.alevel.level2.Tags;
import ua.com.alevel.level3.LifeGame;


public class ModuleOneMain {

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
        } while(!menu.equals("4"));
    }

    public static void levelOne() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String menu;
        do {
            System.out.println("1. Array of numbers task.");
            System.out.println("2. Chess task.");
            System.out.println("3. Triangle area task.");
            System.out.println("4. Go to main menu.");
            menu = reader.readLine();
            switch (menu) {
                case "1": {
                    UniqueNumbers.startSearchForUniqueNumbers();
                    menu = "";
                    break;
                }
                case "2": {
                    ChessSwing.run();
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

    public static void levelTwo() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String menu;
        do {
            System.out.println("1. Tags task.");
            System.out.println("2. Binary tree task.");
            System.out.println("3. Go to main menu.");
            menu = reader.readLine();
            switch (menu) {
                case "1": {
                    Tags.startTags();
                    menu = "";
                    break;
                }
                case "2": {
                    BinaryTree.run();
                    menu = "";
                    break;
                }
            }
        } while(!menu.equals("3"));
    }

    public static void levelThree() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String menu;
        do {
            System.out.println("1. Life game.");
            System.out.println("2. Go to main menu.");
            menu = reader.readLine();
            switch (menu) {
                case "1": {
                    LifeGame.lifeGameRun();
                    menu = "";
                    break;
                }
            }
        } while(!menu.equals("2"));
    }
}
