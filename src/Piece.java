/*
Piece Class
Holds information about a player piece.
 */
public class Piece {
    private String color;
    private int pos;

    //Constructor
    public Piece(String color) {
        this.color = color;
        this.pos = 0;
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

    /**
     * Move the Piece the given number.
     * @param move How much to move the Piece on the board.
     */
    public void changePos(int move) {
        this.pos += move;
        this.pos = this.pos % 40;
    }
}
