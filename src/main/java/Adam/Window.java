package Adam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements ActionListener {

    JButton startButton, exitButton;
    JFrame frame = new JFrame();
    JTextField textField = new JTextField(" ..write here..", 20);

    public Window() {

        frame.setTitle("helooo..");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 200);



        Panel panel = new Panel();

        startButton = new JButton(" Start ");
        exitButton = new JButton(" Exit ");

        panel.add(textField);
        panel.add(startButton);
        panel.add(exitButton);
        frame.add(panel);
        frame.setVisible(true);
        startButton.addActionListener(this);
        exitButton.addActionListener(this);
        frame.setLocationRelativeTo(null);


    }


    public void makeButton() {
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            System.out.println(textField.getText());

        }
        if (e.getSource() == exitButton) {
            System.out.println("  ..EXIT..  ");
            frame.dispose();
        }

    }
}