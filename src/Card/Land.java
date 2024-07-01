package Card;

import java.lang.classfile.constantpool.Utf8Entry;
import java.util.Objects;

/*
Property.Land Class
Subclass of Property.Property.
Is a type of property that has a rent value that can be increased by building houses/a hotel in it.
 */
public class Land extends Property{
    private String Group;
    private String GroupColor;
    private int NumberOfHouses;
    private float CostOfHouses;
    private boolean Hotel;
    private float CostOfHotel;

    //Getters and Setters

    @Override
    public String printName() {
        return GroupColor + this.getName() + ANSI_RESET;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public String getGroupColor() {
        return GroupColor;
    }

    public int getNumberOfHouses() {
        return NumberOfHouses;
    }

    public float getCostOfHouses() {
        return CostOfHouses;
    }

    public void setCostOfHouses(float costOfHouses) {
        CostOfHouses = costOfHouses;
    }

    public boolean isHotel() {
        return Hotel;
    }

    public float getCostOfHotel() {
        return CostOfHotel;
    }

    public void setCostOfHotel(float costOfHotel) {
        CostOfHotel = costOfHotel;
    }

    //Constructor


    public Land(String name, float cost, float rent, float rentMult, String group, float costOfHouses, float costOfHotel) {
        super(name, cost, rent, rentMult);
        Group = group;
        if (Objects.equals(Group, "Red")) {
            GroupColor = ANSI_RED;
        }
        else if (Objects.equals(Group, "Orange")) {
            GroupColor = ANSI_ORANGE;
        }
        else if (Objects.equals(Group, "Yellow")) {
            GroupColor = ANSI_YELLOW;
        }
        else if (Objects.equals(Group, "Green")) {
            GroupColor = ANSI_GREEN;
        }
        else if (Objects.equals(Group, "Cyan")) {
            GroupColor = ANSI_CYAN;
        }
        else if (Objects.equals(Group, "Blue")) {
            GroupColor = ANSI_BLUE;
        }
        else if (Objects.equals(Group, "Purple")) {
            GroupColor = ANSI_PURPLE;
        }
        else if (Objects.equals(Group, "Pink")) {
            GroupColor = ANSI_PINK;
        }
        NumberOfHouses = 0;
        CostOfHouses = costOfHouses;
        Hotel = false;
        CostOfHotel = costOfHotel;
    }

    /**
     * Adds a number of houses to the Property.Land, up to a max of 4.
     * @param NumberOfHouses Number of Houses to add to the Property.Land.
     * @return Number of Houses that were added to the Property.Land.
     */
    public int add_Houses(int NumberOfHouses) {
        if (this.NumberOfHouses + NumberOfHouses <= 4 && !this.Hotel) {
            this.NumberOfHouses += NumberOfHouses;
            return NumberOfHouses;
        }
        else {
            return 0;
        }
    }

    /**
     * Adds a number of houses to the Property.Land, up to a max of 4.
     * @return True if successful, false if operation in invalid.
     */
    public boolean addHotel() {
        if (this.NumberOfHouses == 4) {
            this.Hotel = true;
            this.NumberOfHouses = 0;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public float RentCost() {
        double RentCost = this.getRent()*Math.pow(this.getRentMult(),this.NumberOfHouses);
        return (float) RentCost;
    }

    @Override
    public String toString() {
        return GroupColor + this.getName() + '\n' +
                this.getGroup() + " (" + (this.getProprietary() == -1 ? "Sem Dono" : "Dono:" + this.getProprietary()) + ")\n" +
                "Preço: " + this.getCost() + "$\n" +
                "Aluguel: " + this.getRent() + "$\n" +
                "Casas: " + this.getNumberOfHouses() + "$\n" +
                "Hotel: " + ((this.isHotel()) ? "Yes" : "No") + "$\n" +
                ANSI_RESET;
    }
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_ORANGE = "\033[38;5;208m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PINK = "\033[38;5;170m";
    public static final String ANSI_WHITE = "\u001B[37m";
}
