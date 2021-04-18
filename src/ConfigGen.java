import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConfigGen {
    static ArrayList<Item> items = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int menu = 0;
        System.out.println("=======================================================");
        System.out.println("Crazy Crates Config Generator -- Created by ice45core0");
        System.out.println("=======================================================");
        System.out.println("Type the number for your selection and hit enter");
        do {
            System.out.println("-------------------------------------------------------");
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

    public static void newCrate() throws IOException {
        System.out.println("What would you like to name the config file? (do not include the extension, example: ___________.yml)");
        String fileName = in.nextLine();
        FileWriter file = null;
        try { 
            file = new FileWriter(fileName +".yml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        addHeader(file);
        int menu = 0;
        do{
            System.out.println("-------------------------------------------------------");
            System.out.println("[1]. Add item");
            System.out.println("[2]. Edit item");
            System.out.println("[3]. Save crate to file.");
            menu = in.nextInt();

            switch (menu) {
                case 1:
                    addItem(file);
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
        file.close();
    }
    
    public static void addHeader(FileWriter file) throws IOException {
        String type;
        System.out.println("What would you like to name the crate?(Can use color codes, example: &eVote Crate): ");
        String name = in.nextLine();
        do {
            System.out.println("What type of crate is it?(CSGO/QuadCrate/QuickCrate/Roulette/CrateOnTheGo/FireCracker/Wonder/Wheel/War/Cosmic)");
            type = in.nextLine();
            if (!type.equals("CSGO") && !type.equals("QuadCrate") && !type.equals("QuickCrate") && !type.equals("Roulette") && !type.equals("CrateOnTheGo") && !type.equals("FireCracker") && !type.equals("Wonder") && !type.equals("Wheel") && !type.equals("War") && !type.equals("Cosmic")){
                System.out.println("Invalid input, please use one of the types provided.");
            }
        }while (!type.equals("CSGO") && !type.equals("QuadCrate") && !type.equals("QuickCrate") && !type.equals("Roulette") && !type.equals("CrateOnTheGo") && !type.equals("FireCracker") && !type.equals("Wonder") && !type.equals("Wheel") && !type.equals("War") && !type.equals("Cosmic"));
        System.out.println("What description would you like to give this crate?:");
        String crateDesc = in.nextLine();
        System.out.println("What item is the key?(item id # or descriptor, example: TRIPWIRE_HOOK, or 0131, or PIXELMON_POKE_BALL):");
        System.out.println("Note: Vanilla minecraft items don't need the \"minecraft:\" part, just the item name with underscores instead of spaces.");
        String keyItem = in.nextLine();
        System.out.println("What description would you like to give the key?:");
        String keyDesc = in.nextLine();
        file.write("Crate:" +"\n");
        file.write("  CrateType: " +type +"\n");
        file.write("  CrateName: '" +name +"'" +"\n");
        file.write("  Preview-Name: '" +name +" Preview'" +"\n");
        file.write("  StartingKeys: 1" +"\n");
        file.write("  InGUI: true" +"\n");
        file.write("  Slot: 21" +"\n");
        file.write("  OpeningBroadCast: false" +"\n");
        file.write("  Broadcast: '&e&l%Player% &7is opening a " +name +"&7'" +"\n");
        file.write("  Item: 'CHEST'" +"\n");
        file.write("  Glowing: false" +"\n");
        file.write("  Name: '" +name +"'" +"\n");
        file.write("  Lore:" +"\n");
        file.write("    - '&7" +crateDesc +"'" +"\n");
        file.write("    - '&7You have &6%Keys% keys &7to open this crate with.'" +"\n");
        file.write("    - '&7&l(&e&l!&7&l) Right click to view rewards.'" +"\n");
        file.write("  Preview:" +"\n");
        file.write("    Toggle: true" +"\n");
        file.write("    ChestLines: 5" +"\n");
        file.write("    Glass:" +"\n");
        file.write("      Toggle: true" +"\n");
        file.write("      Item: 'STAINED_GLASS_PANE:7'" +"\n");
        file.write("  PhysicalKey:" +"\n");
        file.write("    Name: '" +name +" Key'" +"\n");
        file.write("    Lore:" +"\n");
        file.write("      - '&e" +keyDesc +"'" +"\n");
        file.write("      - '&eBest of luck!'" +"\n");
        file.write("    Item: '" +keyItem +"'" +"\n");
        file.write("    Glowing: true" +"\n");
        file.write("  Hologram:" +"\n");
        file.write("    Toggle: true" +"\n");
        file.write("    Height: 1.5" +"\n");
        file.write("    Message:" +"\n");
        file.write("    - '&l" +name +"'" +"\n");
        file.write("  Prizes:" +"\n");
    }

    public static void addItem(FileWriter file) throws IOException {
        Item item = new Item();
        items.add(item);
        file.write("    " +(items.indexOf(item)+1) +":\n");
        file.write("      DisplayName: '" +item.getDisplayName() +"'\n");
        file.write("      DisplayItem: '" +item.getItemID() +"'\n");
        file.write("      DisplayAmount: " +item.getAmount() +"\n");
        file.write("      Lore:\n");
        file.write("        - '" +item.getDesc() +"'\n");
        file.write("        - '&c" +item.getChance() +"% chance'\n");
        file.write("      MaxRange: 100\n");
        file.write("      Chance: " +item.getChance() +"\n");
        file.write("      Firework: false\n");
        file.write("      Glowing: false\n");
        file.write("      Player: ''\n");
        file.write("      Unbreakable: false\n");
        file.write("      Items:\n");
        file.write("      Commands:\n");
        file.write("        - '" +item.getCommand() +"'\n");
        file.write("      Messages: []\n");
        file.write("      BlackListed-Permissions: []\n");
        file.write("      Alternative-Prize:\n");
        file.write("        Toggle: false\n");
        file.write("        Commands: []\n");
        file.write("        Items: []\n");
        file.write("        Messages: []\n");
    }
}
