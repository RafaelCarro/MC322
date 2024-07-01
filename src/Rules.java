import Card.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

/*
Rules Class
Method Library that contains all methods for game rules and verifications.
 */
public class Rules implements GameLog {

    /**
     * Function that set up all the players to a new Board. It gets how many players are going to play and asks for all
     * the necessary information from the players (Name, Piece of choice, CPF, email and photo), than creates the
     * Players on the Board for the game.
     * @param Board Board to set up.
     */
    public static void setup(Board Board) throws FileNotFoundException {
        Scanner Input = new Scanner(System.in);
        //PLAYERS
        int players;
        System.out.print("\n===BANCO UNIVERSITÁRIO===\n\n");
        System.out.print("Insira o número de Jogadores:");
        while (true){
            try {
                players = Input.nextInt();
                while (players > 8) {
                    System.out.print("O número máximo de jogadores é 8.\n");
                    System.out.print("Insira o número de Jogadores:");
                    players = Input.nextInt();
                }
                break;
            } catch (Exception InputMismatchException) {
                Input.next();
                System.out.print("Não foi inserido um número.\n");
                System.out.print("Insira o número de Jogadores:");
            }
        }
        System.out.println();
        Input.nextLine();
        for (int i = 0; i < players;i++){
            String name, CPF, email, photo, color;
            Piece Piece;
            System.out.printf("Jogador %d, insira suas informações.\n", i+1);
            //NOME
            System.out.print("Insira seu nome:");
            while(true) {
                try {
                    name = Input.nextLine();
                    break;
                } catch (Exception e) {
                    Input.next();
                    System.out.print("Expressão Inválida.\n");
                    System.out.print("Insira seu nome:");
                }
            }
            //PIECE
            System.out.print("Escolha uma cor de Peça:");
            while(true) {
                try {
                    color = Input.nextLine();
                    Piece = new Piece(color);
                    break;
                } catch (Exception e) {
                    Input.next();
                    System.out.print("Expressão Inválida.\n");
                    System.out.print("Escolha uma cor de Peça:");
                }
            }
            //CPF
            System.out.print("Insira seu CPF:");
            while(true) {
                try {
                    CPF = Input.nextLine();
                    while (!CPF_verify(CPF)) {
                        System.out.print("CPF Inválido.\n");
                        System.out.print("Insira seu CPF:");
                        CPF = Input.nextLine();
                    }
                    break;
                } catch (Exception e) {
                    Input.next();
                    System.out.print("CPF Inválido.\n");
                    System.out.print("Insira seu CPF:");
                }
            }
            //Email
            System.out.print("Insira seu Email:");
            while(true) {
                try {
                    email = Input.nextLine();
                    while (!verify_email(email)) {
                        System.out.print("Email Inválida.\n");
                        System.out.print("Insira seu Email:");
                        email = Input.nextLine();
                    }
                    break;
                } catch (Exception e) {
                    Input.next();
                    System.out.print("Email Inválido.\n");
                    System.out.print("Insira seu Email:");
                }
            }
            //Photo
            System.out.print("Insira sua foto:");
            while(true) {
                try {
                    photo = Input.nextLine();
                    break;
                } catch (Exception e) {
                    Input.next();
                    System.out.print("Expressão Inválida.\n");
                    System.out.print("Insira sua foto:");
                }
            }
            System.out.println();
            //Add Player to the Board
            Player Player = new Player(name, Piece, CPF, email, photo);
            Board.addPlayer(Player);
        }
        for (int i = 0; i < players;i++) {
            System.out.println(Board.getPlayers().get(i).toString());
        }
        GameLog.StartLog(Board);
    }

