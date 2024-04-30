/*
 * Irene Feng 10/12/2022
 */
package Games.BuzfeedQuiz;

public class Category {

    String label;
    String description; // after user is done and gets this category, will output description.
    int points = 0;

    Category(String c, String description) {
        this.label = c;
        this.description = description;
    }

}
