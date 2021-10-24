package ua.com.alevel.level1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

public class ChessSwing {
    JPanel windowContent;
    JTextField displayField;
    int coordinateI;
    int coordinateJ;
    JButton[][] buttons = new JButton[8][8];
    JPanel pl;
    char[] letterSide = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    SimpleListener listener = new SimpleListener();
    boolean firstRun = true;

    ChessSwing() {
        windowContent = new JPanel();
        BorderLayout bl = new BorderLayout();
        windowContent.setLayout(bl);
        displayField = new JTextField(30);
        displayField.setEnabled(false);
        displayField.setForeground(Color.BLACK);
        windowContent.add("North", displayField);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j] = new JButton(String.valueOf((i + 1)) + letterSide[j]);
                buttons[i][j].setBackground(Color.LIGHT_GRAY);
            }
        }

        pl = new JPanel();
        GridLayout gl = new GridLayout(8, 8);
        pl.setLayout(gl);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j].addActionListener(listener);
                pl.add(buttons[i][j]);
            }
        }

        windowContent.add("Center", pl);
        JFrame frame = new JFrame("Chess");
        frame.setContentPane(windowContent);
        frame.setSize(410, 500);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
        });
    }

    public static void run() {
        new ChessSwing();
    }

    public void buttonGrey() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j].setBackground(Color.LIGHT_GRAY);
            }
        }
    }

    public void buttonGreen(int i, int j) {
        displayField.setText("");
        if ((i - 1) >= 0 && (j + 2) < 8) buttons[i - 1][j + 2].setBackground(Color.GREEN);
        if ((i + 1) < 8 && (j + 2) < 8) buttons[i + 1][j + 2].setBackground(Color.GREEN);
        if ((i + 2) < 8 && (j + 1) < 8) buttons[i + 2][j + 1].setBackground(Color.GREEN);
        if ((i + 2) < 8 && (j - 1) >= 0) buttons[i + 2][j - 1].setBackground(Color.GREEN);
        if ((i + 1) < 8 && (j - 2) >= 0) buttons[i + 1][j - 2].setBackground(Color.GREEN);
        if ((i - 1) >= 0 && (j - 2) >= 0) buttons[i - 1][j - 2].setBackground(Color.GREEN);
        if ((i - 2) >= 0 && (j - 1) >= 0) buttons[i - 2][j - 1].setBackground(Color.GREEN);
        if ((i - 2) >= 0 && (j + 1) < 8) buttons[i - 2][j + 1].setBackground(Color.GREEN);
    }

    public boolean isValidTurn(int i, int j) {
        boolean valid = false;
        if (i == (coordinateI - 1) && j == (coordinateJ + 2)) valid = true;
        if (i == (coordinateI + 1) && j == (coordinateJ + 2)) valid = true;
        if (i == (coordinateI + 2) && j == (coordinateJ + 1)) valid = true;
        if (i == (coordinateI + 2) && j == (coordinateJ - 1)) valid = true;
        if (i == (coordinateI + 1) && j == (coordinateJ - 2)) valid = true;
        if (i == (coordinateI - 1) && j == (coordinateJ - 2)) valid = true;
        if (i == (coordinateI - 2) && j == (coordinateJ - 1)) valid = true;
        if (i == (coordinateI - 2) && j == (coordinateJ + 1)) valid = true;
        return valid;
    }

    private class SimpleListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (e.getSource() == buttons[i][j]) {
                        if (firstRun) {
                            buttons[i][j].setBackground(Color.RED);
                            buttonGreen(i, j);
                            coordinateI = i;
                            coordinateJ = j;
                            firstRun = false;
                        } else {
                            if (isValidTurn(i, j)) {
                                displayField.setText("");
                                buttonGrey();
                                buttons[i][j].setBackground(Color.RED);
                                buttonGreen(i, j);
                                coordinateI = i;
                                coordinateJ = j;
                                break;
                            } else {
                                displayField.setText("Invalid turn. Try again");
                            }
                        }
                    }
                }
            }
        }
    }
}

