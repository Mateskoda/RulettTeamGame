package Adam;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableFrame extends JFrame implements ActionListener {
    private ImageIcon tableIcon;
    private JLabel myLabel;
    private JPanel panel;

    public TableFrame() {
        panel = new JPanel();
        tableIcon = new ImageIcon("europeantable.jpg");
        myLabel = new JLabel(tableIcon);
        panel.add(myLabel);
        panel.setBackground(Color.DARK_GRAY);
        this.setTitle("RúlerRoulette");
        this.add(panel);
        this.setSize(600, 415);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
