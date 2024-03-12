import java.awt.*; 

// for Java AWT
public class AWTBall extends Store {

    public AWTBall(int x, int y, int diameter) {
        super(x, y, diameter);
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        // we want to the /center/ of the ball to be drawn at x, 
        // so to get the upper left hand corner 
        // we subtract x by size/2. same for y
        //g.fillOval(x - size/2, y - size /2, size, size); 
        // note that the size is an inherited field. 
    }
}
