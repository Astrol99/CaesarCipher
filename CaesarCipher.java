import java.util.Scanner;
import java.util.Random;

public class CaesarCipher{
    public static void main(String []args){

        String product = "";
        String EncryptedText = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int key = 0;

        //Input of user
        System.out.print("Enter text: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine().toLowerCase();
        int strInt = input.length();
        
        //Option between Encrypt, Decrypt, or BruteForce

        System.out.print("Would you like to (E)ncrypt or (D)ecrypt?: ");
        Scanner cry = new Scanner(System.in);
        String crypt = cry.nextLine().toLowerCase();

        if (crypt.equals("e")){

            //Option between Random generated key or custom key
            System.out.print("(R)andom generated key or (C)ustom key?: ");
            Scanner opt = new Scanner(System.in);
            String option = opt.nextLine().toLowerCase();

            //If R or C is selected
            if (option.equals("c")){

                System.out.print("Enter key: ");
                Scanner ke = new Scanner(System.in);
                key = ke.nextInt();

                if (key%26 == 0){
                    key += 1;
                }    

                System.out.println("Key: " + key);
                
            }else if (option.equals("r")){

                Random KEY = new Random();
                key = KEY.nextInt(10000000) + 1;

                if (key%26 == 0){
                    System.out.println("Oops, key has been altered due to 26 being the same as your text.");

                    key += 1;
                }    

                System.out.println("Key: " + key);
            
            }else {
                
                System.out.println("Invalid Answer - Please try again...");
            
            }

            //Main Encryption
            for (int i = 0; i < strInt; i++){

                int initalInputInt = alphabet.indexOf(input.charAt(i));
                int finalInputInt = (key + initalInputInt) % 26;
                char finalCharOne = alphabet.charAt(finalInputInt);
                    
                    EncryptedText += finalCharOne;
            
            product = "Encrypted";
            
            }
        }else if (crypt.equals("d")){

            System.out.print("Enter the key given: ");
            Scanner Dokey = new Scanner(System.in);
            int Dekey = Dokey.nextInt();

            for (int i = 0; i < strInt; i++){
                
                int initalInputInt = alphabet.indexOf(input.charAt(i));

                int DecryptKey = initalInputInt - Dekey;

                if (DecryptKey < 0){
                    fix:
                        while (true) {
                            DecryptKey = Math.abs(DecryptKey);
                            DecryptKey = alphabet.length() - DecryptKey;

                            if (DecryptKey <= alphabet.length() && DecryptKey >= 0){
                                break fix;
                            }
                        }
                }

                int finalInputInt = (DecryptKey) % 26;
                char finalCharOne = alphabet.charAt(finalInputInt);

                    EncryptedText += finalCharOne;
            }

            product = "Decrypted";

        }else{
            System.out.println("Invalid answer - Please try again later...");
        }
        System.out.println(product + " text: " + EncryptedText);
        }
}    