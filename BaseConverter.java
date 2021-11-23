/**
 * BaseConverter opens a data file, Converts to the specified base then outputs new text onto a seperate file
 * @author John Bolognesi
 * @version 11/11/21
 */

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;


public class BaseConverter {
    // Constructor for class.
    public BaseConverter()  {

    }

    /**
     * Convert a String num in fromBase to base-10 int.
     * @param num
     * @param fromBase
     * @return
     */
    public int strToInt(String num, String fromBase)    {
        int base = Integer.parseInt(fromBase);
        String alpha = "0123456789ABCDEF";
        int sum = 0, exp = 0;
        for (int i = num.length() -1; i >= 0; i--)  {
            sum += alpha.indexOf("" + num.charAt(i)) * Math.pow(base, exp);
            exp++;
        }
        return sum;
    }


    /**
     * Convert a base-10 int to a String number of base toBase.
     * @param num
     * @param toBase
     * @return
     */
    public String intToStr(int num, int toBase) {
        String alpha = "0123456789ABCDEF";
        String toNum = "";

        while (num > 0) {
            toNum = alpha.charAt(num % toBase) + toNum;
            num /= toBase;
        }

        if(toNum.equals(""))
            return "0";
        return toNum;


    }

    /**
     * Opens the file stream, inputs data one line at a time, converts, prints
     * the result to the console window and writes data to the output stream.
     */
    public void inputConvertPrintWrite() {
        File file = new File("values10.dat");
        Scanner sc = null;
        PrintWriter pw = null;
        try {
            sc = new Scanner(new File("datafiles/values10.dat"));
            pw = new PrintWriter(new File("datafiles/converted.dat"));
            while (sc.hasNext()) {
                String[] line = sc.nextLine().split("\t");
                int fromBase = Integer.parseInt(line[1]);
                int toBase = Integer.parseInt(line[2]);
                if (fromBase < 2 || fromBase > 16) {
                    System.out.println("Invalid input Base " + fromBase);
                } else if (toBase < 2 || toBase > 16) {
                    System.out.println("Invalid output Base " + toBase);
                } else {
                    System.out.println(line[0] + " Base " + fromBase + " = " + intToStr(strToInt(line[0], line[1]), toBase) + " base " + toBase);
                    pw.println(line[0] + "\t" + fromBase + "\t" + intToStr(strToInt(line[0], line[1]), toBase) + "\t" + toBase);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sc != null)
            sc.close();
        if (pw != null)
            pw.close();


    }


    /**
     * Main entry point for BaseConverter
     * @param args
     */
    public static void main(String[] args) {
        BaseConverter app = new BaseConverter();
        app.inputConvertPrintWrite();
        //System.out.println(app.intToStr(5789324, 16));
    }
}
