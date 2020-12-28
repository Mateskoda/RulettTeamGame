package Adam;

import java.util.ArrayList;
import java.util.Random;

public class MainApp {
        static ArrayList<Player> players = new ArrayList();
        static ArrayList<Player> actualWinners = new ArrayList();
        static int winnerNumber;
        static int minBet = 1;
        static JframeWindows ui;
        private static int[] expectedNums = new int[37];
        static int actualBet = 0;
        static int maxBet = 10000;
        static Player me;

        public MainApp() {
        }

        public static void main(String[] args) {
            new MainApp();
            ui = new JframeWindows();
            me = new Player(ui.getNameOfPlayer(), ui.getStartingCapital());
            TableFrame tableFrame = new TableFrame();
        }

        public static void userChoosedToPlay() {
            players.clear();
            expectedNums = ui.getNumBet();
            actualBet = ui.getBetAmount();
            if (expectedNums.length == 1) {                      //ha egy szamra fogadunk akkor egy egy elemu int tombot adunk at a setbetnumbers()nek
                me.setBetNumbers(ui.getRangedBet());
            } else {
                me.setBetNumbers(expectedNums);         //egy tombot agunk at ha tobb mezore fogadunk
            }
            me.setActuelBet(actualBet);
            players.clear();
            players.add(me);

            simulateXTurn(1);
            int sum = ui.getStartingCapital();
            ui.printResult(winnerNumber, ui.getNameOfPlayer(), me.getActuelBet(), sum + me.getActualCapital(), me.getActualCapital());
        }

        public static void simulateXTurn(int x) {
            for (int i = 0; i < x; ++i) {
                oneTurn();
            }
        }

        public static void oneTurn() {
            for (int i = 0; i < players.size(); i++) {
                players.get(i).takeABet();
            }
            winnerNumber = spinTheWheel();
            winnersReward();
            losersReward();
        }



        public static int spinTheWheel() {
            return (new Random()).nextInt(37);
        }

        public static void winnersReward() {
            int sum;
            for (Player p : players) {
                for (int i = 0; i < ui.getRangedBet().length; i++) {/////at kell adni a jateokosnak is
                    if (ui.getRangedBet()[i] == winnerNumber) {
                        actualWinners.add(p);
                        if (ui.getRangedBet().length != 1) {
                            sum = p.getActualCapital() + p.getActuelBet();
                        } else {
                            sum = p.getActualCapital() + p.getActuelBet() * 5;
                        }
                        p.setActualCapital(sum);
                        break;
                    }
                }
            }
        }




        public static void losersReward() {
            for (Player player : players) {
                if (!(actualWinners.contains(player))) {
                    player.setActualCapital(player.getActualCapital() - player.getActuelBet());
                    break;
                }
            }
            actualWinners.clear();
        }

        public static int getMaxBet() {
            return maxBet;
        }
    }
