import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConfigGen {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int menu = 0;
        System.out.println("=======================================================");
        System.out.println("Crazy Crates Config Generator -- Created by ice45core0");
        System.out.println("=======================================================");
        System.out.println("Type the number for your selection and hit enter");
        do {
            System.out.println("[1]. Create new crate file");
            System.out.println("[2]. Edit existing crate file");
            System.out.println("[3]. Quit");
            menu = in.nextInt();
            in.nextLine();
            switch (menu) {
                case 1:
                    newCrate();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid selection, type one of the numbers and hit enter");
                    break;
            }
        } while (menu != 3);
    }

    public static void newCrate() {
        String type;
        System.out.println("What would you like to name the config file? (do not include the extension, example: ___________.yml)");
        String fileName = in.nextLine();
        try {
            FileWriter file = new FileWriter(fileName +".yml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("What would you like to name the crate?(Can use color codes): ");
        String name = in.nextLine();
        do {
            System.out.println("What type of crate is it?(CSGO/QuadCrate/QuickCrate/Roulette/CrateOnTheGo/FireCracker/Wonder/Wheel/War/Cosmic)");
            type = in.nextLine();
            if (type != "CSGO" || type != "QuadCrate" || type != "QuickCrate" || type != "Roulette" || type != "CrateOnTheGo" || type != "FireCracker" || type != "Wonder" || type != "Wheel" || type != "War" || type != "Cosmic"){
                System.out.println("Invalid input, please use one of the types provided.");
            }
        }while (type != "CSGO" || type != "QuadCrate" || type != "QuickCrate" || type != "Roulette" || type != "CrateOnTheGo" || type != "FireCracker" || type != "Wonder" || type != "Wheel" || type != "War" || type != "Cosmic");
        System.out.println("What description would you like to give this crate?:");
        String crateDesc = in.nextLine();
        System.out.println("What description would you like to give the key?:");
        String keyDesc = in.nextLine();
        int menu = 0;
        do{
            System.out.println("-------------------------------------------------------");
            System.out.println("[1]. Add item");
            System.out.println("[2]. Edit item");
            System.out.println("[3]. Save crate to file.");
            menu = in.nextInt();

            switch (menu) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid selection, type one of the numbers and hit enter");
                    break;
            }
        }while (menu != 3);
    }

}
