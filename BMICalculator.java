import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * BMI Calculator Calculates BMI with height and weight.
 * @version 11/08/2021
 * @author John Bolognesi
 */

public class BMICalculator {

    /**
     * computeBMI converts metric to imperial
     * @param inches
     * @param pounds
     * @return
     */
    public static double computeBMI(int inches, int pounds) {
        if(inches <=0 || pounds <= 0)
            return 0;
        return pounds*.454 / Math.pow(inches*.0254, 2);
    }

    /**
     * extract Inches turns the users input into an amount of inches
     * @param value
     * @return
     */
    public int extractInches(String value) {
        int qtPos = value.indexOf("'");
        int dblQtPos = value.indexOf("\"");
        if(qtPos == -1 || dblQtPos == -1) {
            return -1;
        }

        int feet = Integer.parseInt(value.substring(0, qtPos));
        int inches = Integer.parseInt(value.substring(qtPos+1, dblQtPos));

        if(inches < 0 || inches > 11 || feet < 0)
            return -1;

        return (feet*12*inches == 0) ? -1 : feet*12+inches;

    }


    /**
     * Main entry point for Compute BMI
     * @param args
     */
    public static void main(String[] args) {
        StringInputParser obj = new StringInputParser();
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        while(true) {
            try {
                System.out.print("Enter your height in feet and inches (Ex 6'1\"): ");
                String height = in.nextLine();
                int inches = obj.extractInches(height);
                System.out.print("Enter your weight in pounds: ");
                Integer weight = in.nextInt();
                in.nextLine(); // Scanners are weird this handles the nextInt buffer
                System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " + df.format(computeBMI(inches, weight)));
                System.out.println("Continue (Y/N): ");
                String cont = in.nextLine();
                if (!cont.toLowerCase().equals("y"))
                    break;
            }
            catch(Exception e) {
                System.out.println("Invalid Input");
                in.nextLine();
            }
        }
        System.out.println("End of Program");
    }
}
