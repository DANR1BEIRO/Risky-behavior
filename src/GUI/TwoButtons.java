package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoButtons {
    private JFrame frame;
    private JLabel label;
    private MyDrawPanel panel;


    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel = new MyDrawPanel();

        JButton labelButton = new JButton("Change Label");
        labelButton.setFont(new Font("Hack", Font.BOLD, 20));
        labelButton.addActionListener(event -> label.setText("Text changed"));

        JButton colorButton = new JButton("Change Color");
        colorButton.setFont(new Font("Hack", Font.BOLD, 80));
        colorButton.addActionListener(event -> panel.changeColor());

        label = new JLabel("I'm a label");
        label.setFont(new Font("Hack", Font.BOLD, 20));

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.setSize(1700, 1700);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }
}

    /*class LabelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            label.setText("Text chenged");
        }
    }

    class ColorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            panel.changeColor();
        }
    }*/
