package GUI;

import javax.swing.*;

public class SimpleGui01 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton("click on me");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(button);

        frame.setSize(1200, 400);

        frame.setVisible(true);
    }
}
