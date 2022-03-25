import java.io.File;
import java.util.*;
/**
 * ScrabbleRackManager shows you what words you can play with a random rack of characters.
 * @author John Bolognesi
 * @version 3/25/22
 */

public class ScrabbleRackManager {
    private ArrayList<ArrayList<String>> dictionary;
    private ArrayList<String> tileRack;
    private String alpha;



    /** class constructor */
    public ScrabbleRackManager(){
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        dictionary = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < 26; i++)
            dictionary.add(new ArrayList<String>());
        Scanner sc = null;
        try {
            sc = new Scanner(new File("2019_collins_scrabble.txt"));
            while (sc.hasNext()) {
                String temp = sc.nextLine();
                dictionary.get(alpha.indexOf(temp.charAt(0))).add(temp);
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        buildRack();
    }

    /**
     * Builds the rack with a specified frequency of letters.
     */
    private void buildRack() {
        ArrayList<String> letters = new ArrayList<String>();
        String[] tiles = {"A","A","A","A","A","A","A","A","A","B","B","C","C","D","D","D","D","E","E","E","E","E","E","E","E","E","E","E","E","F","F","G","G","G","H","H","I","I","I","I","I","I","I","I","I","J","K","L","L","L","L","M","M","N","N","N","N","N","N","O","O","O","O","O","O","O","P","P","Q","R","R","R","R","R","R","S","S","S","S","T","T","T","T","T","T","U","U","U","U","V","V","W","W","X","Y","Y","Z"};
        for(String item : tiles)
            letters.add(item);
        Collections.shuffle(letters);
        tileRack = new ArrayList<String>();
        for(int i = 0; i < 7; i++)
            tileRack.add(letters.remove((int)(Math.random()*letters.size())));
    }

    /**
     * displays the contents of the player's tile rack
     */
    public void printRack(){
        System.out.println("Letters in the Rack: " + tileRack);
    }

    /**
     * builds and returns an ArrayList of String objects that are values pulled
     * from the dictionary/database based on the available letters in the user's tile rack
     * @return
     */
    public ArrayList<String> getPlaylist(){
        ArrayList<String> plays = new ArrayList<>();
        for(ArrayList<String> bucket : dictionary)
            if(tileRack.contains("" + bucket.get(0).charAt(0)))
                for(int i = 0; i < bucket.size(); i++)
                    if(isPlayable(bucket.get(i)))
                        plays.add(bucket.get(i));
        return plays;
    }

    private boolean isPlayable(String word)  {
        ArrayList<String> rack2 = new ArrayList<String>(tileRack);
        for(int i = 0; i < word.length(); i++)
            if(!rack2.remove("" + word.charAt(i)))
                return false;
        return true;
    }

    /**
     * prints all of the playable words based on the letters in the tile rack
     */
    public void printMatches(){
        ArrayList<String> plays = getPlaylist();
        boolean bingo = false;
        System.out.println("You can play the following words from the letters in your rack: ");
        if(plays.size() == 0)
            System.out.println("Sorry, NO words can be played from those tiles. ");
        for(int i = 0; i < plays.size(); i++)   {
            String word = plays.get(i);
            if(word.length() == 7)  {
                word += "*";
                bingo = true;
            }
            System.out.printf(String.format("%-10s", word));
            if((i+1) % 10 == 0)
                System.out.println();
        }
        if(bingo)
            System.out.println("\n * Denotes BINGO");

    }

    /**
     * Main entry point for ScrabbleRackManager
     * @param args
     */
    public static void main(String[] args) {
        ScrabbleRackManager app = new ScrabbleRackManager();
        app.printRack();
        app.printMatches();
    }
}
