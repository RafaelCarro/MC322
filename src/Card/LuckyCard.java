package Card;

/*
Property.LuckyCard Class
Defines Lucky Cards, which are special cards obtained by landing a Lucky Property.Card property on the board.
Can have either a beneficial or harmful effect to the Player.
 */
public class LuckyCard extends Card{
    private int ID;
    private int move;
    private float value;
    private String action;

    enum CardType {
        MOVE_3 (3,0,"Nothing", "Move 3 spaces."),
        GO_BACK_3 (-3,0,"Nothing", "Go back 3 spaces.."),
        GAIN_200 (0,200,"Nothing", "Gain 200$."),
        LOSE_200 (0,-200,"Nothing", "Lose 200$."),
        FREE (0,0,"FREE", "Get out of jail for free."),
        JAIL (0,0,"JAIL", "Go to Jail.");
        private final int move;
        private final float value;
        private final String effect;
        private final String action;

        CardType(int move, float value, String effect, String action) {
            this.move = move;
            this.value = value;
            this.effect = effect;
            this.action = action;
        }

        public int getMove() {
            return move;
        }

        public float getValue() {
            return value;
        }

        public String getEffect() {
            return effect;
        }

        public String getAction() {
            return action;
        }
    }

    //Constructor
    public LuckyCard(int ID, int roll) {
        super("");
        CardType C = null;
        if (roll % 6 == 1) {
            C = CardType.MOVE_3;
        }
        else if (roll % 6 == 2) {
            C = CardType.GO_BACK_3;
        }
        else if (roll % 6 == 3) {
            C = CardType.GAIN_200;
        }
        else if (roll % 6 == 4) {
            C = CardType.LOSE_200;
        }
        else if (roll % 6 == 5) {
            C = CardType.FREE;
        }
        else if (roll % 6 == 0) {
            C = CardType.JAIL;
        }
        assert C != null;
        this.setName(C.getAction());
        this.move = C.getMove();
        this.value = C.getValue();
        this.action = C.getEffect();
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

    @Override
    public String printName() {
        return getName();
    }
}
