/*
Land Class
Subclass of Property.
Is a type of property that has a rent value that can be increased by building houses/a hotel in it.
 */
public class Land extends Property{
    private String Group;
    private int NumberOfHouses;
    private float CostOfHouses;
    private boolean Hotel;
    private float CostOfHotel;

    //Getters and Setters

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
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
        NumberOfHouses = 0;
        CostOfHouses = costOfHouses;
        Hotel = false;
        CostOfHotel = costOfHotel;
    }

    /**
     * Adds a number of houses to the Land, up to a max of 4.
     * @param NumberOfHouses Number of Houses to add to the Land.
     * @return Number of Houses that were added to the Land.
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
     * Adds a number of houses to the Land, up to a max of 4.
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
}
