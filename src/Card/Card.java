package Card;

public abstract class Card {
    private String name;
    private int Proprietary;

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

    public Card(String name) {
        this.name = name;
        this.Proprietary = -1;
    }

    public abstract String printName();
}
