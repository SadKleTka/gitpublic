import java.util.*;

public class GPTlessons {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        TreeMap<String, String> phoneBook = new TreeMap<>();
        phoneBook.put("Uzan", "+996504513053");
        phoneBook.put("Aman", "+996707754532");
        phoneBook.put("Daniel", "+996505053597");
        System.out.println("Press \"ENTER\" to get in phoneBook");
        scan.nextLine();
        while (true) {
            System.out.println("\n📱 PHONEBOOK MENU");
            System.out.println("--------------------------");
            System.out.println("If you want to add a new contact write: \"add\" ➕");
            System.out.println("If you want to find a contact write: \"find\" 🔍");
            System.out.println("If you want to see a list of contacts write: \"list\" 📋");
            System.out.println("If you want to remove some contacts write: \"remove\" ❌");
            System.out.println("If you want to exit from a phoneBook, please write: \"exit\" \uD83D\uDED1");
            String mainmenu = scan.nextLine();
            if (!mainmenu.equals("find") && !mainmenu.equals("add") && !mainmenu.equals("list") && !mainmenu.equals("exit") && !mainmenu.equals("remove")) {
                System.out.println("There are no commands like that. Please press \"ENTER\" to return to Main menu");
                scan.nextLine();
            }
            switch (mainmenu) {
                case "find":
                    findContact(phoneBook, scan);
                    break;

                case "add":
                    addContact(phoneBook, scan);
                    break;

                case "list":
                    listOfContacts(phoneBook, scan);
                    System.out.println("Press \"ENTER\" to return to the Main menu");
                    scan.nextLine();
                    break;

                case "exit":
                    System.exit(0);

                case "remove":
                    removeContacts(phoneBook, scan);
                    break;
            }
        }


    }

    public static void findContact(TreeMap<String, String> phoneBook, Scanner scan) {
        while (true) {
            System.out.println("🔍 Contact Search");
            System.out.println("Enter \"back\" to back in the main menu or \"exit\" to leave from the app");
            System.out.print("\nWrite who's number you wanna find: ");
            String find = scan.nextLine();
            if (find.equalsIgnoreCase("back"))
                return;
            if (find.equalsIgnoreCase("exit"))
                System.exit(0);
                if (phoneBook.containsKey(find)) {
                    System.out.println("=================================================================================================");
                    System.out.println("Founded a contact: " + "\nName: " + find + "\nNumber: " + phoneBook.get(find));
                    System.out.println("=================================================================================================");
                } else {
                    System.out.println("There are nobody with that name in your contacts.");
                }
                System.out.println("If you want to return to the Main menu from searching contacts write \"back\". If you want to continue press \"ENTER\"");
                String stop = scan.nextLine();
                if (stop.equalsIgnoreCase("back"))
                    break;
            }

    }

    public static void addContact(TreeMap<String, String> phoneBook, Scanner scan) {
        while (true) {
            System.out.println("\n➕ Add New Contact");
            System.out.println("\nIf you want to back to the Main menu write \"back\"");
            System.out.print("\nWrite name: ");
            String name = scan.nextLine();
            if (name.isEmpty()) {
                System.out.println("\uD83D\uDED1❗This field cannot be empty‼\uFE0F");
                continue;
            }
            if (name.equalsIgnoreCase("back"))
                return;
            if (phoneBook.containsKey(name)) {
                System.out.println("You already have a contact with that name\uD83D\uDEA8");
            } else {
                System.out.print("\nWrite number: ");
                String number = scan.nextLine();
                if (number.equalsIgnoreCase("back"))
                    return;
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
                    if (stop.equalsIgnoreCase("back"))
                        break;
                }
            }
        }
    }

    public static void listOfContacts(TreeMap<String, String> phoneBook, Scanner scan) {
        System.out.println("\n📋 Contact List:");
        System.out.println("\n=================================================================================================");
        for (String name : phoneBook.keySet()) {
            System.out.println("Name: " + name + "\t Number: " + phoneBook.get(name));
        }
        System.out.println("=================================================================================================");

    }
    public static void removeContacts(TreeMap<String, String> phoneBook, Scanner scan) {
        while(true) {
            System.out.println("\nRemove contact ❌");
            System.out.println("\nWrite \"back\" if you want to return in the Main menu");
            System.out.print("\n\nWrite name: ");
            String name = scan.nextLine();
            if(name.equalsIgnoreCase("back"))
                break;
            if (phoneBook.containsKey(name)) {
                phoneBook.remove(name);
                System.out.println("✅ Contact removed.");
                System.out.println("Do you want to see new list of contacts? Print \"yes\" or \"no\"");
                String decision = scan.nextLine();
                if (decision.equalsIgnoreCase("yes")) {
                    listOfContacts(phoneBook, scan);
                    System.out.println("Press \"ENTER\" to return to continue removing contacts, or write \"back\" to return in the Main menu");
                    String back = scan.nextLine();
                    if(back.equalsIgnoreCase("back"))
                    break;
                } else if (decision.equalsIgnoreCase("no")) {
                    System.out.println("Press \"ENTER\" to return in the main menu");
                    scan.nextLine();
                    break;
                } else {
                    System.out.println("There are no commands like that.");
                    System.out.println("Press \"ENTER\" to continue removing contacts, or enter \"back\" to return in the Main menu");
                    String enter = scan.nextLine();
                    if(enter.equalsIgnoreCase("back"))
                        break;
                }
            } else {
                System.out.println("❌ Contact not found.");
                System.out.println("Press \"ENTER\" to continue removing contacts, or enter \"back\" to return in the Main menu");
                String returnAfterError = scan.nextLine();
                if(returnAfterError.equalsIgnoreCase("back"))
                    break;
            }
        }
    }

}








































































