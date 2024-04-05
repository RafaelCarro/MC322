/*
Property Class
Superclass that defines all the base property elements and methods, every space in the Board is property of some kind.
 */
public abstract class Property {
    private String name;
    private int Proprietary;
    private float Cost;
    private float Rent;
    private float RentMult;

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProprietary() {
        return Proprietary;
    }

    public void setProprietary(int proprietary) {
        Proprietary = proprietary;
    }

    public float getCost() {
        return Cost;
    }

    public void setCost(float cost) {
        Cost = cost;
    }

    public float getRent() {
        return Rent;
    }

    public void setRent(float rent) {
        Rent = rent;
    }

    public float getRentMult() {
        return RentMult;
    }

    public void setRentMult(float rentMult) {
        RentMult = rentMult;
    }

    //Constructor
    //Como elas iniciam sem proprietário, a propriedade não é incluída no construtor
    public Property(String name, float cost, float rent, float rentMult) {
        this.name = name;
        Cost = cost;
        Rent = rent;
        RentMult = rentMult;
    }

    //Rent Calculator

    /**
     * Calculates the rent cost.
     * @return float
     */
    public float RentCost() {
        return this.Rent;
    }
}
