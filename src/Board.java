import java.util.ArrayList;
import java.util.Properties;

/*
Board Class
Holds all information on the Board. Including properties and players.
 */
public class Board {
    private ArrayList<Player> Players = new ArrayList<Player>();
    private ArrayList<Property> Properties = new ArrayList<Property>();

    //Getters and Setters
    public ArrayList<Player> getPlayers() {
        return Players;
    }

    public void setPlayers(ArrayList<Player> players) {
        Players = players;
    }

    public ArrayList<Property> getProperties() {
        return Properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        Properties = properties;
    }

    //Constructor
    public Board() {
    }

    //Add and Remove Players
    public void addPlayer(Player Player) {
        Players.add(Player);
    }
    public void removePlayer(Player Player) {
        Players.remove(Player);
    }

    //Add and Remove Properties
    public void addProperty(Property Property) {
        Properties.add(Property);
    }
    public void removeProperty(Property Property) {
        Properties.remove(Property);
    }
}
