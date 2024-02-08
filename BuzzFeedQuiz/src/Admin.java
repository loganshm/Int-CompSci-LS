import java.util.Scanner;
import java.util.HashMap;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Admin {
    //two scanners: one for int, the other for String
    static Scanner sc = new Scanner(System.in);
    static Scanner scInt = new Scanner(System.in);

    final String shapwd = "5962002f5bb698c714d6c21f679e2815698e572e9eefc85f7a114bcaa700179d";
    // user input -> sha256
    Admin() throws Exception {

    }

    public void askForPwd(int i) throws Exception{
        System.out.println("Please Input Password:");
        String userinput = sc.nextLine();
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        final byte[] hashbytes = digest.digest(userinput.getBytes(StandardCharsets.UTF_8));
        String sha3Hex = bytesToHex(hashbytes);

        if(i == 3){
            System.out.println("Entered password wrong 3 times, returning to main menu.");
        }

        if(sha3Hex.equals(shapwd)){
            options();
        } if(sha3Hex != shapwd) {
            System.out.println("Wrong password, please try again.");
            askForPwd(i + 1);
        }
    }

    private void options() throws IOException, Exception{
        FileSave fs = new FileSave();

        System.out.println("Options:");
        System.out.println("1: Add Score");
        System.out.println("2: Delete Score");
        System.out.println("4: Change name of result file.");
        System.out.println("4: Return to Game");
        int AdminOpiton = scInt.nextInt();

        if(AdminOpiton == 1){
            System.out.println("Enter Username to add.");
            String user = sc.nextLine();
            System.out.println("Enter score to give them: coconut, apple, mango.");
            String value = sc.nextLine();
            fs.updateResult(user, value);
            System.out.println("Action completed.");
            options();
        } if (AdminOpiton == 2){
            System.out.println("Enter username to delete");
            String user = sc.nextLine();
            fs.deleteResult(user);
            System.out.println("Action completed");
            options();
        } if(AdminOpiton == 3){
            System.out.println("Enter filename change:");
            String filename = sc.nextLine();
            fs.fileNameChange(filename);
            options();
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}