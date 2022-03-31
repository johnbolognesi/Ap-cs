import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class CoinSorterMachine{
    private ArrayList<Coin> coins = new ArrayList<Coin>();
    private int pennyCount = 0;
    private int nickelCount = 0;
    private int dimeCount = 0;
    private int quarterCount = 0;
    private int halfdollarCount = 0;
    private int dollarCount = 0;


    public CoinSorterMachine()  {

    }

    // use one or two Scanner objects, prompting user for the appropriate file
// name and importing the data from filename – MUST handle diabolic values!
    public void depositCoins()  {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the name of the data file for coin deposit: ");
        String file = input.nextLine();

        Scanner sc = null;
        try {
            sc = new Scanner(new File(file));
            while (sc.hasNext()) {
                int temp = sc.nextInt();
                if( temp == 1)
                    coins.add(new Penny());
                else if(temp == 5)
                    coins.add(new Nickel());
                else if(temp == 10)
                    coins.add(new Dime());
                else if(temp == 25)
                    coins.add(new Quarter());
                else if(temp == 50)
                    coins.add(new HalfDollar());
                else if(temp == 100)
                    coins.add(new Dollar());
                else
                    System.out.println("Coin value " + temp + " is not recognized.");

            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Prints deposit summary using a DecimalFormat object (see output section)
    public void printDepositSummary(){
        DecimalFormat df = new DecimalFormat("$0.00");
        System.out.println("Summary of Deposit: ");
        for(Coin value : coins)    {
            if(value.getName().equals("penny"))
                pennyCount = pennyCount + 1;
            if(value.getName().equals("nickel"))
                nickelCount = nickelCount + 1;
            if(value.getName().equals("dime"))
                dimeCount = dimeCount + 1;
            if(value.getName().equals("quarter"))
                quarterCount = quarterCount +1;
            if(value.getName().equals("Half Dollar"))
                halfdollarCount = halfdollarCount + 1;
            if(value.getName().equals("Dollar"))
                dollarCount = dollarCount + 1;
        }

        System.out.println("\t" +pennyCount+ " pennies " + (df.format(pennyCount*0.01)));
        System.out.println("\t" +nickelCount+ " nickels " + (df.format(nickelCount*0.05)));
        System.out.println("\t" +dimeCount+ " dimes " + (df.format(dimeCount*0.1)));
        System.out.println("\t" +quarterCount+ " quarters " + (df.format(quarterCount*0.25)));
        System.out.println("\t" +halfdollarCount+ " half dollars " + (df.format(halfdollarCount*0.5)));
        System.out.println("\t" +dollarCount+ " dollars " + (df.format(dollarCount*1.0)));
        System.out.println("\t" + "TOTAL DEPOSIT: " + (df.format(getTotalValue())));

    }

    // return the total value of all Coin objects stored in coins as a double
    public double getTotalValue() {
        return ((pennyCount * 0.01) + (nickelCount * 0.05) + (dimeCount * 0.1) + (quarterCount * 0.25) + (halfdollarCount * 0.5) + (dollarCount + 1.0));
    }

    // main method for the class should use these exact three lines of code
    public static void main(String[] args){
        CoinSorterMachine app = new CoinSorterMachine();
        app.depositCoins();
        app.printDepositSummary();
    }
}
