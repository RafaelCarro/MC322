/*
Station Class
Subclass of Property.
Is a type of property that has a fixed rent value that can be increased by having other Station properties.
 */
public class Station extends Property{
    public Station(String name, float cost, float rent, float rentMult) {
        super(name, cost, rent, rentMult);
    }

    @Override
    public float RentCost() {
        return this.getRent();
    }
}
