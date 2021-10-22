package ua.com.alevel.level1;

public class Chess {
    public static void chessGame() {
        for (int i = 0; i < 8; i++) {
            drawLine();
            for (int j = 0; j <= 8; j++) {
                System.out.print("|  ");
            }
            System.out.println();
        }
    }

    public static void drawLine() {
        for (int i = 0; i < 8; i++) {
            System.out.print("--");
        }
        System.out.println();
    }
}
