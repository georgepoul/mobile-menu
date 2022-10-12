import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContact;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContact = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact name) {
        int position = myContact.indexOf(name);
        if (position>=0) {
            System.out.println("Contact is already on file");
            return false;
        }
        myContact.add(name);
        return true;
    }

    public boolean updateContact(Contact old, Contact new1) {
        int position = myContact.indexOf(old);
        if (position >= 0) {
            myContact.set(position, new1);
            return true;
        } else if (findContact(new1.getName()) != -1) {
            System.out.println("Contact already exist");

        }
        return false;
    }

    public boolean removeContact(Contact name) {
        int position = myContact.indexOf(name);
        if (position >= 0) {
            myContact.remove(position);
            return true;
        }
        return false;
    }
    private int findContact(Contact name){
        int position = myContact.indexOf(name);
            return position;
    }
    private int findContact(String name) {
        for (int i = 0; i < this.myContact.size(); i++) {
            Contact contact = this.myContact.get(i);
            if (contact.getName().equals(name)) {
                return i;
            }

        }
        return -1;
    }
    public Contact queryContact(String name){
        int position=findContact(name);
        if (position>=0){
            return myContact.get(position);
        }

        return null;
    }

    public void printContacts(){
        System.out.println("Contact List");
        for (int i = 0;i<this.myContact.size();i++){
            System.out.println((i+1) + "." +
                    this.myContact.get(i).getName() + "->" +
                    this.myContact.get(i).getPhoneNumber());

        }
    }
}


