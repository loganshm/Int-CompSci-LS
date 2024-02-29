import java.util.HashMap;
import java.util.Random;

public class modern {
    float price;
    float renevue;
    int inventory;
    String name;
    String description;
    boolean plays;


    public String description(){
        return description;
    }

    public void play(){
        if (plays == true){

        } else {

        }
    }

    
}

class Keyboard extends modern{
    int inventory = 20;

    public Keyboard(String name, int price){
        this.name = name;
        this.price = price;
    }

    @Override
    public void play(){
        Random r = new Random();
        int x = r.nextInt(40);
        if(x == 20){
            System.out.println("Oops, it looks like one of the keyboards don't play!");
            inventory--;
        } else {
            System.out.println("Yay, it looks like this one works! Would you like to buy it?");
        }
    }
}

