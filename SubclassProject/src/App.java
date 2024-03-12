import processing.core.PApplet;
import java.util.ArrayList;

public class App {

    static ArrayList<Instruments> instruments = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        
        instruments.add(new Modern("Yamaha Keyboard", 299.99, 20));
        instruments.add(new Modern("Electric Guitar", 400, 30));
        instruments.add(new Modern("Bass", 700, 20));
        instruments.add(new Modern("Drums", 400, 10));
        instruments.add(new Modern("Acoustic Guitar", 99.99, 15));
        instruments.add(new Modern("Microphone", 70.00, 30));

        instruments.add(new Classical("Grand Piano", 150000, 2));
        instruments.add(new Classical("Violin", 2000, 30));
        instruments.add(new Classical("Cello", 2500, 30));
        instruments.add(new Classical("Flute", 700, 30));
        instruments.add(new Classical("Stradivarius Violin", 20000000, 1));
        instruments.add(new Classical("Viola", 1000, 10));

        instruments.add(new Other("Harpsicord", 5000, 30, false));
        instruments.add(new Other("Pianoforte", 200000, 30, true));
        instruments.add(new Other("Baroque Violin", 5000, 30, true));
        instruments.add(new Other("Baroque Cello", 6000, 30, true));
        instruments.add(new Other("Lute", 3000, 30, false));
        instruments.add(new Other("Hurdy Gurdy", 4000, 30, true));

        String[] processingArgs = { "MySketch" };
        PSketch mySketch = new PSketch();
        PApplet.runSketch(processingArgs, mySketch);
    }
}

