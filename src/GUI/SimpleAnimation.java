package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class SimpleAnimation {
    // two instance variables for the x and y cordinates
    private int xPos = 900; // x pixels from the left
    private int yPos = 10;   // y pixles from the top

    public static void main(String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(1000, 1000);
        frame.setVisible(true);

        // repeat i times
        for (int i = 0; i < 900; i++) {
            // increment the x and y cordinates
            xPos--;
            yPos++;

            // tell the panel to repaint itself (so we can see the circle in the new location)
            drawPanel.repaint();

            // pause between repaints (otherwise it will move so quickly you
            // won't SEE it move).
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // an inner class
    class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            /**
             * Fill a rectangle starting at x and y of 0
             * (0 pixels from the left and 0 pixels from thetop)
             * and make it as wide and as high as the panel is currently.
             */
            g.setColor(Color.white);
            g.fillRect(0,0, this.getWidth(), this.getHeight()); // the two methods are inherited from JPanel

            g.setColor(Color.green);
            // use the continually updated x and y cordinates of the outer class
            g.fillOval(xPos, yPos, 30, 30);
        }
    }
}
