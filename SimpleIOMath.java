/**
 * SimpleIOMath asks a series of questions and prints user input.
 * @version Monday, September 27, 2021
 * @author John Bolognesi
 */

import java.util.Scanner;


public class SimpleIOMath {
    private String name;
    private int age;
    private int favNumber;

    /**
     * smallestPrime is responsible for collecting the smallest prime factor of a user input. 
     * @param num
     * @return
     */
    private int smallestPrime(int num)  {
        int smallest = 2;
        for(int i = 2; i <= (int)(Math.sqrt(num))+1; i++) {
            if (num % i == 0)
                return i;
        }
        return num;
    }


    /**
     * PromptUser prompts the user for 3 inputs and stores them as variables.
     */
    public void promptUser()    {

        Scanner input = new Scanner(System.in);

        System.out.println("Question 1: What is your name?");
        name = input.nextLine();
        System.out.println("Question 2: How old are you?");
        age = input.nextInt();
        System.out.println("Question 3: What is your favorite number?");
        favNumber = input.nextInt();

    }

    /**
     * printInfo prints the default lines of text as well as the user inputs.
     */
    public void printInfo() {
        System.out.println("I'm gonna teach you how to sing it out\n" +
                "Come on, come on, come on\n" +
                "Let me tell you what it's all about\n" +
                "Reading, writing, arithmetic\n" +
                "Are the branches of the learning tree");

        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + age);
        System.out.println("At your next birthday, you will turn " + (age + 1) +".");
        System.out.println("The first prime factor of "+age+" is:" + smallestPrime(age));
        System.out.println("Your favorite number is: " + favNumber);
        System.out.println("Your favorite number squared is: " + favNumber*favNumber);


    }

    /**
     * Main entry point for public class SimpleIOMath
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("* Sit yourself down, take a seat *");
        System.out.println("* All you gotta do is repeat after me *");
        SimpleIOMath obj = new SimpleIOMath();
        obj.promptUser();
        obj.printInfo();
        System.out.println();

        System.out.println("* end of program *");

    }

}
