import java.util.*;

public class GPTlessons {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        HashMap<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Uzan", "+996504513053");
        phoneBook.put("Aman", "+996707754532");
        phoneBook.put("Daniel", "+996505053597");
        System.out.println("Press \"ENTER\" to get in phoneBook");
        scan.nextLine();
        System.out.println("Hello, this is phoneBook" + "\nPress \"ENTER\" to get in the Main menu" + "\nIf you want to exit from phoneBook write \"exit\"");
        String stop1 = scan.nextLine();
        if (stop1.equals("exit"))
            System.exit(0);
        while (true) {
            System.out.println("You are in the MainMenu of PhoneBook. What do you want to do?");
            System.out.println("If you want to add a new contact write: \"add\"");
            System.out.println("If you want to find a contact write: \"find\"");
            System.out.println("If you want to see a list of contacts write: \"list\"");
            System.out.println("If you want to exit from a phoneBook, please write: \"exit\"");
            String mainmenu = scan.nextLine();
            if (!mainmenu.equals("find") && !mainmenu.equals("add") && !mainmenu.equals("list") && !mainmenu.equals("exit")) {
                System.out.println("There are no commands like that. Please press \"ENTER\" to return to Main menu");
                scan.nextLine();
            }
            switch (mainmenu) {
                case "find":
                    FindContact(phoneBook, scan);
                    break;

                case "add":
                    AddContact(phoneBook, scan);
                    break;

                case "list":
                    ListOfContacts(phoneBook, scan);
                    break;

                case "exit":
                    System.exit(0);
            }
        }


    }

    public static void FindContact(HashMap<String, String> phoneBook, Scanner scan) {
        while (true) {
            System.out.println("\n🔍 Contact Search");
            System.out.print("\nWrite who's number you wanna find: ");
            String find = scan.nextLine();
            if (phoneBook.containsKey(find)) {
                System.out.println("=================================================================================================");
                System.out.println("Founded a contact: " + "\nName: " + find + "\nNumber: " + phoneBook.get(find));
                System.out.println("=================================================================================================");
            } else {
                System.out.println("There are nobody with that name in your contacts.");
            }
            System.out.println("If you want to return to the Main menu from searching contacts write \"back\". If you want to continue press \"ENTER\"");
            String stop = scan.nextLine();
            if (stop.equals("back"))
                break;
        }
    }

    public static void AddContact(HashMap<String, String> phoneBook, Scanner scan) {
        while (true) {
            System.out.println("\n➕ Add New Contact");
            System.out.print("\nWrite name: ");
            String name = scan.nextLine();
            if (phoneBook.containsKey(name)) {
                System.out.println("You already have a contact with that name. Press \"ENTER\" to continue.");
                scan.nextLine();
            } else {
                System.out.print("\nWrite number: ");
                String number = scan.nextLine();
                if (!number.matches("\\+996\\d{9}")) {
                    System.out.println("That is invalid type of number. Press \"ENTER\" to continue.");
                    scan.nextLine();
                } else {
                    phoneBook.put(name, number);
                    System.out.println("=================================================================================================");
                    System.out.println("You have successfully added a new contact:\nName: " + name + "\nNumber: " + number);
                    System.out.println("=================================================================================================");
                    System.out.println("If you want to return to the Main menu from adding a contact write \"back\". If you want to continue adding a contacts press \"ENTER\"");
                    String stop = scan.nextLine();
                    if (stop.equals("back"))
                        break;
                }
            }
        }
    }

    public static void ListOfContacts(HashMap<String, String> phoneBook, Scanner scan) {
        System.out.println("\n📋 Contact List:");
        System.out.println("\n=================================================================================================");
        for (String name : phoneBook.keySet()) {
            System.out.println("Name: " + name + "\t Number: " + phoneBook.get(name));
        }
        System.out.println("=================================================================================================");
        System.out.println("Press \"ENTER\" to return to the Main menu");
        scan.nextLine();
    }

}








































































