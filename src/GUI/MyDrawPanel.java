package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        Color startColor = new Color(red, green, blue);

        red = random.nextInt(256);
        green = random.nextInt(256);
        blue = random.nextInt(256);
        Color endColor = new Color(red, green, blue);
        GradientPaint gradient = new GradientPaint(400, 400, startColor, 1200, 1200, endColor);
        g2d.setPaint(gradient);
        g2d.fillOval(400, 400, 800, 800);
    }

    public static void go() {
        JFrame frame = new JFrame();
        MyDrawPanel myDrawPanel = new MyDrawPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(2000, 2000);
        frame.setVisible(true);

        frame.getContentPane().add(myDrawPanel);
    }

    public static void main(String[] args) {
        MyDrawPanel.go();
    }
}
