import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.*;

public class SketchJPanel extends JPanel {
    AWTBall b = new AWTBall(70, 60, 30);

    public static void main(String[] args) throws InterruptedException {
        SketchJPanel panel = new SketchJPanel();
        panel.play();
    }

    SketchJPanel() {
        JFrame frame = new JFrame("Bouncing Ball");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.add(this);
        
        frame.setSize(500,500);
		frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // ignore this part
        super.paintComponent(g);
        // draw ball
        //b.move(500, 500);
        b.draw(g);
    }

    public void play() throws InterruptedException {
        while (true) {
            repaint();
            Thread.sleep(10);
        }
    }
}