// Made by Logan Singh
// Intermediate Programming G2

import java.util.Random;
import java.util.Scanner;

public class App {
     /*
      * I chose to declare these as static variables since
      * I could choose to access them from multiple methods if necessary.
      */

     public static int x, y, answer;
     public static Random num = new Random();

     static int guessattempt(int numOfGuesses) {
          System.out.println("What's your guess?");
          Scanner sc = new Scanner(System.in);
          String guess = sc.nextLine();
          int guessnum = Integer.valueOf(guess);

          /*
           * These if statments check if the number guessed is right, too large, or too
           * small in that respective order. If not correct, we recurse.
           * At the end, we state what the answer was and print out how many attempts it
           * took.
           */
          if (guessnum == answer) {
               sc.close();
               numOfGuesses++;
               System.out.println("Congratulations, you got the answer right!");
               System.out.println("The answer was: " + answer + ", and it took you " + numOfGuesses + " attempts!");
               return numOfGuesses;
          }
          if (guessnum > answer) {
               System.out.println("Too large, try again!");
               numOfGuesses++;
               return guessattempt(numOfGuesses);
          } else {
               System.out.println("Too small, try again!");
               numOfGuesses++;
               return guessattempt(numOfGuesses);
          }
     }

     public static int numberInput() {
          /*
           * Assigning floor and ceiling values.
           * 
           * In addition, this method checks wether or not the user input an int.
           * If the user attempts to put a non int type value, we tell the user that they
           * need to
           * put in a int and recurse.
           * 
           */

          System.out.println("What's your floor value?");
          Scanner sc = new Scanner(System.in);
          if (sc.hasNextInt()) {
               System.out.println("Great! Your floor value is: " + (x = sc.nextInt()));
          } else {
               System.out.println("Oops! You put in a non integer value, please try again.");
               numberInput();
          }

          System.out.println("What's your ceiling value?");
          if (sc.hasNextInt()) {
               System.out.println("Great! Your ceiling value is " + (y = sc.nextInt()));
               answer = num.nextInt(x, y);
               guessattempt(0);
               return 0;

          } else {
               System.out.println("Oops! You put in a non integer value, pleas try again.");
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