    /**
     *
     * @param Board Board to play the game.
     */
    public static void round(Board Board, int r) throws FileNotFoundException {
        GameLog.Logf(String.format("Rodada %d:\n\n", r));
        for (int i = 0; i < Board.getPlayers().size(); i++) {
            int action = 0;
            Scanner Input = new Scanner(System.in);
            Player Player = Board.getPlayers().get(i);
            //Player Info
            GameLog.Logf(String.format("Jogador %s\nEstá em no(a) %s\nSeu dinheiro atual é %.2f\n\n",
                    Player.getName(), Board.getProperties().get(Player.getPiece().getPos()).printName(), Player.getMoney()));
            //Actions Before Roll
            while (action != 1) {
                while (true){
                    GameLog.Logf("Ações Possíveis:\n1. Jogar os Dados.\n2. Checar suas Propriedades.\n" +
                            "3. Checar suas Cartas\n");
                    GameLog.Logf("Digite sua ação:");
                    try {
                        action = Input.nextInt();
                        while (action > 3) {
                            GameLog.Logf("Insira uma ação válida.\n");
                            GameLog.Logf("Insira sua ação:");
                            action = Input.nextInt();
                        }
                        //Roll Dice
                        if (action == 1) {
                            int dice = roll();
                            Player.getPiece().changePos(dice);
                            GameLog.Logf(String.format("Você tirou %d nos dados!\n", dice));
                            GameLog.Logf(String.format("Você parou no(a) %s!\n\n", Board.getProperties().get(Player.getPiece().getPos()).printName()));
                            break;
                        }
                        //See Player Properties
                        else if (action == 2) {
                            ArrayList<Property> Properties = Player.getProperties();
                            if (!Properties.isEmpty()) {
                                int j;
                                for (j = 0; j < Properties.size(); j++) {
                                    GameLog.Logf(String.format("%d. %s\n", j + 1, Properties.get(j).toString()));
                                }
                                //BUY HOUSES/HOTEL
                                GameLog.Logf(String.format("Deseja comprar casa ou hotel para alguma propriedade? (0 (Não) a %d)\n", Properties.size()));
                                int buy;
                                while (true){
                                    try {
                                        buy = Input.nextInt();
                                        while (buy > Properties.size() || buy < 0) {
                                            if (!(Properties.get(buy - 1).getClass() == Land.class)) {
                                                GameLog.Logf("Propriedade Inválida.\n");
                                                GameLog.Logf("Insira o número da Propriedade para comprar casas/hotel:");
                                                buy = Input.nextInt();
                                            }
                                        }
                                        if (buy == 0) break;
                                        int number_of_houses;
                                        while (true){
                                            GameLog.Logf("Quantas casas deseja comprar\n");
                                            try {
                                                number_of_houses = Input.nextInt();
                                                while (number_of_houses > 4 || number_of_houses < 1) {
                                                    GameLog.Logf("Quantidade Inválida.\n");
                                                    GameLog.Logf("Insira o número de casas para comprar:");
                                                    number_of_houses = Input.nextInt();
                                                }
                                                break;
                                            } catch (Exception InputMismatchException) {
                                                Input.next();
                                                GameLog.Logf("Não foi inserido um número de casas válido.\n");
                                                GameLog.Logf("Insira o número de casas para comprar:");
                                            }
                                        }
                                        GameLog.Logf("\n");
                                        Player.buyHouses(((Land) Properties.get(buy - 1)), number_of_houses);
                                        break;
                                    } catch (Exception InputMismatchException) {
                                        Input.next();
                                        GameLog.Logf("Não foi inserido um número de propriedade.\n");
                                        GameLog.Logf("Insira o número da Propriedade para comprar casas/hotel:");
                                    }
                                }
                            }
                            else { GameLog.Logf("Você não tem propriedades!\n\n"); }
                        }
                        //SEE AND USE CARDS IF POSSIBLE
                        else if (action == 3) {
                            Player.SeeCards();
                            GameLog.Logf(String.format("Escolha uma carta para usar( 0(Não) a %d):\n", Player.getCards().size()));
                            int card;
                            while (true){
                                try {
                                    card = Input.nextInt();
                                    while (card > Player.getCards().size() || card < 0) {
                                        GameLog.Logf("Carta Inválida.\n");
                                        GameLog.Logf("Insira o número da Carta:");
                                        card = Input.nextInt();
                                    }
                                    if (card == 0) break;
                                    Player.TakeAction(card);
                                    GameLog.Logf(String.format("Você parou no(a) %s!\n\n", Board.getProperties().get(Player.getPiece().getPos()).printName()));
                                    break;
                                } catch (Exception InputMismatchException) {
                                    Input.next();
                                    GameLog.Logf("Não foi inserido um número de carta.\n");
                                    GameLog.Logf("Insira o número da Carta para usar:");
                                }
                            }
                        }
                    } catch (Exception InputMismatchException) {
                        Input.next();
                        GameLog.Logf("Não foi inserido um número.\n");
                        GameLog.Logf("Insira sua ação:");
                    }
                }
            }
            Input.nextLine();
            //Actions after Roll
            //Check landed space
            Property pos = Board.getProperties().get(Player.getPiece().getPos());
            if (pos.getClass() == Land.class || pos.getClass() == PublicService.class || pos.getClass() == Station.class) {
                if (pos.getProprietary() == -1) {
                    GameLog.Logf(String.format("Você deseja comprar %s por %f? (Y/N)\n", pos.getName(), pos.getCost()));
                    String buy;
                    while (true){
                        try {
                            buy = Input.nextLine();
                            if (Objects.equals(buy, "Y")) {
                                Player.buyProperty(pos);
                            }
                            break;
                        } catch (Exception e) {
                            Input.next();
                            GameLog.Logf("Não foi inserido Y ou N.\n");
                            GameLog.Logf("Insira sua Y/N:");
                        }
                    }
                }
            }
            //Special landings
            else if (pos.getClass() == SpecialProperty.class) {
                //JAIL Space
                if (Objects.equals(((SpecialProperty) pos).getType(), "Jail")) {
                    Player.getPiece().setPos(11);
                }
                //Lucky Card Space
                else if (Objects.equals(((SpecialProperty) pos).getType(), "LuckySpace")) {
                    Player.AddLuckyCard(new LuckyCard(Player.getID(), roll()));
                }
            }
        }
    }

