package Games.Wordle;


import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import SystemFiles.Game;


class Wordle implements Game{

    String fileName = "wordle.csv";
    Scanner inputStream;
    File file = new File(fileName);
    List<String> options;

    public String csvRead(){
        try{
            inputStream = new Scanner(file);

            while(inputStream.hasNext()){
                String line = inputStream.next();
                options.add(line);
            }

            inputStream.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
            return null;
    }

    public String getGameName(){
        return null;
    }

    public void play(){
        csvRead();
        int rnd = new Random().nextInt(options.size());
        String answer = options.get(rnd);
        Scanner sc = new Scanner(System.in);
        List<String> guesses = new ArrayList<>();
        String[] nums = {"One", "Two", "Three", "Four", "Five", "Six, final chance"};

        while (sc.nextLine().length() == 5){
            for (String n : nums) {
                System.out.println("Enter Guess Number " + nums[n] + " :");
            }


        }
        

    } 

    public String getScore(){
        return null;
    } // get a score - if there is no "score" you can return return "N/A" or something.

    public void writeHighScore(File f){

    } // writes the high score of this game to a file.

    public Boolean ErrorCheck(){
        return null;
    }


}
