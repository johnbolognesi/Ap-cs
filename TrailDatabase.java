import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Trail Database Imports data and sorts it.
 * @version 5/01/2022
 * @author John Bolognesi
 */

public class TrailDatabase {
    private ArrayList<Waypoint> database;
    private int searchTerm;
    private boolean asc;

    /**
     * Constructor for the class
     */
    public TrailDatabase(){
        database = new ArrayList<>();
        populateDatabase();
    }

    /**
     * Imports Data from text file.
     */
    public void populateDatabase()  {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("apptrailDB.txt"));
            while (sc.hasNext()) {
                String[] line = sc.nextLine().split("\t");
                database.add(new Waypoint(line[0], line[1], line[2], Double.parseDouble(line[5]), Double.parseDouble(line[6]), Integer.parseInt(line[7])));
            }
            sc.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Prompts the user for how to sort the data.
     */
    public void getSearchTerm(){
        System.out.println("+ Menu of search terms to use for sorting waypoints +\n" +
                "\tNA: by name\n" +
                "\tDS: by distance to Springer\n" +
                "\tDK: by distance to Katahdin\n" +
                "\tEL: by elevation");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your preferred sort by term or 'Q' to quit: ");
        String term = in.nextLine();
        if(term.equals("TY"))
            searchTerm = 1;
        else if(term.equals("NA"))
            searchTerm = 2;
        else if(term.equals("DS"))
            searchTerm = 4;
        else if(term.equals("DK"))
            searchTerm = 5;
        else if(term.equals("EL"))
            searchTerm = 6;
        else
            searchTerm = 0;
        System.out.println("Enter 'A' to sort in ascending order or 'D' to sort in descending order: ");
        term = in.nextLine();
        asc = (term.equals("A")) ? true : false;

    }

    /**
     * Prints the sorted database.
     */
    public void printDatabase() {
        for(Waypoint w : database)
            System.out.println(w);
    }

    /**
     * Sorts the Database
     */
    public void sortDB()    {
        WaypointComparator wc = new WaypointComparator(searchTerm, asc);
        Waypoint toSwap;
        int index;
        for(int out = 0; out < database.size(); out++)  {
            index = out;
            toSwap = database.get(out);
            for(int in = out+1; in < database.size(); in++) {
                Waypoint temp = database.get(in);

                if(wc.compare(temp, toSwap) < 0)    {
                    toSwap = new Waypoint(temp);
                    index = in;
                }
            }
            database.set(index, database.get(out));
            database.set(out, toSwap);
        }
    }

    /**
     * Main entry point
     * @param args
     */
    public static void main(String[] args) {
        TrailDatabase db = new TrailDatabase();
        System.out.println("*** Welcome to the Appalachian Trail Database ***");
        while(true) {
            db.getSearchTerm();
            if(db.searchTerm == 0)
                break;
            db.sortDB();
            db.printDatabase();
        }

    }

}
