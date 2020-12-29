package Adam.GraphSwing;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SwingTutor {

    private static int speed = 10;

    public static void main(String[] args) {
        JFrame frame = new JFrame("My first window");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        Circle circle = new Circle();
        circle.setBounds(10, 30, 103, 103);
        //----

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ev) {

            }

            @Override
            public void keyPressed(KeyEvent ev) {
                int keyCode = ev.getKeyCode();
                Rectangle origBoudns = circle.getBounds();
                if(keyCode == KeyEvent.VK_RIGHT){
                    circle.setBounds(origBoudns.x + speed,
                            origBoudns.y,
                            origBoudns.width,
                            origBoudns.height);
                }
                else if(keyCode == KeyEvent.VK_LEFT){
                    circle.setBounds(origBoudns.x - speed,
                            origBoudns.y,
                            origBoudns.width,
                            origBoudns.height);
                }
                else if(keyCode == KeyEvent.VK_DOWN){
                    circle.setBounds(origBoudns.x,
                            origBoudns.y + speed,
                            origBoudns.width,
                            origBoudns.height);
                }
                else if(keyCode == KeyEvent.VK_UP){
                    circle.setBounds(origBoudns.x,
                            origBoudns.y - speed,
                            origBoudns.width,
                            origBoudns.height);
                }
            }

            @Override
            public void keyReleased(KeyEvent ev) {

            }
        });
        frame.add(circle);
        frame.setVisible(true);

    }

}
