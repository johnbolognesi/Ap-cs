/***
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScrabbleScorer {

    public class ScrabbleScorer {
        private ArrayList<String> dictionary;
        private int[] points = {1, 3, 3, 2};
        private String alpha;

        public ScrabbleScorer() {
            dictionary = new ArrayList<>();
            alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            buildDictionary();
    }

    public void buildDictionary()   {
        Scanner s = new Scanner(new File("SCRABBLE_WORDS.txt"));
        Scanner sc = null;
        try {
            while(sc.hasNextLine()) {
                dictionary.add(sc.nextLine());
            }
            sc.close();
            Collections.sort(dictionary);
        }
        catch(Exception e)  {
            e.printStackTrace();
        }
    }


    public boolean isValidWord(String word) {
        return Collections.binarySearch(dictionary, word) >= 0;
    }

    public int getWordScore(String word)    {

    }


    public static void main(String[] args)  {
        ScrabbleScorer app = new ScrabbleScorer();
        System.out.println("*Welcome");
        String userWord;
        Scanner userIn = new Scanner(System.in);
        try{
            while(true) {
                System.out.println("Enter a word to score or 0 to quit: ");
                userWord = userIn.nextLine();
                if(userWord.equals("0"))
                    break;
                else    {
                    // Do The Program
                    if(app.isValidWord(userWord))   {

                    }
                    else    {
                        System.out.println(userWord + " is not a valid word in the dictionary.");
                    }
                }
            }
        }
        catch(Exception e)  {
            e.printStackTrace();
    }
}
***/