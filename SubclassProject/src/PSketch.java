import java.util.ArrayList;

import javax.sound.midi.Instrument;

import processing.core.PApplet; // java libraries 

public class PSketch extends PApplet {
    // all the functions you know and love below
    // instead of setup we have settings

    // we can import an object in some class that we have somewhere else.
    ProcessingBall b = new ProcessingBall(70, 60);

    // How do we make a lot of these objects? 
    // YOUR CODE HERE: Initialize empty arraylist of balls

    @Override
    public void settings() {
        size(500, 500);
        // YOUR CODE HERE: add processing balls to the array list 

    }

    @Override
    public void draw() {
        // YOUR CODE HERE: draw and move all processing balls
        background(255);

        String s = "Welcome to our store!"
                + " We offer many different instruments, ranging from modern to medieval period"
                + " Please select which type of band you are in.";
        text(s, 120, 150, 280, 320);
        rect(50,300,80,40);
        rect(200,300,80,40);
        rect(350,300,80,40);

        fill(255);
        text("Modern", 70, 310, 200, 200);
        text("Classical", 220, 310, 200, 200);
        text("Other", 370, 310, 200, 200);

        if(mousePressed){

        }

        b.draw(this);
        //b.move(width, height);
    }

    @Override
    public void mousePressed() {
        // YOUR CODE HERE: what do you want to do? 
        // maybe would be cool to add a ball to the arraylist? 
    }
}
