package phonebook;

import java.util.ArrayList;

public class PhoneBook {
    private ArrayList<Contact> contacts=new ArrayList<Contact>();

    public ArrayList<Contact> getAllContact() {
        return contacts;
    }
    public void add(Contact contact){
        contacts.add(contact);
    }
    public Contact get(int id){
        return contacts.get(--id);
    }
    public void del(int id){
        contacts.remove(--id);
    }
    public ArrayList<Contact> find(String val){
        ArrayList<Contact> result=new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().startsWith(val)  || contact.getPhone().endsWith(val)){
                result.add(contact);
            }
        }
        return result;
    }
}
