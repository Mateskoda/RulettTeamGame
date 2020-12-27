package Adam;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    MyFrame() {

        this.setTitle("Window Title");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 420);
        this.setVisible(true);
        ImageIcon image = new ImageIcon("book.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(130, 170, 210));
    }
}
