package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui03 implements ActionListener {
    private JFrame frame;

    public static void main(String[] args) {
        SimpleGui03 gui = new SimpleGui03();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Button button = new Button("Change color");
        button.setFont(new Font("Hack", Font.PLAIN, 40));

        button.addActionListener(this);

        MyDrawPanel panel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(1700, 1700);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        frame.repaint();
    }
}
