package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyDrawPanel extends JPanel {
    private Color startColor = Color.blue;
    private Color endColor = Color.red;

    public void changeColor() {
        Random random = new Random();

        this.startColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        this.endColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(400, 400, startColor, 1200, 1200, endColor);
        g2d.setPaint(gradient);
        g2d.fillOval(400, 400, 800, 800);
    }
}
