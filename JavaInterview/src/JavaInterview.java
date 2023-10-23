import java.util.Scanner;

public class JavaInterview {
    public static void main(String[] args){
        
        System.out.println("Hello person!");
        Scanner obj = new Scanner(System.in);
        System.out.println("What is your name?");
        String user = obj.nextLine();
        
        System.out.println("Hello " + user + ", my name is Logan.");
        Scanner ice = new Scanner(System.in);
        System.out.println("What's your favorite ice cream?");
        String icecream = ice.nextLine();

        if((icecream.equals("Cookies and Cream")) && (user.equals("Logan"))){
            System.out.println("You're my creator. Hello, Logan!");
        } else {
            System.out.println("I also like " + icecream + ".");
        }

    
        obj.close();
        ice.close();
    }
}
