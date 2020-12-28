package Adam;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class menuMain {

    public static Menu mainMenu = new Menu();
    static GraphicsConfiguration gc;

    public static void main(String[] args) throws FileNotFoundException {

        JLabel label = new JLabel();
        label.setText("akármi");
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 200);
        frame.setVisible(true);

        makeWindow();
        mainMenu.setTitle("Gyökér ");
        readMenuFromFile();

        mainMenu.getSubMenus().get("1").navigateMenu();


    }

    public static void makeWindow() {
       // Window window1 = new Window();

       MyFrame myFrame = new MyFrame();
    }

    public static void readMenuFromFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("menu.txt"));

        while (sc.hasNextLine()) {
            String[] split = sc.nextLine().split("-");

            mainMenu.makeMenu(split[0], split[1], split[2]);
        }

        // sc.close();
        System.out.println("File beolvasva: ");
    }

    public static void runMenu(String menuCode) {
        switch (menuCode) {
            case "111":
                // Regisztráció
                System.out.println("Regisztráció...");
                break;
            case "112":
                System.out.println("Keresés adott felhasználóra (Kölcsönzött könyveinek listája)");
                break;
            case "121":
                System.out.println("Új könyv nyílvántartásba vétele");
                break;
            case "122":
                System.out.println("Keresés");
                break;
            case "123":
                System.out.println("Selejtezés");
                break;
            case "131":
                System.out.println("Kikölcsönzés");
                break;
            case "132":
                System.out.println("Visszavétel");
                break;
            case "133":
                System.out.println("Könyv kölcsönzési története");
                break;
            case "134":
                System.out.println("Adott nap kölcsönzési története");
                break;
            case "141":
                System.out.println("Legnépszerűbb könyvek");
                break;
            case "142":
                System.out.println("Adott könyv átlagos kintléte");
                break;
            case "143":
                System.out.println("Felhasználók összes eddigi kölcsönzése");
                break;
        }

    }

}
