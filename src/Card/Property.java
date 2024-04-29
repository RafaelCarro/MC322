package Card;

/*
Property.Property Class
Superclass that defines all the base property elements and methods, every space in the Board is property of some kind.
 */
public abstract class Property extends Card{

    private float Cost;
    private float Rent;
    private float RentMult;

    //Getters and Setters

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
        super(name);
        Cost = cost;
        Rent = rent;
        RentMult = rentMult;
    }

    @Override
    public String toString() {
        return this.getName() + '\n' +
                this.getProprietary() + '\n' +
                "Custo: " + Cost + '\n' +
                "Aluguel: " + Rent + '\n';
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
