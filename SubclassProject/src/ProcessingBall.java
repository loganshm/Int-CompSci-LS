import processing.core.PApplet;

public class ProcessingBall extends Store {

    int color = 0; // black
    public ProcessingBall(int x, int y) {
        super(x, y);
    }

    public ProcessingBall(int x, int y, int r, int g, int b) {
        super(x, y);
        // alpha first 8 bits, r second 8 bits, g third 8 bits, b last 8 bits
        // alpha default is opaque (255 max)
        color = 255 << 24 | r << 16 | g << 8 | b; 
    }

    // display look in processing
    public void draw(PApplet sketch) {
        sketch.fill(color);
        //sketch.ellipse(x, y, size, size);
    }
}
