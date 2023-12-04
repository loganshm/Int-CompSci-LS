// Made by Logan Singh
// Intermediate Programming G2

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
     /*
      * I chose to declare these as static variables since
      * I could choose to access them from multiple methods if necessary.
      */

     public static int x, y, answer;
     public static Random num = new Random();
     public static ArrayList<Integer> pastGuesses = new ArrayList<Integer>();

     /*
     * These if statments check if the number guessed is right, too large, or too
     * small in that respective order. If not correct, we recurse.
     * At the end, we state what the answer was and print out how many attempts it
     * took.
     * 
     * ArrayList pastGuesses stores all past attempts and will tell the player if they input 
     * a past attempt. Player will not be penalized.
     */

     public static int guessattempt(int numOfGuesses) {
          System.out.println("What's your guess?");
          Scanner sc = new Scanner(System.in);
          String guess = sc.nextLine();
          int guessnum = Integer.valueOf(guess);

          if(pastGuesses.contains(guessnum)) {
               System.out.println("You already guessed this, please try again.");
               return guessattempt(numOfGuesses);
          } else {     
               if (guessnum == answer) {
                    sc.close();
                    numOfGuesses++;
                    System.out.println("Congratulations, you got the answer right!");
                    System.out.println("The answer was: " + answer + ", and it took you " + numOfGuesses + " attempts!");
                    return numOfGuesses;
               }else if (guessnum > answer) {
                    System.out.println("Too large, try again!");
                    pastGuesses.add(guessnum);
                    numOfGuesses++;
                    return guessattempt(numOfGuesses);
               } else {
                    System.out.println("Too small, try again!");
                    pastGuesses.add(guessnum);
                    numOfGuesses++;
                    return guessattempt(numOfGuesses);
               }
          }
     }

     /*
     * Assigning floor and ceiling values.
     * 
     * In addition, this method checks wether or not the user input an int.
     * If the user attempts to put a non int type value, we tell the user that they
     * need to
     * put in a int and recurse.
     * 
     */
     public static int numberInput() {
          System.out.println("What's your floor value?");
          Scanner sc = new Scanner(System.in);
          if (sc.hasNextInt()) {
               System.out.println("Great! Your floor value is: " + (x = sc.nextInt()));
          } else {
               System.out.println("You put in a non integer value, please try again.");
               numberInput();
          }

          System.out.println("What's your ceiling value?");
          if (sc.hasNextInt()) {
               System.out.println("Great! Your ceiling value is " + (y = sc.nextInt()));
               answer = num.nextInt(x, y);
               guessattempt(0);
               return 0;

          } else {
               System.out.println("You put in a non integer value, pleas try again.");
               numberInput();
               return 0;
          }
     }

     public static void main(String[] args) throws Exception {
          Scanner sc = new Scanner(System.in);
          System.out.println("Hello, Player!");
          numberInput();
          sc.close();
     }
}
