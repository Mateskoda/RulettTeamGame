package Adam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class JframeWindows extends JFrame implements ActionListener {
    JRadioButton startGameButton, registrationButton;
    JFrame frame = new JFrame();
    JPanel buttonsPanel;
    JPanel gamePanel;
    JPanel myGamePanel2;
    JPanel panel;
    JTextField textFieldName;
    JTextField textFieldStartingCapital;
    JTextField textFieldBetAmount;
    JTextArea textArea;
    JButton nextButton1;
    JButton nextRoundButton;
    JButton backButton1;
    JButton noMoreRoundButton;
    JButton btReturn4;
    JLabel labelPrint;
    JComboBox comboOfBets;
    JComboBox comboNumsOnWheel;
    String nameOfPlayer;
    Bet rangedBet;
    int numBet[] = new int[37];
    int betAmount;
    int startingCapital;
    Color myGreen = new Color(46, 139, 87);
    Color buttonColor = new Color(205,133,19);

    public JframeWindows() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //ennek hianyaban nem all le program csak az ablak tunik el


        gamePanel = gamePanel();
        myGamePanel2 = placeBetsPanel();

        gamePanel.setSize(800, 600);

        JLabel greetingLabel = new JLabel("      Üvözöllek a Rulett Játékban!     ");
        greetingLabel.setFont(new Font("", Font.PLAIN, 40));
        JLabel chooseLabel = new JLabel(" Válassz az alábbi menüpontok közül! \n" + "\n " +
                "\n ");
        chooseLabel.setFont(new Font("", Font.PLAIN, 30));
//***
        registrationButton = new JRadioButton("  Registration  ");
        registrationButton.setFont(new Font("", Font.PLAIN, 20));
        registrationButton.setBackground(myGreen);

//***
        startGameButton = new JRadioButton("  Start a Game!  ");
        startGameButton.setFont(new Font("", Font.PLAIN, 20));
        startGameButton.setBackground(myGreen);

        gamePanel = gamePanel();
        myGamePanel2 = placeBetsPanel();
//        myGamePanel3 = myGame3();

        buttonsPanel = new JPanel();
        buttonsPanel.setBackground(myGreen);
        buttonsPanel.add(startGameButton);
        buttonsPanel.add(registrationButton);

        ButtonGroup buttonGroup = new ButtonGroup();     //azert kell gropba tenni,hogy csak egy legyen kivalaszthato egyszerre
        buttonGroup.add(startGameButton);
        buttonGroup.add(registrationButton); //***
        startGameButton.addActionListener(this);
        registrationButton.addActionListener(this); //***

        panel = new JPanel();
        panel.add(greetingLabel);
        panel.add(chooseLabel);
        panel.add(buttonsPanel);
        panel.setBackground(myGreen);
        frame.add(panel);
        panel.add(new JLabel(new ImageIcon("rul.png")));
        frame.setSize(800, 700);
        frame.setResizable(false);
        frame.setTitle("Roulete game by MATE & GABOR & ADAM");
        frame.setLocationRelativeTo(null);  //kepernyo kozepere teszi az ablakot
        frame.setVisible(true);
        frame.validate();           //enelkul neha visszajottek az elozo komponensek
    }

    public void actionPerformed(ActionEvent e) {            //esemeny kezelo metodus
        if (startGameButton.isSelected()) {
            frame.remove(panel);
            frame.add(gamePanel);
            frame.setVisible(true);
            frame.validate();
        }

        if (e.getSource() == nextButton1) {                 //ha az esemeny forrasa a submit1 nevu gomb
            nameOfPlayer = textFieldName.getText();
            System.out.println(nameOfPlayer);
            startingCapital = Integer.parseInt(textFieldStartingCapital.getText());
            frame.remove(gamePanel);
            frame.add(myGamePanel2);
            frame.setVisible(true);
            frame.validate();
        }
        if (e.getSource() == nextRoundButton) {
            rangedBet = (Bet) (comboOfBets.getSelectedItem());
            betAmount = Integer.parseInt(textFieldBetAmount.getText());
            numBet[0] = (Integer) comboNumsOnWheel.getSelectedItem();
            frame.setVisible(true);
            frame.validate();

            MainApp.userChoosedToPlay();
        }


        if (e.getSource() == backButton1 || e.getSource() == noMoreRoundButton || e.getSource() == btReturn4) {
            frame.  dispose();                //megszunteti az adott ablakot es meghivja a maint.......
            MainApp.main(new String[]{});
        }
    }

    public JPanel gamePanel() {       //user player elso ablak
        JLabel mainLabel = new JLabel("      A játék megkezdése előtt kérlek add meg :");
        mainLabel.setFont(new Font("", Font.PLAIN, 30));
        mainLabel.setBackground(myGreen);

        JLabel userNameLabel = new JLabel();
        labelPrint = new JLabel();
        userNameLabel.setText(" a felhasználó nevedet!");
        userNameLabel.setFont(new Font("", Font.PLAIN, 20));
        userNameLabel.setBackground(myGreen);  //***

        JLabel cashLabel = new JLabel();
        labelPrint = new JLabel();
        cashLabel.setText(" a játékra szánt pénzed!");
        cashLabel.setFont(new Font("", Font.PLAIN, 20));
        cashLabel.setBackground(myGreen);


        nextButton1 = new JButton("Next");

        textFieldName = new JTextField("", 20);
        textFieldStartingCapital = new JTextField("", 10);
        textFieldStartingCapital.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (!(Character.isDigit(keyEvent.getKeyChar()))) {
                    JOptionPane.showMessageDialog(frame, "Csak számokat tartalmazhat a mező!\n" + "Kérlek töröld a többi karaktert!");
                    textFieldStartingCapital.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
            }
        });
        nextButton1.addActionListener(this);

        backButton1 = new JButton("Back");
        backButton1.addActionListener(this);


        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new GridLayout(3, 1));
        textFieldPanel.setBackground(myGreen);
        textFieldPanel.add(userNameLabel);
        textFieldPanel.add(textFieldName);
        textFieldPanel.add(cashLabel);
        textFieldPanel.add(textFieldStartingCapital);

        gamePanel = new JPanel();
        gamePanel.setBackground(myGreen);
        gamePanel.add(mainLabel);
        gamePanel.add(textFieldPanel);
        gamePanel.add(nextButton1);
        gamePanel.add(backButton1);
        gamePanel.add(new JLabel(new ImageIcon("rul.png")));
        return gamePanel;
    }

    public JPanel placeBetsPanel() {           //2. kepernyo-user play
        JLabel nameLabel = new JLabel();
        labelPrint = new JLabel();
        myGamePanel2 = new JPanel();
        Bet[] bets = new Bet[]{Bet.TOP_LINE, Bet.FIRST_COLUMN, Bet.SECOND_COLUMN, Bet.THIRD_COLUMN, Bet.FIRST_DOZEN,
                Bet.SECOND_DOZEN, Bet.THIRD_DOZEN, Bet.ONE_TO_EIGHTTEEN, Bet.NINETEEN_TO_THIRTYSIX, Bet.ODD, Bet.EVEN
                , Bet.RED, Bet.BLACK, Bet.LOW, Bet.HIGH, Bet.STRAIGHT_UP, Bet.STREET, Bet.CORNER, Bet.SIX_LINE};

        comboOfBets = new JComboBox(bets);
        comboOfBets.setBackground(buttonColor);
        Integer[] nums = new Integer[]{-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
        comboNumsOnWheel = new JComboBox(nums);
        comboNumsOnWheel.setBackground(buttonColor);

        JPanel gameJPanel = new JPanel();

        nextRoundButton = new JButton("Next Round");
        nextRoundButton.addActionListener(this);
        nextRoundButton.setBackground(buttonColor);

        noMoreRoundButton = new JButton("No MOre Round");
        noMoreRoundButton.setBackground(buttonColor);
        noMoreRoundButton.addActionListener(this);

        textFieldBetAmount = new JTextField("***",10);

        textFieldBetAmount.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (!(Character.isDigit(keyEvent.getKeyChar()))) {
                    JOptionPane.showMessageDialog(frame, "Csak számokat tartalmazhat a mező!" +
                            "\n Kérlek töröld a többi karaktert!");
                    frame.remove(panel);
                    frame.add(gamePanel);
                    frame.setVisible(true);
                    frame.validate();
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
            }
        });

        gameJPanel.setPreferredSize(new Dimension(600, 500));
        gameJPanel.setBackground(myGreen);

        nameLabel.setText("Hello, kerem tedd meg a tétedet és a fogadásodat!");
        nameLabel.setBackground(myGreen);
        gameJPanel.add(nameLabel);

        JLabel chooseLabel = new JLabel();
        chooseLabel.setText("válassz a mezők közül, vagy adj meg egy számot");
        chooseLabel.setBackground(myGreen);
        gameJPanel.add(chooseLabel);

        gameJPanel.add(comboOfBets);
        gameJPanel.add(comboNumsOnWheel);
        myGamePanel2.add(new JLabel(new ImageIcon("europeantable.jpg")));
        myGamePanel2.add(gameJPanel);

        gameJPanel.add(new JLabel("mennyi pézben fogadsz?"));
        gameJPanel.add(textFieldBetAmount);

        gameJPanel.add(labelPrint);
        gameJPanel.add(nextRoundButton);
        gameJPanel.add(noMoreRoundButton);

        return myGamePanel2;
    }


    public int[] getRangedBet() {           //itt dolgozzuk fel az enumokat
        if (rangedBet == Bet.BLACK) {
            return new int[]{2, 4, 6, 8, 10, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
        } else if (rangedBet == Bet.CORNER) {
            return new int[]{1, 2, 4, 5, 17, 18, 20, 21};
        } else if (rangedBet == Bet.EVEN) {
            return new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36};
        } else if (rangedBet == Bet.FIRST_COLUMN) {
            return new int[]{1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34};
        } else if (rangedBet == Bet.FIRST_DOZEN) {
            return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        } else if (rangedBet == Bet.HIGH) {
            return new int[]{19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
        } else if (rangedBet == Bet.LOW) {
            return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        } else if (rangedBet == Bet.NINETEEN_TO_THIRTYSIX) {
            return new int[]{19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
        } else if (rangedBet == Bet.ODD) {
            return new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35};
        } else if (rangedBet == Bet.ONE_TO_EIGHTTEEN) {
            return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        } else if (rangedBet == Bet.RED) {
            return new int[]{1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        } else if (rangedBet == Bet.SECOND_COLUMN) {
            return new int[]{2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35};
        } else if (rangedBet == Bet.SECOND_DOZEN) {
            return new int[]{13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
        } else if (rangedBet == Bet.SIX_LINE) {
            return new int[]{1, 2, 3, 4, 5, 6, 28, 29, 30, 31, 32, 33};
        } else if (rangedBet == Bet.STRAIGHT_UP) {
            return new int[]{0};
        } else if (rangedBet == Bet.STREET) {
            return new int[]{1, 2, 3, 4, 5, 6};
        } else if (rangedBet == Bet.THIRD_COLUMN) {
            return new int[]{3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36};
        } else if (rangedBet == Bet.THIRD_DOZEN) {
            return new int[]{25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
        } else if (rangedBet == Bet.TOP_LINE) {
            return new int[]{0, 1, 2, 3};
        }
        return null;
    }

    public Integer getBetAmount() {
        return this.betAmount;
    }

    public int[] getNumBet() {
        return numBet;
    }

    public String getNameOfPlayer() {
        return nameOfPlayer;
    }

    public int getStartingCapital() {
        return startingCapital;
    }


    //ez a ket metodus felelos a kiiratasert

    public void printResult(int winnerNumber, String name, int bet, int actualCapital, int rewards) {
        labelPrint.setText("<html>Winner number:  " + winnerNumber + "    name:  " + name + " <br/>" + "bet:    " + bet + " actual capital:     " + actualCapital + "   rewards: " + rewards + "</html>");
    }

    public void printResultforTextarea(int winnerNumber, String name, int bet, int actualCapital, int rewards) {
        textArea.append("Winner number:  " + winnerNumber + "   name:  " + name + "      bet:    " + bet + "     actual capital:     " + actualCapital + "    rewards: " + rewards + "\n");
    }
}