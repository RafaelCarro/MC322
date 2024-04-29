package Card;

import java.util.Objects;

public class SpecialProperty  extends Property{
    String Type;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public SpecialProperty(String name, float cost, float rent, float rentMult, String Type) {
        super(name, cost, rent, rentMult);
        this.Type = Type;
    }
    void SpecialAction() {
        if (Objects.equals(getType(), "Start")) {
            ;
        }
        else if (Objects.equals(getType(), "LuckySpace")) {
            ;
        }
        else if (Objects.equals(getType(), "Jail")) {
            ;
        }
    }

    @Override
    public String printName() {
        if (Objects.equals(this.getType(), "LuckySpace"))
            return "\033[48;5;7m" + this.getName() + "\u001B[0m";
        else
            return "\033[48;5;9m" + this.getName() + "\u001B[0m";
    }

    @Override
    public String toString() {
        if (Objects.equals(this.getType(), "LuckySpace")) {
            return "\u001B[43m" + this.getName() + '\n' +
                    "Circular" + '\n' +
                    "Preço: " + this.getCost() + "$\n" +
                    "Aluguel: " + this.getRent() + "$\n"
                    + "\u001B[0m";
        }
        else {
            return "\u001B[41m" + this.getName() + '\n' +
                    "Circular" + '\n' +
                    "Preço: " + this.getCost() + "$\n" +
                    "Aluguel: " + this.getRent() + "$\n"
                    + "\u001B[0m";
        }
    }
}
