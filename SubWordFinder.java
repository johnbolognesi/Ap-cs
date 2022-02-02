/**
 * SubWordFinder parses sub words from a root word.
 * @author John Bolognesi
 * @version 02/1/22
 */

import java.util.*;
import java.io.*;

public class SubWordFinder implements WordFinder {
    private ArrayList<ArrayList<String>> dictionary;
    private String alpha = "abcdefghijklmnopqrstuvwxyz";

    public SubWordFinder() {
        dictionary = new ArrayList<>();
        for (int i = 0; i < alpha.length(); i++){
            dictionary.add(new ArrayList<String>());
        }
        populateDictionary();
    }

    /**
     * populateDictionary creates a dictionary full of words.
     */
    public void populateDictionary()    {
        try {
            Scanner in = new Scanner(new File("words_all_os.txt"));
            while(in.hasNext()) {
                String word = in.nextLine();
                dictionary.get(alpha.indexOf(word.charAt(0))).add(word);
            }
            in.close();
        }
        catch(Exception e)  {
            e.printStackTrace();
        }
    }

    /**
     * indexOf is a user defined Binary Search Method.
     * @param bucket
     * @param word
     * @return
     */
    private int indexOf(ArrayList<String> bucket, String word)  {
        int low = 0, high = bucket.size()-1;
        while(low <= high)  {
            int mid = (low+high)/2;
            if(bucket.get(mid).compareTo(word) == 0)
                return mid;
            else if(bucket.get(mid).compareTo(word) < 0)
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }

    /**
     * inDictionary returns true if a word is in the dictionary and false if not.
     * @param word The item to be searched for in dictionary
     * @return
     */
    public boolean inDictionary(String word)    {
        int index = alpha.indexOf(word.charAt(0));
        ArrayList<String> bucket = dictionary.get(index);
        return indexOf(bucket, word) >= 0;
    }

    /**
     * getSubWords reads through the dictionary and parses the subwords out of the words.
     * @return
     */
    public ArrayList<SubWord> getSubWords()    {
        ArrayList<SubWord> subWords = new ArrayList<>();
        for(ArrayList<String> bucket : dictionary){
            for(String word : bucket){
                for(int i = 2; i < word.length() - 2; i++ ){
                    String sub1 = word.substring(0, i);
                    String sub2 = word.substring(i);
                    if(inDictionary(sub1) && inDictionary(sub2))
                        subWords.add(new SubWord(word, sub1, sub2));
                }
            }
        for(int i = 0; i < subWords.size(); i++)    {
            System.out.println(subWords.get(i));
        }
        }
        return subWords;
    }
/**
    public void printDictionary()   {
        for(ArrayList<String> bucket : dictionary)  {
            System.out.println(bucket);
        }

    }*/
    public static void main(String[] args) {
        SubWordFinder app = new SubWordFinder();
        app.getSubWords();
    }
}
