package phonebook;
import java.util.ArrayList;

public class ConsoleDisplay {
    public static void printMenu() {
        System.out.println(String.format("%s - ADD; %s - DELETE; %s - UPDATE; %s - SHOW;" +
                        " %s - FIND ; %s - SAVE; %s - EXIT", ActionType.ADD.getIndex(), ActionType.DELETE.getIndex(), ActionType.UPDATE.getIndex(),
                ActionType.SHOW.getIndex(), ActionType.FIND.getIndex(), ActionType.SAVE.getIndex(), ActionType.EXIT.getIndex()
        ));
    }
    public static void printContacts(ArrayList<Contact> contacts){
        if(contacts.size() ==0){
            System.out.println("No contacts found!");
        }
        else {
            int i = 1;
            for (Contact contact : contacts) {
                System.out.println(i++);
                System.out.println(contact.getName());
                System.out.println(contact.getPhone());
                System.out.println("-------------------------");
            }
        }
    }
    public static void printContact(Contact contact){
        System.out.println("Contact: ");
        System.out.println(contact.getName());
        System.out.println(contact.getPhone());
        System.out.println(contact.getBirthday());
        System.out.println("-------------------------");
    }
}