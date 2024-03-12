import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


// Note: tell user that it is not recommended to buy 

public class Instruments {
    Scanner sc = new Scanner(System.in);
    double price;
    double renevue;
    int inventory;
    String name;
    String description;
    boolean plays;
    

    public String description(){
        return description;
    }

    public void play(){
        int[] broken = {35, 39, 20, 44, 1};
        Random r = new Random();
        int rand = r.nextInt(50);
        if(Arrays.asList(broken).contains(rand)){
            System.out.println("It looks like this one is broken!");
            inventory--;
        } else {
            buy();
        }    
    }

    public void buy(){
        System.out.println("Would you like to buy this one?");   
        String x = sc.nextLine();
        if(x == "yes"){
            System.out.println("Added to cart!");
        } else {
            System.out.println("Returning back to menu...");
        }
    }

}

class Classical extends Instruments{
    public Classical(String name, double price, int inventory){
        this.name = name;
        this.price = price;
        this.inventory = inventory;
    }
}

class Modern extends Instruments{
    public Modern(String name, double price, int inventory){
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        double revenue = this.price * 1.10;
    }
    

    @Override
    public void play(){
            Random r = new Random();
            int x = r.nextInt(40);
            if(x == 20){
                System.out.println("Oops, it looks like one of the keyboards don't play.");
                inventory--;
            } else {
                System.out.println("Yay, it looks like this one works!");
                buy();
            }
        }
    }

class Other extends Instruments{
        //antique instruments will attract more people + revenue if your band is classical
    private Boolean antique;
    public Other(String name, double price, int inventory, Boolean antique){
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.antique = antique;
    }
}


