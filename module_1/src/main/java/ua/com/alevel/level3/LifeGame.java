package ua.com.alevel.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class LifeGame {

    public static boolean secondGeneration = true;
    public static void lifeGameRun() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String menu = "";
        int[][] nextGenerationMatrix;
        int[][] lifeMatrix;
        int mSize = 0;
        int nSize = 0;

        do {
            try {
                System.out.println("Enter valid M size: ");
                mSize = Integer.parseInt(reader.readLine());
                System.out.println("Enter valid N size: ");
                nSize = Integer.parseInt(reader.readLine());
            }
            catch (NumberFormatException ex) {
                System.out.println("Invalid input. Try again.");
            }
        }while(mSize <= 0 || nSize <= 0);

        System.out.println("New life game: ");
        lifeMatrix = randLifeGame(mSize, nSize);
        nextGenerationMatrix = new int[mSize][nSize];

        do {
            System.out.println("1. New life game [M x N].");
            System.out.println("2. Next generation.");
            System.out.println("3. Exit to main menu.");
            menu = reader.readLine();
            switch (menu) {
                case "1": {
                    do {
                        try {
                            System.out.println("Enter valid M size: ");
                            mSize = Integer.parseInt(reader.readLine());
                            System.out.println("Enter valid N size: ");
                            nSize = Integer.parseInt(reader.readLine());
                        }
                        catch (NumberFormatException ex) {
                            System.out.println("Invalid input.");
                        }
                    }while(mSize <= 0 || nSize <= 0);
                    System.out.println("New life game: ");
                    lifeMatrix = randLifeGame(mSize, nSize);
                    nextGenerationMatrix = new int[mSize][nSize];
                    menu = "";
                    break;
                }
                case "2": {
                    if (secondGeneration) {
                        nextGenerationMatrix = nextGeneration(lifeMatrix, mSize, nSize);
                        secondGeneration = false;
                    } else {
                        nextGenerationMatrix = nextGeneration(nextGenerationMatrix, mSize, nSize);
                    }
                    System.out.println("Next generation: ");
                    for (int i = 0; i < mSize; i++) {
                        for (int j = 0; j < nSize; j++) {
                            System.out.print(nextGenerationMatrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                    menu = "";
                    break;
                }
            }
        } while (!menu.equals("3"));
    }

    public static int[][] randLifeGame(int mSize, int nSize) {
        Random random = new Random();
        int[][] lifeMatrix = new int[mSize][nSize];
        for (int i = 0; i < mSize; i++) {
            for (int j = 0; j < nSize; j++) {
                lifeMatrix[i][j] = random.nextInt(2);
                System.out.print(lifeMatrix[i][j] + " ");
            }
            System.out.println();
        }
        secondGeneration = true;

        return lifeMatrix;
    }

    public static int[][] nextGeneration(int[][] generationMatrix, int mSize, int nSize) {
        int[][] nextGenerationMatrix = new int[mSize][nSize];

        for (int i = 0; i < mSize; i++) {
            for (int j = 0; j < nSize; j++) {
                if (aliveNeighbours(generationMatrix, i, j, mSize, nSize) < 2 && generationMatrix[i][j] == 1)
                    nextGenerationMatrix[i][j] = 0;
                if ((aliveNeighbours(generationMatrix, i, j, mSize, nSize) == 2 || aliveNeighbours(generationMatrix, i, j, mSize, nSize) == 3) && generationMatrix[i][j] == 1)
                    nextGenerationMatrix[i][j] = 1;
                if (aliveNeighbours(generationMatrix, i, j, mSize, nSize) > 3 && generationMatrix[i][j] == 1)
                    nextGenerationMatrix[i][j] = 0;
                if (aliveNeighbours(generationMatrix, i, j, mSize, nSize) == 3 && generationMatrix[i][j] == 0)
                    nextGenerationMatrix[i][j] = 1;
            }
        }

        return nextGenerationMatrix;
    }

    public static int aliveNeighbours(int[][] generationMatrix, int i, int j, int mSize, int nSize) {
        int alive = 0;
        if ((i - 1) >= 0 && (j + 1) < nSize) alive += generationMatrix[i - 1][j + 1];
        if ((i - 1) >= 0) alive += generationMatrix[i - 1][j];
        if ((i - 1) >= 0 && (j - 1) >= 0) alive += generationMatrix[i - 1][j - 1];
        if ((j + 1) < nSize) alive += generationMatrix[i][j + 1];
        if ((j - 1) >= 0) alive += generationMatrix[i][j - 1];
        if ((i + 1) < mSize && (j + 1) < nSize) alive += generationMatrix[i + 1][j + 1];
        if ((i + 1) < mSize) alive += generationMatrix[i + 1][j];
        if ((i + 1) < mSize && (j - 1) >= 0) alive += generationMatrix[i + 1][j - 1];

        return alive;
    }
}
