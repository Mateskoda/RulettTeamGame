package Adam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Menu {
    public String runningCode;
    public boolean isItLast;
    public String id;
    public String title;
    public HashMap<String, Menu> subMenus = new HashMap<>();

    public Menu() {
    }

    public Menu(String runningCode, boolean isItLast, String id, String title, HashMap<String, Menu> subMenus) {
        this.runningCode = runningCode;
        this.isItLast = false;
        this.id = id;
        this.title = title;
        this.subMenus = subMenus;
    }

    public String getRunningCode() {
        return runningCode;
    }

    public void setRunningCode(String runningCode) {
        this.runningCode = runningCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isItLast() {
        return isItLast;
    }

    public void setItLast(boolean itLast) {
        isItLast = itLast;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public HashMap<String, Menu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(HashMap<String, Menu> subMenus) {
        this.subMenus = subMenus;
    }

    public void makeMenu(String path, String myTitle, String runningCode) {

        Menu newMenu = new Menu();
        HashMap<String, Menu> subMenuMap = this.getSubMenus();
        String id = String.valueOf(path.charAt(0));
        newMenu.setId(id);

        if (path.length() == 1) {
            if (runningCode.length() > 0) {
                newMenu.setRunningCode(runningCode);
            }

            newMenu.setTitle(myTitle);
            newMenu.setItLast(true);
            subMenuMap.putIfAbsent(path, newMenu);
            this.setSubMenus(subMenuMap);
        } else {

            subMenuMap.putIfAbsent(id, newMenu);
            this.setSubMenus(subMenuMap);
            newMenu = this.getSubMenus().get(id);
            newMenu.makeMenu(path.substring(1), myTitle, runningCode);
        }

    }

    public void navigateMenu() {

        if (this.isItLast && !this.getRunningCode().contains("0")) {
            Main.runMenu(this.getRunningCode());
        } else {
            System.out.println(this.getTitle());
            boolean goon = true;

            HashMap<String, Menu> mySubMenuMap = this.getSubMenus();
            Menu selectedMenu;
            Scanner sc = new Scanner(System.in);
            String answer;

            while (goon) {
                System.out.println(" Válassz az alábbi menüpontok közűl!");
                System.out.println("  (0)  Vissza az előző menűbe");
                Iterator iterator = mySubMenuMap.entrySet().iterator();

                while (iterator.hasNext()) {

                    System.out.println("  " + iterator.next());
                }
                answer = sc.next();

                if (answer.contains("0")) {
                    goon = false;
                } else if (mySubMenuMap.keySet().contains(answer)) {
                    selectedMenu = mySubMenuMap.get(answer);
                    selectedMenu.navigateMenu();
                } else {
                    System.out.println("Hibás adat bevitel. A zárójelekben feltűntetett számok közül válasszon!");
                }
            }
        }
    }



    public void showMenu() {
        HashMap<String, Menu> mySubMenuMap = this.getSubMenus();
        Iterator iterator = mySubMenuMap.entrySet().iterator();
        System.out.println(" Title: " + this.getTitle());
        System.out.println(" Size of SubMenus: " + this.getSubMenus().size());
        System.out.println("Running code: " + this.runningCode);
        System.out.print(" SubMenus: ");
        while (iterator.hasNext()) {
            System.out.print(" " + iterator.next());
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return " (" + id + ") " + title;
    }
}
