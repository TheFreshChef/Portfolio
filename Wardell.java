import java.util.*;
import java.io.*;

public class Wardell
{
    /**
     * Public HashMap of the playerinfos for every player
     */
    public HashMap<String, PlayerInfo> players = new HashMap<String, PlayerInfo>();
    private PlayerInfo                 answer;
    /**
     * Public String Arraylist of every player name
     */
    public ArrayList<String>                  names   = new ArrayList<>();
    private GUI gui;
    private StatDisplayer stats;
    private MainPage mainPage;

    /**
     * Constructor for Wardell Class
     * @throws FileNotFoundException Throws an error incase there file is not found
     * Fills players hashmap and creates all necessary GUI objects.
     */
    public Wardell()
        throws FileNotFoundException
    {
        File file = new File("Wardell-DataSet.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine())
        {
            String[] info = scanner.nextLine().split(",");
            PlayerInfo p = new PlayerInfo(
                info[0],
                info[1],
                info[2],
                info[3],
                Double.parseDouble(info[4]),
                Double.parseDouble(info[5]),
                Double.parseDouble(info[6]));
            players.put(info[0], p);
        }
        answer = getRandPlayer();
        System.out.println(answer);
        Boolean guessI = true;
        int count = 1;
        // System.out.println("debug");
        // gui = new GUI(this);
        // stats = new StatDisplayer(gui, this);
        mainPage = new MainPage(this);
        boolean gameOver = false;
        while (!gameOver)
        {
            if (!guessI || count > 6){
                gameOver = true;
            }
        }
        // if (count == 7) {
        // // gui.noMoreGuess();
        // System.out.println("idk");
        // }
        // if (guessI == false) {
        // gui.gameWon(count);
        // }

    }

    /**
     * Starts the game by creating GUI and StatDisplayer objects
     */
    public void startGame() {
        gui = new GUI(this);
        stats = new StatDisplayer(gui, this);
    }

    /**
     * Returns a random player
     * @return random player
     */
    private PlayerInfo getRandPlayer()
    {
        Object[] pKeys = players.keySet().toArray();
        Object key = pKeys[new Random().nextInt(pKeys.length)];
        return players.get(key);
    }

    /**
     * Returns the appropriate playerinfo based on name given 
     * @param input Name of player
     * @return Playerinfo based on input string
     */
    public PlayerInfo guess(String input) {
        return players.get(input);
    }

    /**
     * Runs a round of the game
     * @param validName valid guess inputed by player
     * @param c count
     * @return boolean based on if the player matches or not
     */
    public boolean runRound(String validName, int c)
    {
            PlayerInfo guess = players.get(validName);
            int count = c;
            // System.out.println(guess.name());
            if (guess.compareName(answer) == 1)
            {
                stats.displayWin();
                return true;
            }
            else
            {
                stats.countTracker(count);
                stats.displayStats(guess.compareTName(answer),
                guess.compareRegion(answer), guess.compareAgent(answer),
                guess.compareACS(answer), guess.compareKD(answer),
                guess.compareADR(answer));
                return false;
            }
    }

    /**
     * Creates a Wardell object;
     * @param args arguments
     * @throws FileNotFoundException In case there is no file(data set)
     */
    public static void main(String[] args)
        throws FileNotFoundException
    {
        new Wardell();
    }

}
