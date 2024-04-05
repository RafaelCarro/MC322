public class Main {
    public static void main(String[] args){
        //Setting Board
        Board Board = new Board();
        //Players and Pieces
        Player P1 = new Player("Jorge", "529.982.247-25", "jorjindamassa@yahoo.com", "./Photos/Jorge");
        Board.addPlayer(P1);
        Player P2 = new Player("Ainaras", "242.12.88", "ainarin@hotmail.com.lt", "./Photos/Marao");
        Board.addPlayer(P2);
        Piece Red_Piece = new Piece("Red", 0);
        Piece White_Piece = new Piece("White", 0);
        //Adding Lucky Cards
        LuckyCard Move_3 = new LuckyCard(1, "Move 3 Spaces", 3, 1, 0, "", 0, "");
        LuckyCard Go_Back_3 = new LuckyCard(2, "Move back 3 Spaces", -3, -1, 0, "", 0, "");
        LuckyCard Jail = new LuckyCard(3, "Jail Card", 0, -1, 0, "Go to Jail", 0, "");
        //Print Out Test
        System.out.println(P1.toString());
        System.out.println(P2.toString());
        System.out.println(STR."CARDS ON STACK:\n\{Move_3.getName()}\n\{Go_Back_3.getName()}\n\{Jail.getName()}\n");
        //Properties
        //Red Lands
        Land Paviartes = new Land("Paviartes", 60, 10, (float)1.2, "Red", 30, 60);
        Board.addProperty(Paviartes);
        Land FenF = new Land("Faculdade de Enfermagem", 60, 15, (float) 1.2, "Red", 30, 60);
        Board.addProperty(FenF);
        Land FE = new Land("Faculdade de Educação",  70, 20, (float) 1.2, "Red", 35, 70);
        Board.addProperty(FE);
        //Orange Lands
        Land IEL = new Land("Instituto de Estudos da Linguagem", 100, 30, (float)1.3, "Orange", 50, 90);
        Board.addProperty(IEL);
        Land IFCH = new Land("Instituto de Filosofia e Ciências Humanas", 100, 30, (float)1.3, "Orange", 50, 90);
        Board.addProperty(IFCH);
        Land IA = new Land("Instituto de Artes", 120, 50, (float)1.3, "Orange", 60, 100);
        Board.addProperty(IA);
        //Yellow Lands
        Land IB = new Land("Instituto de Biologia", 160, 70, (float)1.4, "Yellow", 80, 140);
        Board.addProperty(IB);
        Land IQ = new Land("Instituto de Química", 180, 80, (float)1.4, "Yellow", 90, 160);
        Board.addProperty(IQ);
        Land IG = new Land("Instituto de Geociências", 180, 80, (float)1.4, "Yellow", 90, 160);
        Board.addProperty(IG);
        //Green Lands
        Land IE = new Land("Instituto de Econômia", 200, 100, (float)1.5, "Green", 110, 180);
        Board.addProperty(IE);
        Land FEF = new Land("Faculdade de Educação Física", 220, 120, (float)1.5, "Green", 120, 200);
        Board.addProperty(FEF);
        //Cyan Lands
        Land FEAGRI = new Land("Faculdade de Engenharia Agrícola", 260, 150, (float)1.6, "Cyan", 140, 220);
        Board.addProperty(FEAGRI);
        Land FEA = new Land("Faculdade de Engenharia de Alimentos", 280, 160, (float)1.6, "Cyan", 150, 240);
        Board.addProperty(FEA);
        //Blue Lands
        Land FEQ = new Land("Faculdade de Engenharia Química", 300, 180, (float)1.7, "Blue", 160, 280);
        Board.addProperty(FEQ);
        Land FEC = new Land("Faculdade de Engenharia Civil", 300, 180, (float)1.7, "Blue", 160, 280);
        Board.addProperty(FEC);
        Land FEM = new Land("Faculdade de Engenharia Mecânica", 320, 200, (float)1.7, "Blue", 180, 300);
        Board.addProperty(FEM);
        //Purple Lands
        Land FCM = new Land("Faculdade de Ciências Médicas", 340, 220, (float)1.8, "Purple", 200, 330);
        Board.addProperty(FCM);
        Land FEEC = new Land("Faculdade de Engenharia Elétrica e de Computação", 360, 240, (float)1.8, "Purple", 220, 340);
        Board.addProperty(FEEC);
        //Pink Lands
        Land IFGW = new Land("Instituto de Física Gleb Wataghin", 380, 280, (float) 1.9, "Pink", 240, 360);
        Board.addProperty(IFGW);
        Land IMECC = new Land("Instituto de Matemática, Estatística e Computação Aplicada", 380, 280, (float) 1.9, "Pink", 240, 360);
        Board.addProperty(IMECC);
        Land IC = new Land("Instituto de Computação", 400, 300, (float) 1.9, "Pink", 250, 380);
        Board.addProperty(IC);
        //Public Services
        PublicService RU = new PublicService("Restaurante Universitário", 50, 1, (float)10.0);
        Board.addProperty(RU);
        PublicService COTUCA = new PublicService("COTUCA", 100, 2, (float)10.0);
        Board.addProperty(COTUCA);
        PublicService RA = new PublicService("Restaurante Administrativo", 150, 3, (float)10.0);
        Board.addProperty(RA);
        PublicService RS = new PublicService("Restaurante Saturnino", 200, 4, (float)10.0);
        Board.addProperty(RS);
        //Station Properties
        Station C1 = new Station("Circular 1", 150, 20, (float) 4.0);
        Board.addProperty(C1);
        Station C2 = new Station("Circular 2", 150, 20, (float) 4.0);
        Board.addProperty(C2);
        Station CE = new Station("Circular Elétrico", 200, 40, (float) 4.0);
        Board.addProperty(CE);

        //Actions
        P1.buyProperty(IC);
        P1.buyHouses(IA, 3);
        P1.buyHouses(IC, 3);
        P1.buyHouses(IC, 2);
        P1.buyProperty(IMECC);
        P2.buyProperty(IA);
        P2.buyHouses(IA, 4);
        P2.buyHouses(IA, 3);
        P2.buyHotel(IA);
        P2.buyHotel(IA);
    }
}