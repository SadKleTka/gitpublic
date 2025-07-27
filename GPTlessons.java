import java.util.*;

public class GPTlessons {
    public static void main(String[] args) {
        /*
        Scanner scan = new Scanner(System.in);
        Random ran = new Random();
        System.out.println("Guess a number from 1 to 100");
        int number = ran.nextInt(100);
        int guess;
        int attempts = 0;
        do {
            System.out.print("Write your guess: ");
            guess = scan.nextInt();
            attempts++;
        if (guess < number) {
            System.out.println("Wrong, your guess is lower than the number");
        } else if (guess > number) {
            System.out.println("Wrong, your guess is higher than the number");
        } else {
            System.out.println("You are right the number was: " + number);
            System.out.println("You guessed in " + attempts + " attempts");
        }
    } while (guess != number); */

/*
        Scanner scan = new Scanner(System.in);
        HashMap<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Uzan", "+996504513053");
        phoneBook.put("Aman", "+996707754532");
        phoneBook.put("Daniel", "+996505053597");
        System.out.println("Press \"ENTER\" to get in phoneBook");
            String stop15 = scan.nextLine();
            while (!stop15.equals("exit")) {
                System.out.println("Hello, this is phoneBook. Do you want to get in the Main menu? Press \"ENTER\" if you want,if not write \"exit\"");
                String stop1 = scan.nextLine();
                if (stop1.equals("exit"))
                    System.exit(0);
                while (!stop1.equals("exit")) {
                    System.out.println("You are in the MainMenu of PhoneBook. What do you want to do?");
                    System.out.println("If you want to add a new contact write \"add\"");
                    System.out.println("If you want to find a contact write \"find\"");
                    System.out.println("If you want to see a list of contacts write \"list\"");
                    System.out.println("If you want to exit from a phoneBook, please write \"exit\"");
                    String mainmenu = scan.nextLine();
                    switch (mainmenu) {
                        case "find":
                            while (true) {
                                System.out.print("\nWrite who's number you wanna find: ");
                                String find = scan.nextLine();
                                if (phoneBook.containsKey(find)) {
                                    System.out.println("His number is: " + phoneBook.get(find));
                                } else {
                                    System.out.println("There are nobody with that name in your contacts.");
                                }
                                System.out.println("If you want to return to the Main menu from searching contacts write \"back\". If you want to continue press \"ENTER\"");
                                String stop = scan.nextLine();
                                if (stop.equals("back"))
                                    break;
                            }
                            break;

                        case "add":
                            while (true) {
                                System.out.print("\nWrite his name: ");
                                String name = scan.nextLine();
                                System.out.print("\nWrite his number: ");
                                String number = scan.nextLine();
                                phoneBook.put(name, number);
                                System.out.println("You have successfully added a new contact:\nName: " + name + "\nNumber: " + number);
                                System.out.println("If you want to return to the Main menu from adding a contact write \"back\". If you want to continue adding a contacts press \"ENTER\"");
                                String stop = scan.nextLine();
                                if (stop.equals("back"))
                                    break;
                            }
                            break;

                        case "list":
                            System.out.println("Here is a list of contacts: " + phoneBook.entrySet());
                            System.out.println("If you want to return to the Main menu from LIST write \"back\"");
                            String stop = scan.nextLine();
                            if (stop.equals("back"))
                                break;
                            break;
                        case "exit":
                            System.exit(0);
                    }
            }
        }
        
 */
    }
}









































