    /**
     * Rolls two random number generators to simulate the throwing of 2 dice.
     * @return Sum of two 6-sided dice.
     */
    public static int roll() {
        return ThreadLocalRandom.current().nextInt(1, 7) +
                ThreadLocalRandom.current().nextInt(1, 7);
    }

    /**
     * Verifies if player CPF is a valid one.
     * @return bool*/
    public static boolean CPF_verify(String Num_CPF) {
        Num_CPF = Num_CPF.replaceAll("\\D", "");
        //Checks if CPF is 11 numbers long
        if (Num_CPF.length() != 11) {
            return false;
        }
        //Checks if all digits are equal
        int equals = 1;
        for (int i = 1; i < 11; i++) {
            if (Num_CPF.charAt(i) == Num_CPF.charAt(0)) {
                equals++;
            }
        }
        if (equals == 11) {
            return false;
        }
        //Checks for verification digits validation
        int ver1 = 0, ver2 = 0;
        //First verification number:
        for (int i = 8; i >= 0; i--) {
            ver1 += (Num_CPF.charAt(i) - '0')*(10-i);
        }
        ver1 = ver1 % 11;
        if (ver1 < 2) {
            ver1 = 0;
        }
        else {
            ver1 = 11 - ver1;
        }
        //Second verification number:
        for (int i = 8; i >= 0; i--) {
            ver2 += (Num_CPF.charAt(i) - '0')*(11-i);
        }
        ver2 += ver1 * 2;
        ver2 = ver2 % 11;
        if (ver2 < 2) {
            ver2 = 0;
        }
        else {
            ver2 = 11 - ver2;
        }
        //verification
        return ver1 == Num_CPF.charAt(9) - '0' && ver2 == Num_CPF.charAt(10) - '0';
    }

    //Email validation code by https://www.baeldung.com/java-email-validation-regex
    /**
     * Regex pattern matching*/
    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
    /**
     * Checks if Player email is a valid one, accepts Unicode characters.
     * @param emailAddress Email address to check if it's valid.
     * @return boolean
     * */
    public static boolean verify_email(String emailAddress) {
        return Rules.patternMatches(emailAddress, "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@"
                + "[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$");
    }

}
