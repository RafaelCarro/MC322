package Card;

/*
Property.Station Class
Subclass of Property.Property.
Is a type of property that has a fixed rent value that can be increased by having other Property.Station properties.
 */
public class Station extends Property{
    public Station(String name, float cost, float rent, float rentMult) {
        super(name, cost, rent, rentMult);
    }

    @Override
    public float RentCost() {
        return this.getRent();
    }

    @Override
    public String printName() {
        return this.getName();
    }

    @Override
    public String toString() {
        return this.getName() + '\n' +
                "Circular" + " (" + (this.getProprietary() == -1 ? "Sem Dono" : "Dono:" + this.getProprietary()) + ")\n" +
                "Preço: " + this.getCost() + "$\n" +
                "Aluguel: " + this.getRent() + "$\n" +
                "Multiplicador: " + this.getRentMult() + '\n';
    }
}
