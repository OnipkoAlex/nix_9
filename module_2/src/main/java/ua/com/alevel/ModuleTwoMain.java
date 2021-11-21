package ua.com.alevel;

import ua.com.alevel.dates.DateFormat;
import ua.com.alevel.graphs.Graphs;
import ua.com.alevel.names.UniqueNames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ModuleTwoMain {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String menu = "";

        do {
            System.out.println("1. Date task.");
            System.out.println("2. Unique name task.");
            System.out.println("3. Graph task.");
            System.out.println("4. Exit.");
            System.out.println("Your choice: ");

            try {
                menu = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (menu) {
                case "1": {
                    DateFormat.isValidFormat();
                    menu = "";
                    break;
                }

                case "2": {
                    UniqueNames.runUniqueNames();
                    menu = "";
                    break;
                }

                case "3": {
                    Graphs.runGraphs();
                    menu = "";
                    break;
                }

                case "4": {
                    System.exit(0);
                }
            }
        } while (true);

    }
}
