/*
Station Class
Subclass of Property.
Is a type of property that has a fixed rent value that is multiplied by the sum of the dices of who landed in it.
 */
public class PublicService extends Property {
    public PublicService(String name, float cost, float rent, float rentMult) {
        super(name, cost, rent, rentMult);
    }

    @Override
    public float RentCost() {
        return getRent();
    }
}
