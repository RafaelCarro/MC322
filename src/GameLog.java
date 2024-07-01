import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public interface GameLog {
    public final String FileName = "GameLog.txt";

    public final PrintStream Orig = System.out;
    public static void Logf(String s) throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream(GameLog.FileName, true));
        System.out.printf(s);
        System.setOut(out);
        System.out.printf(s);
        System.setOut(Orig);
    }

    public static void StartLog(Board B) throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream(GameLog.FileName));
        System.out.print("JOGADORES:\n");
        System.setOut(out);
        for (int i = 0; i < B.getPlayers().size(); i++)
            System.out.printf(B.getPlayers().toString());
        System.setOut(Orig);
    }
}
