package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui03 {
    private JFrame frame;
    private JLabel label;

    class ColorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            frame.repaint();
        }
    }

    class LabelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            label.setText("Text chenged");
        }
    }

    public static void main(String[] args) {
        SimpleGui03 gui = new SimpleGui03();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton colorButton = new JButton("Change Color");
        colorButton.setFont(new Font("Hack", Font.BOLD, 80));
        colorButton.addActionListener(new ColorListener());

        JButton labelButton = new JButton("Change Label");
        labelButton.setFont(new Font("Hack", Font.BOLD, 20));
        labelButton.addActionListener(new LabelListener());

        label = new JLabel("I'm a label");
        label.setFont(new Font("Hack", Font.BOLD, 20));
        MyDrawPanel panel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.setSize(1700, 1700);
        frame.setVisible(true);
    }
}
