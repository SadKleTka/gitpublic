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
            System.out.println("If you want to edit some contacts write: \"edit\" ✏\uFE0F");
            System.out.println("If you want to remove some contacts write: \"remove\" ❌");
            System.out.println("If you want to exit from a phoneBook, please write: \"exit\" \uD83D\uDED1");
            String mainmenu = scan.nextLine();
            Set<String> setOfCommands = Set.of("find", "add", "list", "exit", "remove", "edit");
            if (setOfCommands.contains(mainmenu)) {
                switch (mainmenu) {
                    case "find":
                        findContact(phoneBook, scan);
                        break;

                    case "add":
                        addContact(phoneBook, scan);
                        break;

                    case "list":
                        listOfContacts(phoneBook, scan);
                        System.out.println(enterOneOption());
                        scan.nextLine();
                        break;

                    case "remove":
                        removeContacts(phoneBook, scan);
                        break;

                    case "edit":
                        editContacts(phoneBook, scan);
                        break;

                    case "exit":
                        System.exit(0);
                        break;
                }
            }
            else {
                System.out.println("There are no commands like that. Please press \"ENTER\" to return to Main menu");
                scan.nextLine();
            }
        }


    }

    public static void findContact(TreeMap<String, String> phoneBook, Scanner scan) {
        while (true) {
            System.out.println("🔍 Contact Search");
            System.out.println("\nEnter \"back\" to back in the main menu or \"exit\" to leave from the app");
            System.out.println("\nYou want to find a contact by name, or number? Enter \"name\", or \"number\"");
            String byWhat = scan.nextLine();
            if(byWhat.equalsIgnoreCase("back"))
                break;
            if(byWhat.equalsIgnoreCase("exit"))
                System.exit(0);
            if (byWhat.equalsIgnoreCase("name")) {
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
                System.out.println(enterTwoOptions());
                String stop = scan.nextLine();
                if (stop.equalsIgnoreCase("back"))
                    break;
            }
            else if (byWhat.equalsIgnoreCase("number")) {
                System.out.println("\n\uD83D\uDED1❗You have to write a number with code of country \"+996\" and 9 digits after it\uD83D\uDED1❗");
                    System.out.print("\nWrite a number of a contact: ");
                    String findByNumber = scan.nextLine();
                    if (findByNumber.matches("\\+996\\d{9}")) {
                        if (findByNumber.equalsIgnoreCase("back"))
                            break;
                        if (findByNumber.equalsIgnoreCase("exit"))
                            System.exit(0);
                        if (phoneBook.containsValue(findByNumber)) {
                            for (String name : phoneBook.keySet()) {
                                if (findByNumber.equals(phoneBook.get(name))) {
                                    System.out.println("=================================================================================================");
                                    System.out.println("Founded a contact: " + "\nName: " + name + "\nNumber: " + findByNumber);
                                    System.out.println("=================================================================================================");
                                }
                            }
                        } else {
                            System.out.println("‼\uFE0FThere are nobody with that number in your contacts‼\uFE0F");
                            System.out.println(enterTwoOptions());
                            String back = scan.nextLine();
                            if (back.equalsIgnoreCase("back"))
                                break;
                        }
                    }
            }

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
                System.out.println("Press \"ENTER\" to continue");
                scan.nextLine();
            } else {
                System.out.print("\nWrite number: ");
                String number = scan.nextLine();
                if (phoneBook.containsValue(number)) {
                    System.out.println("You already have a contact with that number‼\uFE0F");
                    System.out.println("Press \"ENTER\" to continue");
                    scan.nextLine();
                } else {
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
                    System.out.println(enterTwoOptions());
                    String stop = scan.nextLine();
                    if (stop.equalsIgnoreCase("back"))
                        break;
                }
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
                    System.out.println(enterTwoOptions());
                    String back = scan.nextLine();
                    if(back.equalsIgnoreCase("back"))
                    break;
                } else if (decision.equalsIgnoreCase("no")) {
                    System.out.println(enterOneOption());
                    scan.nextLine();
                    break;
                } else {
                    System.out.println("There are no commands like that.");
                    System.out.println(enterTwoOptions());
                    String enter = scan.nextLine();
                    if(enter.equalsIgnoreCase("back"))
                        break;
                }
            } else {
                System.out.println("❌ Contact not found.");
                System.out.println(enterTwoOptions());
                String returnAfterError = scan.nextLine();
                if (returnAfterError.equalsIgnoreCase("back"))
                    break;
            }
        }
    }

    public static void editContacts(TreeMap<String, String> phoneBook, Scanner scan) {
        while (true) {
            System.out.println("\n✏\uFE0FRedacting contacts");
            System.out.println("\nWrite \"back\" if you want to return in the Main menu");
            System.out.print("\n\nWrite a contact that you want to redact: ");
            String name = scan.nextLine();
            if (name.equalsIgnoreCase("back")) {
                break;
            }
            else {
                if (phoneBook.containsKey(name)) {
                    System.out.print("\nWrite new name for contact: ");
                    String newname = scan.nextLine();
                    if (newname.equalsIgnoreCase("back"))
                        break;
                    else {
                        if (phoneBook.containsKey(newname)) {
                            System.out.println("This name has been already added to contacts.");
                            System.out.println(enterTwoOptions());
                            String action = scan.nextLine();
                            if (action.equalsIgnoreCase("back"))
                                break;
                            if (action.isEmpty())
                                continue;
                        }
                    }
                    System.out.print("\nWrite new number for contact: ");
                    String newnumber = scan.nextLine();
                    if (newnumber.equalsIgnoreCase("back"))
                        break;
                    else {
                        if (!phoneBook.containsValue(newnumber)) {
                            if (newnumber.matches("\\+996\\d{9}")) {
                                phoneBook.remove(name);
                                phoneBook.put(newname, newnumber);
                                System.out.println("You have successfully edited a contact: ");
                                System.out.println("\n=================================================================================================");
                                System.out.println("\nName: " + newname + "\t Number: " + phoneBook.get(newname));
                                System.out.println("\n=================================================================================================");
                                System.out.println("Do you want to see new list of contacts? Print \"yes\" or \"no\"");
                                String decision = scan.nextLine();
                                if (decision.equalsIgnoreCase("yes")) {
                                    listOfContacts(phoneBook, scan);
                                    System.out.println(enterTwoOptions());
                                } else if (decision.equalsIgnoreCase("no")) {
                                    System.out.println(enterOneOption());
                                    break;
                                } else {
                                    System.out.println("Invalid code press \"ENTER\" to continue");
                                }
                                String back = scan.nextLine();
                                if (back.equalsIgnoreCase("back"))
                                    break;
                            } else {
                                String function1 = enterTwoOptions();
                                System.out.println("Invalid type of number." + " " + function1);
                                String action = scan.nextLine();
                                if (action.equalsIgnoreCase("back"))
                                    break;
                            }
                        } else {
                            System.out.println("This number had been already used in some contact‼\uFE0F");
                            System.out.println(enterTwoOptions());
                            String back = scan.nextLine();
                            if (back.equalsIgnoreCase("back"))
                                break;
                        }
                    }
                } else {
                    String function2 = enterTwoOptions();
                    System.out.println("There are no contacts with that name." + " " + function2);
                    String back = scan.nextLine();
                    if (back.equalsIgnoreCase("back"))
                        break;
                }
            }
        }

    }

    public static String enterTwoOptions() {
        return "Press \"ENTER\" to continue, or enter \"back\" to return in the Main menu";
    }
    public static String enterOneOption() {
        return "Press \"ENTER\" to return in the main menu";
    }

}








































































