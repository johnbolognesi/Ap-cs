import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Scrabble Scorer scores a word using the scrabble scoring system.
 * @author John Bolognesi
 * @version 2/21/22
 */

public class ScrabbleScorer {
    private ArrayList<String> dictionary;
    private int[] points = {1, 3, 3, 2 ,1, 4, 2 ,4, 1, 8, 5, 1, 3, 1, 1,3,10,1,1,1,1,4,4,8,4,10};
    private String alpha;

    public ScrabbleScorer() {
        dictionary = new ArrayList<>();
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        buildDictionary();
    }

    /**
     * Builds dictionary of words.
     */
    public void buildDictionary() {
            Scanner sc = null;
            try {
                sc = new Scanner(new File("SCRABBLE_WORDS.txt"));
                while (sc.hasNext()) {
                    dictionary.add(sc.next());
                }
                sc.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Collections.sort(dictionary);
        }

    /**
     * Checks to see if the word is in the dictionary.
     * @param word
     * @return
     */
    public boolean isValidWord(String word) {
            return Collections.binarySearch(dictionary, word) >= 0;
        }

    /**
     * Gets the score of the word going charcter by charcter.
     * @param word
     * @return
     */
    public int getWordScore(String word) {
            int sum = 0;
            for (int i = 0; i < word.length(); i++)
                sum += points[alpha.indexOf(word.charAt(i))];
            return sum;

        }

    /**
     * Main entry point for scrabble scorer.
     * @param args
     */
    public static void main(String[] args) {
            ScrabbleScorer app = new ScrabbleScorer();
            System.out.println("*Welcome*");
            String userWord;
            try {
                Scanner userIn = new Scanner(System.in);
                while (true) {
                    System.out.print("Enter a word to score or 0 to quit: ");
                    userWord = userIn.nextLine();
                    if (userWord.equals("0"))
                        break;
                    else if (app.isValidWord(userWord.toUpperCase())) {
                        int pointScore = app.getWordScore(userWord.toUpperCase());
                        System.out.println(userWord + " = " +pointScore + " points");
                    }
                    else {
                        System.out.println(userWord + " is not a valid word in the dictionary.");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }


