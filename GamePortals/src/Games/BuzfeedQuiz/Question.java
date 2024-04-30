package Games.BuzfeedQuiz;

/* Irene Feng 10/12/2022
A question class with Answers.
*/ 
import java.util.Scanner;

public class Question {
    // Fields
    String label;
    Answer[] possibleAnswers = new Answer[3];

    Question(String label) {
        this.label = label;
    }

    // ask a question, and return the category that corresponds to the answer
    Category ask(Scanner sc) {
        System.out.println(this.label);
        // prints out all the answer choices
        for (int i = 0; i < this.possibleAnswers.length; i++) {
            String choice = Integer.toString(i + 1);
            System.out.println("[" + choice + "]:" +
                    this.possibleAnswers[i].label);
        }
        while(!sc.hasNextInt()){
            sc.next();
            System.out.println("You need to pick an integer between 1 and 4, please try again:");
            return ask(sc);
        }
        int ans = sc.nextInt();
        while(ans > 4 || ans < 1){
            System.out.println("You need to pick an integer between 1 and 4, please try again:");
            return ask(sc);
        }
        if(ans == 4){
            System.out.println("You need to pick an integer between 1 and 4, please try again:");
            return ask(sc);
        }
        return possibleAnswers[ans - 1].cat;
    }

}
