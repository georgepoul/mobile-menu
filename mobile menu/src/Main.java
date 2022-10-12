import java.util.Scanner;

public class Main {
    private static Scanner scanner=new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("2271052102");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit){
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();

            switch (action){
                case 0:
                    System.out.println("\nShutting down...");
                    quit=true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }

    }
    private static void updateContact(){
        System.out.println("Enter name");
        String name=scanner.next();
        Contact existingContactRecord =mobilePhone.queryContact(name);
        if (existingContactRecord == null){
            System.out.println("not found");
        }
        System.out.println("Enter name");
        String newName= scanner.next();
        System.out.println("enter number");
        String newphone=scanner.next();
        Contact newContact= Contact.createContact(newName,newphone);
        if (mobilePhone.updateContact(existingContactRecord,newContact)){
            System.out.println("Success update.");
        }else {
            System.out.println("Error");
        }
    }
    private static void  queryContact(){

        System.out.println("Enter name");
        String name=scanner.next();
        Contact existingContactRecord =mobilePhone.queryContact(name);
        if (existingContactRecord == null){
            System.out.println("not found");
        }else {
            System.out.println("Name: " + existingContactRecord.getName() + "Phone: " + existingContactRecord.getPhoneNumber());
        }

    }
    private static void removeContact(){
        System.out.println("Enter name");
        String name=scanner.next();
        Contact existingContactRecord =mobilePhone.queryContact(name);
        if (existingContactRecord == null){
            System.out.println("not found");
        }
        if (mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Deleted");
        }else {
            System.out.println("Error");
        }




    }
    private static void addNewContact(){
        System.out.println("Enter contact name:");
        String name= scanner.next();
        System.out.println("Enter phone number:");
        String phone = scanner.next();
        Contact newContact= Contact.createContact(name,phone);
        if (mobilePhone.addNewContact(newContact)){
            System.out.println("added");
        }

    }

    private static void printContacts(){
        mobilePhone.printContacts();
    }
    private static void startPhone(){
        System.out.println("Starting phone...");
    }
    private static void printActions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to shutdown\n" +
                           "1 - to print contact\n" +
                           "2 - to add new contact\n" +
                           "3 - to update contact\n" +
                           "4 - to remove contact\n" +
                           "5 - query if an existing contact exist\n" +
                           "6 - to print a list of available actions.");
        System.out.println("Choose your action:");

    }
}