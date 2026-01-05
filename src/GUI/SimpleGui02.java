package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui02 implements ActionListener {
    private JButton button;
    private JCheckBox checkBox;

    public static void main(String[] args) {
        SimpleGui02 gui = new SimpleGui02();
        gui.go();

    }

    public void go() {
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout()); // set the layout manager that allows multiple components

        button = new JButton("Click on me");
        button.setFont(new Font("Hack", Font.BOLD, 50));
        button.addActionListener(this);

        checkBox = new JCheckBox("I'm the check box");
        checkBox.setFont(new Font("Hack", Font.PLAIN, 40));

        frame.getContentPane().add(button);
        frame.getContentPane().add(checkBox);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1200, 1200);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        button.setText("I've been clicked");
    }
}
