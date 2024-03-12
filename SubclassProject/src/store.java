import java.util.Random;

public class Store {
    // x and y is center of the ball
    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;
    private Random r = new Random();

    public Store(int x, int y) {
        this.x = x;
        this.y = y;
        this.size = r.nextInt(40);
        this.xSpeed = r.nextInt(3);
        this.ySpeed = r.nextInt(3);
    }

    public Store(int x, int y, int diameter) {
        this.x = x;
        this.y = y;
        this.size = diameter;
        this.xSpeed = r.nextInt(8);
        this.ySpeed = r.nextInt(8);
    }

    public void move(int maxWidth, int maxHeight) {
        x += xSpeed;
        if (x < size / 2 || x > maxWidth - size/2) {
            xSpeed *= -1;
        }

        y += ySpeed;
        if (y < size/2 || y > maxHeight - size / 2) {
            ySpeed *= -1;
        }
    }
}
