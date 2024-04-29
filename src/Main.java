public class Main {
    public static void main(String[] args){
        //Setting Board
        Board Board = new Board();
        Board.BoardPrint();

        //Set up of Players and Piece on the Board
        Rules.setup(Board);

        //Rounds
        while (true) {
            Rules.round(Board);
        }
    }
}