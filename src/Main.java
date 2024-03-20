public class Main {
    public static void main(String[] args){
        Player P1 = new Player("Jorge", "529.982.247-25", "jorjindamassa@yahoo.com", "./Photos/Jorge");
        Player P2 = new Player("Ainaras", "242.12.88", "ainarin@hotmail.com.lt", "./Photos/Marao");
        Piece Red_Piece = new Piece("Red", 0);
        Piece White_Piece = new Piece("White", 0);
        LuckyCard Move_3 = new LuckyCard(1, "Move 3 Spaces", 3, 1, 0, "", 0, "");
        LuckyCard Go_Back_3 = new LuckyCard(2, "Move back 3 Spaces", -3, -1, 0, "", 0, "");
        LuckyCard Jail = new LuckyCard(3, "Jail Card", 0, -1, 0, "Go to Jail", 0, "");
        System.out.println(STR."\{P1.getName()}:\n\{Red_Piece.getColor()} Pieces\nEmail: \{P1.getEmail()}\nCPF: \{P1.getCPF()}\nPhoto: \{P1.getPhoto()}\n");
        System.out.println(STR."\{P2.getName()}:\n\{White_Piece.getColor()} Pieces\nEmail: \{P2.getEmail()}\nCPF: \{P2.getCPF()}\nPhoto: \{P2.getPhoto()}\n");
        System.out.println(STR."CARDS ON STACK:\n\{Move_3.getName()}\n\{Go_Back_3.getName()}\n\{Jail.getName()}");
    }

}