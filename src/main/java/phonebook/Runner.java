package phonebook;
import java.util.ArrayList;
import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        PhoneBook phoneBook=new PhoneBook();
        Scanner scanner=new Scanner(System.in);
        while (true){
            ConsoleDisplay.printMenu();
            ConsoleDisplay.printContacts(phoneBook.getAllContact());
            if(scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input == ActionType.EXIT.getIndex()) {
                    System.out.println("Phone Book Has Closed.");
                    break;
                } else if (input == ActionType.ADD.getIndex()) {
                    System.out.println("Enter name: ");
                    String name= scanner.next();
                    System.out.println("Enter phone: ");
                    String phone= scanner.next();
                    System.out.println("Enter birthday: ");
                    String birthday= scanner.next();
                    Contact contact =new Contact(name, phone, birthday);
                    phoneBook.add(contact);
                    ConsoleDisplay.printContacts(phoneBook.getAllContact());
                }
                else if(input==ActionType.DELETE.getIndex()){
                    System.out.println("Enter id: ");
                    int id= scanner.nextInt();
                    phoneBook.del(id);
                    ConsoleDisplay.printContacts(phoneBook.getAllContact());
                }
                else if(input==ActionType.UPDATE.getIndex()){
                    System.out.println("Enter id: ");
                    int id= scanner.nextInt();
                    System.out.println("Enter number of option which you want to update:1-name, 2-phone, 3-birthday");
                    int opt=scanner.nextInt();
                    if (opt==1){
                        ConsoleDisplay.printContact(phoneBook.get(id));
                    }
                }
                else if(input==ActionType.SHOW.getIndex()){
                    System.out.println("Enter id: ");
                    int id= scanner.nextInt();
                    ConsoleDisplay.printContact(phoneBook.get(id));
                }
                else if(input==ActionType.FIND.getIndex()) {
                    System.out.println("Enter number:1-find by first letter of name, 2-find by last four numbers of phone");
                    int opt=scanner.nextInt();
                    if(opt==1) {
                        System.out.println("Enter some first letters of name");
                        String name = scanner.next();
                        ArrayList<Contact> filteredContacts = phoneBook.find(name);
                        ConsoleDisplay.printContacts(filteredContacts);
                    }
                    if (opt==2){
                        System.out.println("Enter last four numbers of phone");
                        String ph = scanner.next();
                        ArrayList<Contact> filteredContacts = phoneBook.find(ph);
                        ConsoleDisplay.printContacts(filteredContacts);
                    }
                }
                else if(input == ActionType.SAVE.getIndex()){
                    FileController.saveToFile(phoneBook.getAllContact());;
                    System.out.println("Contact's has been saved");
                }
                else {
                    System.out.println("Looser! :D");
                    break;
                }
            }
        }
    }
}