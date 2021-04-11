import java.util.Scanner;

public class Item{
    private String displayName;
    private String itemID;
    private int amount;
    private String desc;
    private double chance;
    private String command;

    public Item(){
        Scanner in = new Scanner(System.in);
        System.out.println("What's the name you want displayed for the reward?(Can use color codes, example: &c3 Poke Balls):");
        displayName = in.nextLine();
        System.out.println("What item do you want to display?(item id # or descriptor, example: 5151 or PIXELMON_TOUGA_BERRY):");
        itemID = in.nextLine();
        System.out.println("How many items do you want displayed?:");
        amount = in.nextInt();
        in.nextLine();
        System.out.println("What is the description of this reward?:");
        desc = in.nextLine();
        System.out.println("What is the percent chance of landing on this reward?(without % sign):");
        chance = in.nextDouble();
        in.nextLine();
        System.out.println("What command do you want to execute when they land on this reward?");
        command = in.nextLine();
    }

    public String getDisplayName(){return displayName;}
    public String getItemID(){return itemID;}
    public int getAmount(){return amount;}
    public String getDesc(){return desc;}
    public double getChance(){return chance;}
    public String getCommand(){return command;}

    public String toString(){
        return ("======================================"
                +("|| Item Name: " +displayName +"\n")
                +("|| Item ID: " +itemID +"\n")
                +("|| Amount: " +amount +"\n")
                +("|| Description: " +desc +"\n")
                +("|| Chance: " +chance +"%" +"\n")
                +("|| Commands: " +command +"\n")
                +"=====================================");
    }
}
