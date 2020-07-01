import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class BankingApplication{
    public static void main(String [] args){
        BankAccount b1 = new BankAccount();
        b1.showMenu();
        
    }

    public static class BankAccount{
        String cName;
        int IDlength = 10;
        int min = 0, max = 10000;
        double balance = ThreadLocalRandom.current().nextInt(min, max + 1); 
        double previousTransaction = 0;
        
        /*String template = "ABCDEFGHIJKLMNOPQRSTUVXWZ123456789";
        char [] cID = new char[IDlength];*/
        
        
        public BankAccount(){};

        
        void deposit (int amount){
            if(amount > 0){
                balance += amount;
                previousTransaction = amount;
            }
            else{
                System.out.println("Please add a positive number!");
            }

        }

        void withdraw (int amount){
            if(amount > 0){
                balance -= amount;
                previousTransaction = -amount;
            }
            else{
                System.out.println("Please add a positive number!");
            }
        }

        double checkBalance(){
            return balance;
        }

        void CheckPrevTrans(){
            if(previousTransaction < 0){
                System.out.println("You have withdrawed "+Math.abs(previousTransaction));
            }
            else if(previousTransaction > 0){
                System.out.println("You have deposited "+previousTransaction);
            }
            else{
                System.out.println("No transaction occured");
            }
        }

        void showMenu(){
            char option = '\0';
            Scanner scan = new Scanner(System.in);
            System.out.println("Hello MR/MRS ...");
            System.out.println("Please insert your last name");
            System.out.println("\n");
            cName = scan.next();
            scan.nextLine();
            System.out.println("Welcome back MR/MRS "+cName);
            System.out.println("Your account balance is "+balance);
            System.out.println("\n");
            System.out.println("A: Show balance");
            System.out.println("B: Deposit");
            System.out.println("C: Withdraw");
            System.out.println("D: Check previous transaction");
            System.out.println("E: Exit");
            System.out.println("\n");
            System.out.println("\n");

            do{
                System.out.println("Choose an option please");
                option = scan.next().charAt(0);
                System.out.println("\n");

                switch(option){
                    case 'A' : System.out.println("======================");
                    System.out.println("Your balance is "+balance);
                    System.out.println("======================");
                    System.out.println("\n");
                    break;

                    case 'B' : System.out.println("======================");
                    System.out.println("Please insert the amount you want to deposit");
                    int amount = scan.nextInt();
                    deposit(amount);
                    System.out.println("======================");
                    System.out.println("\n");
                    break;

                    case 'C' : System.out.println("======================");
                    System.out.println("Please insert the amount you want to withdraw");
                    int amount2 = scan.nextInt();
                    withdraw(amount2);
                    System.out.println("======================");
                    System.out.println("\n");
                    break;

                    case 'D' : System.out.println("======================");
                    CheckPrevTrans();
                    System.out.println("======================");
                    System.out.println("\n");
                    break;

                    case 'E' :  System.out.println("======================");
                    System.out.println("Thank you for being our client!");
                    System.out.println("Have a good day!");
                    System.out.println("======================");
                    System.out.println("\n");
                    return;

                }

            }
            while (option != 'E');}
            
    }
}

