package Adam.GraphSwing;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SwingTutorPoint {

    private static final int maxSpeed = 20;
    private static int speed ;
    private static int horizontal, vertical, maxdelay = 200, delay ;

    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        JFrame frame = new JFrame("My first window");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        Circle circle = new Circle();
        circle.setBounds(10, 30, 103, 103);



        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ev) {

            }

            @Override
            public void keyPressed(KeyEvent ev) {
                int keyCode = ev.getKeyCode();

                if (keyCode == KeyEvent.VK_RIGHT) {
                    if (horizontal < 0 && speed > 0) {
                        speed--;
                    } else if (horizontal < 1 && speed == 0) {
                        horizontal++;

                    } else if (speed < maxSpeed) {
                        speed++;
                    }
                    setDelay(speed);


                } else if (keyCode == KeyEvent.VK_LEFT) {
                    if (horizontal > 0 && speed > 0) {
                        speed--;
                    } else if (horizontal > -1 && speed == 0) {
                        horizontal--;

                    } else if (speed < maxSpeed) {
                        speed++;
                    }
                    setDelay(speed);


                } else if (keyCode == KeyEvent.VK_DOWN) {
                    if (vertical < 0 && speed > 0) {
                        speed--;
                    } else if (vertical < 1 && speed == 0) {
                        vertical++;

                    } else if (speed < maxSpeed) {
                        speed++;
                    }
                    setDelay(speed);

                } else if (keyCode == KeyEvent.VK_UP) {
                    if (vertical > 0 && speed > 0) {
                        speed--;
                    } else if (vertical > -1 && speed == 0) {
                        vertical--;

                    } else if (speed < maxSpeed) {
                        speed++;
                    }
                    setDelay(speed);
                }
                System.out.println(" speed: "+speed+"  delay: "+delay);
            }

            @Override
            public void keyReleased(KeyEvent ev) {

            }
        });

         frame.add(circle);

        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Rectangle origBoudns = circle.getBounds();
                circle.setBounds(origBoudns.x + horizontal,
                        origBoudns.y + vertical,
                        origBoudns.width,
                        origBoudns.height);

            }
        });
        timer.start();
        frame.setVisible(true);
    }

    public static void setDelay(int speed) {
        delay = maxdelay - speed*5;
    }
}




