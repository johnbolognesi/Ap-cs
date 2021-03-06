/**
 * Holy Grail asks a series of questions and prints user input.
 * @version 09/13/2021
 * @author John Bolognesi
 */

import java.util.Scanner;

public class HolyGrail {
    /**
     * Main entry point for public class HolyGrail
     * @param args none
     */
    public static void main(String[] args) {
        System.out.println("* A chat with the bridge keeper *");
        System.out.println("Who would cross the Bridge of Death must answer me these questions three, ere the other side he see.");

        Scanner input = new Scanner(System.in);

        System.out.print("Question 1: What is your name? ");
        String name = input.nextLine();
        System.out.print("Question 2: What is your quest? ");
        String quest = input.nextLine();
        System.out.print("Question 3: What is your favorite color? ");
        String color = input.nextLine();

        System.out.println("King Arthur says, \"You have to know these things when you're a" + "king, you know.\"");

        System.out.println("Your name is: " + name);
        System.out.println("Your quest is: " + quest);
        System.out.println("Your favorite color is: " + color);

        System.out.println("* end of program *");






    }
}
