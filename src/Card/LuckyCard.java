package Card;

/*
Property.LuckyCard Class
Defines Lucky Cards, which are special cards obtained by landing a Lucky Property.Card property on the board.
Can have either a beneficial or harmful effect to the Player.
 */
public class LuckyCard extends Card{
    private int ID;
    private int move;
    private int effect;
    private float value;
    private String action;
    private int time;
    private String restriction;

    //Constructor
    public LuckyCard(int ID, String name, int move, int effect, float value, String action, int time, String restriction) {
        super(name);
        this.ID = ID;
        this.move = move;
        this.effect = effect;
        this.value = value;
        this.action = action;
        this.time = time;
        this.restriction = restriction;
    }


    //Getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public int getEffect() {
        return effect;
    }

    public void setEffect(int effect) {
        this.effect = effect;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getRestriction() {
        return restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }

    @Override
    public String printName() {
        return getName();
    }
}
