
/*
 * Irene Feng Nov 2022
 * This is the class where we create the Quiz and run it. It has the main method.  
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Quiz{
        static Scanner sc = new Scanner(System.in);
        public static String user;

        public static void main(String[] args) throws Exception {
                FileSave fs = new FileSave();

                // Create Categories
                Category coconut = new Category("Coconut",
                                "You are strong, both mentally and physically, you're the most reliable in your friend group.");
                Category apple = new Category("Apple",
                                "You are smart and very logical. You study for fun and enjoy engaging in conversations about things you're passionate about.");
                Category mango  = new Category("Mango", "You are kind and fun, you're the extrovert of the group!.");
                // Create Questions
                Question q1 = new Question("You have a math test tommorow, how will you study?");
                // Attach Answers to Questions
                q1.possibleAnswers[0] = new Answer("Study hard, even though you don't want to.", coconut);
                q1.possibleAnswers[1] = new Answer("Work all night because you're having so much fun.", apple);
                q1.possibleAnswers[2] = new Answer("Call your friends to study with them.", mango);

                Question q2 = new Question("It's a warm summer day, how will you spend it?");
                q2.possibleAnswers[0] = new Answer("Go for a run in the park.", coconut);
                q2.possibleAnswers[1] = new Answer("Take your notebook outside and work on a hard math question.", apple);
                q2.possibleAnswers[2] = new Answer("Walk your dog and let him play with other dogs.",
                                mango);

                Question q3 = new Question("You want to give an hour long seminar on your favorite topic, what will it be on?");
                q3.possibleAnswers[0] = new Answer("Topology", apple);
                q3.possibleAnswers[1] = new Answer("Anatomy and Physiology", coconut);
                q3.possibleAnswers[2] = new Answer("Psychology behind social interactions.", mango);

                Question q4 = new Question("You were asked to make food for your club fair. What did you bring?");
                q4.possibleAnswers[0] = new Answer("Cake", mango);
                q4.possibleAnswers[1] = new Answer("Pie", apple);
                q4.possibleAnswers[2] = new Answer("Protein Bars", coconut);

                Question q5 = new Question("You're going to the train station and see a kid struggling to get up the stairs in front of you, how will you help?");
                q5.possibleAnswers[0] = new Answer("Help them up", coconut);
                q5.possibleAnswers[1] = new Answer("Encourage them with kind words", mango);
                q5.possibleAnswers[2] = new Answer("Awkwardly wait for the kid to get up the stairs", apple);

                Question q6 = new Question("It's night time, so you have to do your nightly routine. What does your typical night look like??");
                q6.possibleAnswers[0] = new Answer("Write in your journal", mango);
                q6.possibleAnswers[1] = new Answer("Read a book", apple);
                q6.possibleAnswers[2] = new Answer("Stretches before bed.", coconut);

                Question q7 = new Question("What kind of instrument would you like to play?");
                q7.possibleAnswers[0] = new Answer("Drums", coconut);
                q7.possibleAnswers[1] = new Answer("Guitar", mango);
                q7.possibleAnswers[2] = new Answer("Flute", apple);

                Question q8 = new Question("What's your favorite candy from this list?");
                q8.possibleAnswers[0] = new Answer("Dark Chocolate", apple);
                q8.possibleAnswers[1] = new Answer("Jolly Ranchers", coconut);
                q8.possibleAnswers[2] = new Answer("Hi-Chew", mango);
        


                // For each question, ask, read input, store answer.
                gameIntro();
                Question[] qList = { q1, q2, q3, q4, q5, q6, q7, q8 };
                List<Question> intList = Arrays.asList(qList);
                Collections.shuffle(intList);
                for (Question q : intList) {
                        Category c = q.ask(sc);
                        c.points++;
                }

                // Get most common category from the questions asked
                // Return Category
                Category[] cList = {coconut, apple, mango};
                // these need to be in the same order or the points will be incorrect!
                int index = getMostPopularCatIndex(cList);
                System.out.println("If you were a fruit, you would be a(n) " + cList[index].label + ". ");
                System.out.println(cList[index].description);

                System.out.println("Would you like to save your score?");
                sc.nextLine();
                String SaveScore = sc.nextLine();
                if(SaveScore == "yes" || SaveScore == "y"){
                        System.out.println("Please enter your username.");
                        String user = sc.nextLine();
                        fs.updateResult(user, cList[index].label);
                } 

                System.out.println("Would you like to try again?");
                sc.nextLine();
                SaveScore = sc.nextLine();
                if(SaveScore == "yes" || SaveScore == "y"){
                        fs.updateResult(user, cList[index].label);
                } else {

                }
        }


        public static void gameIntro() throws Exception {
                FileSave load = new FileSave();
                Admin a = new Admin();
                // I got rid of the "press one to play"
                System.out.println();
                System.out.println("---------------------------------------------------------");
                System.out.println("Which Fruit Are You?");
                System.out.println("You get to choose numbers 1-4 for every question!");
                System.out.println("Press 1 to continue, or press 2 to check out the current scores.");
                System.out.println("Press 3 for admin menu.");
                System.out.println("---------------------------------------------------------");
                System.out.println();

                int option = sc.nextInt();
                if(option == 1){
                        
                } if (option == 2){
                        //load.results();
                        System.out.println("Press 1 to return back to main menu.");
                        option = sc.nextInt();
                        if(option == 1){
                                gameIntro();
                        } else {
                                System.out.println("Unknown Input. Please try again");
                        }
                } if(option == 3){
                        a.askForPwd(1);
                } else {
                        System.out.println("Unknown Input. Please try again.");
                }
        }

        public static void input(){

        }

        // returns the index that is the max
        // the tie breaker is the first Category that has the count is the "max" :/ 
        public static int getMostPopularCatIndex(Category[] counts) {
                int maxCount = 0;
                int maxIndex = 0;
                for (int i = 0; i < counts.length; i++) {
                        if (counts[i].points > maxCount) {
                                maxCount = counts[i].points;
                                maxIndex = i;
                        }
                }
                return maxIndex;
        }
}
