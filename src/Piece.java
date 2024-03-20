public class Piece {
    private String color;
    private int pos;

    //Constructor
    public Piece(String color, int pos) {
        this.color = color;
        this.pos = pos;
    }

    //Getters and Setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
