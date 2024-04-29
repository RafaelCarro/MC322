package Card;

/*
Public Service Class
Subclass of Property.Property.
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

    @Override
    public String printName() {
        return "\033[38;5;27m" + this.getName() + "\u001B[0m";
    }

    @Override
    public String toString() {
        return "\033[38;5;27m" + this.getName() + '\n' +
                "Circular" + " (" + (this.getProprietary() == -1 ? "Sem Dono" : "Dono: Plyaer" + this.getProprietary()) + ")\n" +
                "Preço: " + this.getCost() + "$\n" +
                "Aluguel: " + this.getRent() + "$\n" +
                "Multiplicador: " + this.getRentMult() + '\n'
                + "\u001B[0m";
    }
}
