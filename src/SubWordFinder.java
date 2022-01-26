import java.util.*;
import java.io.*;

public class SubWordFinder {
    private ArrayList<ArrayList<String>> dictionary;
    private String alpha = "abcdefghijklmnopqrstuvwxyz";

    public SubWordFinder() {
        dictionary = new ArrayList<>();
        for (int i = 0; i < alpha.length(); i++){
            dictionary.add(new ArrayList<String>());
        }
        populateDictionary();
    }

    public void populateDictionary()    {
        try {
            Scanner in = new Scanner(new File("words_all_os.txt"));
            String alpha = "abcdefghijklmnopqrstuvwxyz";
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

    public void printDictionary()   {
        for(ArrayList<String> bucket : dictionary)  {
            System.out.println(bucket);
        }

    }

    public static void main(String[] args) {
        SubWordFinder app = new SubWordFinder();
        app.printDictionary();
    }
}
