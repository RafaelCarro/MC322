import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Setting Board
        Board Board = new Board();
        Board.BoardPrint();

        //Set up of Players and Piece on the Board
        Rules.setup(Board);

        //Rounds
        int i = 1;
        while (true) {
            Rules.round(Board, i);
            i++;
        }
    }
}