package Adam.GraphSwing;


import javax.swing.*;
import java.awt.*;

public class Circle extends JComponent{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.PINK);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g.drawOval(1, 1, 100, 100);

    }
}
