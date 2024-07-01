import Card.*;

import java.util.ArrayList;
import java.util.Objects;

/*
Player Class
Contains all information pertaining to the player and methods for possible actions.
 */
public class Player {
    private String name;
    private final int ID;
    private Piece Piece;
    private String CPF;
    private String email;
    private float money;
    private String photo;
    private ArrayList<LuckyCard> Cards;
    private ArrayList<Property> Properties;

    //Number of Players
    static int NumberOfPlayers = 0;

    //Constructor
    public Player(String name, Piece Piece, String CPF, String email, String photo) {
        this.name = name;
        NumberOfPlayers++;
        this.ID = NumberOfPlayers;
        this.Piece = Piece;
        this.CPF = CPF;
        this.email = email;
        this.money = 1000;
        this.photo = photo;
        this.Cards = new ArrayList<LuckyCard>();
        this.Properties = new ArrayList<Property>();
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public Piece getPiece() {
        return Piece;
    }

    public void setPiece(Piece piece) {
        Piece = piece;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getMoney() {
        return money;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public ArrayList<LuckyCard> getCards() {
        return Cards;
    }

    public void setCards(ArrayList<LuckyCard> cards) {
        Cards = cards;
    }

    public ArrayList<Property> getProperties() {
        return Properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        Properties = properties;
    }

    @Override
    public String toString() {
        return "Player " +
                 name + '\n' +
                "ID: " + ID + '\n' +
                "CPF: " + CPF + '\n' +
                "Email: " + email + '\n' +
                "Money: " + money + '\n' +
                "Photo: " + photo + "\n\n";
    }

    //Modify Money value
    public void changeMoney(float value) {
        this.money += value;
        System.out.printf("Seu novo saldo é %.2f\n\n", this.money);
    }

    //ACTIONS

    /**
     * Buy property P on the board.
     * @param P Property.Property P to be bought.
     */
    public void buyProperty(Property P) {
        if (this.getMoney() >= P.getCost()) {
            P.setProprietary(this.getID());
            this.getProperties().add(P);
            System.out.printf("%s comprou o %s!\n", this.getName(), P.getName());
            this.changeMoney(-P.getCost());
        }
        else {
            System.out.printf("%s não possui dinheiro para comprar o %s.\n\n", this.getName(), P.getName());
        }
    }

    /**
     * Buy a given number of Houses in P property
     * @param P Property.Property in which are to be built houses.
     * @param NumberOfHouses Number of Houses to build.
     */
    public void buyHouses(Land P, int NumberOfHouses) {
        float cost = NumberOfHouses * P.getCostOfHouses();
        if (P.getProprietary() != this.getID()) {
            System.out.printf("%s não é dono do %s!\n\n", this.getName(), P.getName());
            return;
        }
        if (this.getMoney() < cost) {
            System.out.printf("%s não possui dinheiro para comprar %d casas no %s.\n\n", this.getName(), NumberOfHouses,
                             P.getName());
        }
        else {
            if (P.add_Houses(NumberOfHouses) == 0) {
                System.out.printf("%s não pode construir mais casas no %s.\n\n", this.getName(), P.getName());
            }
            else {
                System.out.printf("%s construiu %d casas no %s.\n", this.getName(), NumberOfHouses, P.getName());
                this.changeMoney(-cost);
            }
        }
    }

    /**
     * Buys a hotel in property P
     * @param P Property.Property in which are to be built a hotel.
     */
    public void buyHotel(Land P) {
        if (P.getProprietary() != this.getID()) {
            System.out.printf("%s não é dono do %s!\n\n", this.getName(), P.getName());
            return;
        }
        if (this.getMoney() < P.getCostOfHotel()) {
            System.out.printf("%s não possui dinheiro para comprar um hotel no %s.\n\n", this.getName(), P.getName());
        }
        else {
            if (!P.addHotel()) {
                System.out.printf("%s não pode construir um hotel no %s.\n\n", this.getName(), P.getName());
            }
            else {
                System.out.printf("%s construiu um hotel no %s.\n", this.getName(), P.getName());
                this.changeMoney(-P.getCostOfHotel());
            }
        }
    }

    /**
     * Add a Card to the LuckyCard Arraylist.
     * @param C: Card to add
     */
    public void AddLuckyCard(LuckyCard C) {
        this.getCards().add(C);
    }

    /**
     * Prints onto the console the cards the player currently has.
     */
    public void SeeCards () {
        int s = this.getCards().size();
        if (s > 0) {
            System.out.print("Suas Cartas:\n");
            for (int i = 0; i < s; i++) {
                System.out.printf("%d. %s\n", i + 1, this.getCards().get(i).getName());
            }
        }
        else
            System.out.print("Você não tem cartas\n");
    }

    /**
     * Uses the card if possible
     * @param card: the index number of the card on the ArrayList of LuckyCards.
     */
    public void TakeAction(int card) {
        LuckyCard C = this.getCards().get(card-1);
        this.getPiece().changePos(C.getMove());
        this.changeMoney(C.getValue());
        if (Objects.equals(C.getAction(), "JAIL"))
            this.getPiece().setPos(10);
        else if (Objects.equals(C.getAction(), "FREE") && this.getPiece().getPos() == 10) {
            this.getPiece().setPos(20);
        }
        this.getCards().remove(card-1);
    }
}
