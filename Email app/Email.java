import java.util.*;
public class Email{

    private String firstName;
    private String lastName;
    private String department;
    private String temp = "ABCDEFGHIJKLMNOPQRSTUVXWZabcdefghijklmopqrstuvxwz1234567890";
    private int passLength = 10;
    private char [] pass = new char[passLength];
    private String altEmail= null;
    private int emailCapacity = 500; 
    private int ch=0;

    public Email(){}

    public void setPass(){
        for(int i=0;i<passLength;i++){
            int rand = (int) (Math.random() * temp.length());
            pass[i] = temp.charAt(rand);

        }
        System.out.println(pass);
    }

    public void setEmailCapacity(int newCapacity){
        this.emailCapacity = newCapacity;
    }

    public void setPassword(String password){
        passLength = password.length();
        pass=new char[passLength];
        for(int i=0;i<passLength;i++){            
            this.pass[i]=password.charAt(i);            
        }

        System.out.println("Your new password is "+password);
    }

    public void setAltMail(String altMail){
        this.altEmail=altMail;
    }

    public String getName(){
        return firstName+" "+lastName;
    }

    public String getEmail(){
        return firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+"gmail.com";
    }

    public int getCapacity(){
        return emailCapacity;
    }

    public void appStart(){
        System.out.println("Hello! What is your name?");
        System.out.println("Please write it in one line as FIRSTNAME LASTNAME \n");
        Scanner scan = new Scanner(System.in);
        String [] nume = scan.nextLine().split("\\s+");
        for(int i=0;i<nume.length;i++){
            firstName = nume[0];
            lastName = nume[1];
        }
        System.out.println("Hello "+firstName+" "+lastName);
        System.out.println("Please state your department \n");
        System.out.println("1. SALES");
        System.out.println("2. DEVELOPMENT");
        System.out.println("3. ACCOUNTING");
        System.out.println("4. I don't have a department");
        int dep = scan.nextInt();
        switch(dep){
            case 1 : System.out.println("The Sales Department is glad to have you! \n");
            department = "sales";
            break;

            case 2 : System.out.println("The Development Department is glad to have you! \n");
            department = "development";
            break;  

            case 3 : System.out.println("The Accounting Department is glad to have you! \n");
            department = "accounting";
            break;
            default :  System.out.println("You don't have a department \n");   
            break;
        }

        System.out.println("This is your automatically generated password:");
        setPass();
        System.out.println("");

        System.out.println("And here is your email adress:");
        if(department!=null){
            System.out.println(firstName.toLowerCase()+"."
                +lastName.toLowerCase()+"@"
                +department+"."+"gmail.com");}
        else{
            System.out.println("An email adress can't be generated as you don't have a department \nConsider providing an alternative one instead");
        }
        System.out.println("");

        do {

            System.out.println("What do you want to do "+firstName+" "+lastName+"?");
            System.out.println("1.Change the password \n2.Set the mailbox capacity \n3.Define an alternative email adress \n4.View \n5.Exit \n");
            ch = scan.nextInt();
            switch(ch){
                case 1 : System.out.println("Please provide your new password");
                String newPass = scan.next();
                setPassword(newPass);
                System.out.println("");
                break;

                case 2 : System.out.println("Please provide the new mailbox capacity");
                emailCapacity=scan.nextInt();
                System.out.println("Your new mailbox capacity is "+emailCapacity);
                System.out.println("");
                break;

                case 3 : System.out.println("Are you sure you want to set an alternative email adress?");
                System.out.println("1. yes\n2. no");
                int choice = scan.nextInt();
                switch(choice){
                    case 1 : System.out.println("Please provide your alternative email");
                    String altMail = scan.next();
                    setAltMail(altMail);
                    System.out.println(altEmail);
                    break;

                    case 2: System.out.println("Consider adding one later as it provides a better security");
                    break;           
                }
                System.out.println("");
                break;       

                case 4 : System.out.println("What do you want to view?");
                System.out.println("1.Name \n2.email \n3.Mailbox capacity \n");   
                int ch4 = scan.nextInt();
                switch(ch4){
                    case 1 : System.out.println("Here is your set name: ");
                    System.out.println(getName());
                    System.out.println("");
                    break;

                    case 2 : System.out.println("Here is your email: ");
                    if(department!=null){
                        System.out.println(getEmail());
                        System.out.println("");}
                    else {
                        System.out.println("As you don't have a department, you don't have an email adress yet");
                    }
                    break;

                    case 3 : System.out.println("Here is your mailbox capacity: ");
                    System.out.println(getCapacity());
                    System.out.println("");
                    break;
                }
                break;  

                case 5 : System.out.println("The app will close..");
                return;   
            }}
        while(ch !=5);

    }
}