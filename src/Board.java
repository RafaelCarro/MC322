import Card.*;

import java.util.ArrayList;

/*
Board Class
Holds all information on the Board. Including properties and players.
 */
public class Board {
    private ArrayList<Player> Players;
    private ArrayList<Property> Properties;

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
        Players = new ArrayList<Player>();
        Properties = new ArrayList<Property>();

        //Board Setup
        //We set up all the Properties when we initiate the Board, so we don't need the user setting up everytime on main
        SpecialProperty Start = new SpecialProperty("Start", 0, 0, 0, "Start");
        Properties.add(Start);
        SpecialProperty LuckySpace1 = new SpecialProperty("LuckySpace1", 0, 0, 0, "LuckySpace");
        Properties.add(LuckySpace1);
        Land Paviartes = new Land("Paviartes", 60, 10, (float)1.2, "Red", 30, 60);
        Properties.add(Paviartes);
        Land FenF = new Land("Faculdade de Enfermagem", 60, 15, (float) 1.2, "Red", 30, 60);
        Properties.add(FenF);
        PublicService RU = new PublicService("Restaurante Universitário", 50, 1, (float)10.0);
        Properties.add(RU);
        Land FE = new Land("Faculdade de Educação",  70, 20, (float) 1.2, "Red", 35, 70);
        Properties.add(FE);
        SpecialProperty LuckySpace2 = new SpecialProperty("LuckySpace2", 0, 0, 0, "LuckySpace");
        Properties.add(LuckySpace2);
        Land IEL = new Land("Instituto de Estudos da Linguagem", 100, 30, (float)1.3, "Orange", 50, 90);
        Properties.add(IEL);
        Land IFCH = new Land("Instituto de Filosofia e Ciências Humanas", 100, 30, (float)1.3, "Orange", 50, 90);
        Properties.add(IFCH);
        Land IA = new Land("Instituto de Artes", 120, 50, (float)1.3, "Orange", 60, 100);
        Properties.add(IA);
        SpecialProperty Reitoria = new SpecialProperty("Reitoria", 0, 0, 0, "Reitoria");
        Properties.add(Reitoria);
        Land IB = new Land("Instituto de Biologia", 160, 70, (float)1.4, "Yellow", 80, 140);
        Properties.add(IB);
        Land IQ = new Land("Instituto de Química", 180, 80, (float)1.4, "Yellow", 90, 160);
        Properties.add(IQ);
        Station C1 = new Station("Circular 1", 150, 20, (float) 4.0);
        Properties.add(C1);
        SpecialProperty LuckySpace3 = new SpecialProperty("LuckySpace3", 0, 0, 0, "LuckySpace");
        Properties.add(LuckySpace3);
        Land IG = new Land("Instituto de Geociências", 180, 80, (float)1.4, "Yellow", 90, 160);
        Properties.add(IG);
        Land IE = new Land("Instituto de Econômia", 200, 100, (float)1.5, "Green", 110, 180);
        Properties.add(IE);
        SpecialProperty LuckySpace4 = new SpecialProperty("LuckySpace4", 0, 0, 0, "LuckySpace");
        Properties.add(LuckySpace4);
        Land FEF = new Land("Faculdade de Educação Física", 220, 120, (float)1.5, "Green", 120, 200);
        Properties.add(FEF);
        PublicService COTUCA = new PublicService("COTUCA", 100, 2, (float)10.0);
        Properties.add(COTUCA);
        SpecialProperty Feriado = new SpecialProperty("Feriado", 0, 0, 0, "Holiday");
        Properties.add(Feriado);
        Land FEAGRI = new Land("Faculdade de Engenharia Agrícola", 260, 150, (float)1.6, "Cyan", 140, 220);
        Properties.add(FEAGRI);
        SpecialProperty LuckySpace5 = new SpecialProperty("LuckySpace5", 0, 0, 0, "LuckySpace");
        Properties.add(LuckySpace5);
        Land FEA = new Land("Faculdade de Engenharia de Alimentos", 280, 160, (float)1.6, "Cyan", 150, 240);
        Properties.add(FEA);
        PublicService RA = new PublicService("Restaurante Administrativo", 150, 3, (float)10.0);
        Properties.add(RA);
        Station C2 = new Station("Circular 2", 150, 20, (float) 4.0);
        Properties.add(C2);
        Land FEQ = new Land("Faculdade de Engenharia Química", 300, 180, (float)1.7, "Blue", 160, 280);
        Properties.add(FEQ);
        Land FEC = new Land("Faculdade de Engenharia Civil", 300, 180, (float)1.7, "Blue", 160, 280);
        Properties.add(FEC);
        SpecialProperty LuckySpace6 = new SpecialProperty("LuckySpace6", 0, 0, 0, "LuckySpace");
        Properties.add(LuckySpace6);
        Land FEM = new Land("Faculdade de Engenharia Mecânica", 320, 200, (float)1.7, "Blue", 180, 300);
        Properties.add(FEM);
        SpecialProperty Jail = new SpecialProperty("Vá para a Reitoria", 0, 0, 0, "Jail");
        Properties.add(Jail);
        Land FCM = new Land("Faculdade de Ciências Médicas", 340, 220, (float)1.8, "Purple", 200, 330);
        Properties.add(FCM);
        PublicService RS = new PublicService("Restaurante Saturnino", 200, 4, (float)10.0);
        Properties.add(RS);
        Land FEEC = new Land("Faculdade de Engenharia Elétrica e de Computação", 360, 240, (float)1.8, "Purple", 220, 340);
        Properties.add(FEEC);
        SpecialProperty LuckySpace7 = new SpecialProperty("LuckySpace7", 0, 0, 0, "LuckySpace");
        Properties.add(LuckySpace7);
        Station CE = new Station("Circular Elétrico", 200, 40, (float) 4.0);
        Properties.add(CE);
        Land IFGW = new Land("Instituto de Física Gleb Wataghin", 380, 280, (float) 1.9, "Pink", 240, 360);
        Properties.add(IFGW);
        Land IMECC = new Land("Instituto de Matemática, Estatística e Computação Aplicada", 380, 280, (float) 1.9, "Pink", 240, 360);
        Properties.add(IMECC);
        SpecialProperty LuckySpace8 = new SpecialProperty("LuckySpace8", 0, 0, 0, "LuckySpace");
        Properties.add(LuckySpace8);
        Land IC = new Land("Instituto de Computação", 400, 300, (float) 1.9, "Pink", 250, 380);
        Properties.add(IC);
    }

    //Add and Remove Players
    public void addPlayer(Player Player) {
        Players.add(Player);
    }
    public void removePlayer(Player Player) {
        Players.remove(Player);
    }

    //Board Print
    public void BoardPrint() {
        for (int i = 0; i < this.getProperties().size(); i++) {
            System.out.printf("%d.  %s\n", i + 1, this.getProperties().get(i).printName());
        }
        System.out.println();
    }

}
