import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class testPalindrome { // class to test palindromes by word or character

    public static void main(String[] args) { // main method
        Scanner scanner = new Scanner(System.in); // scanner object to read user input
        int option = 0; // variable to store the user's input

        while (option != 3) { // loop until the user chooses to exit
            displayMenu(); // show the available options to the user
            option = scanner.nextInt(); // captures user input
            scanner.nextLine(); // handle leftover newline from nextint

            switch (option) { // process the selected menu option
                case 1:
                    System.out.println("You selected: Option 1"); // acknowledges option 1
                    testCharacterPalindrome(scanner); // test character-based palindrome
                    break;
                case 2:
                    System.out.println("You selected: Option 2"); // acknowledges option 2
                    testWordPalindrome(scanner); // test word-based palindrome
                    break;
                case 3:
                    System.out.println("Exiting program..."); // notifies the user that the program will exit
                    break;
                default:
                    System.out.println("Invalid option. Please try again."); // handles invalid input
            }
        }

        scanner.close(); // closes the scanner
    }

    private static void displayMenu() { // displays the main menu options to the user
        System.out.println("\n-----MAIN MENU-----"); // prints the header for the menu
        System.out.println("1. Test character-by-character palindrome"); // option 1
        System.out.println("2. Test word-by-word palindrome"); // option 2
        System.out.println("3. Exit program"); // option 3
        System.out.print("Enter option number: "); // prompts user to enter their choice
    }

    private static void testCharacterPalindrome(Scanner scanner) { // method to test if the input string is a character-by-character palindrome
        System.out.print("Enter a string: "); // asks the user to enter a string
        String input = scanner.nextLine(); // stores the input string
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // remove non-alphanumeric characters and convert to lowercase

        Queue<Character> forwardQueue = new LinkedList<>(); // queue to store characters in the order they appear
        Queue<Character> backwardQueue = new LinkedList<>(); // queue to store characters in the reverse order

        for (int i = 0; i < cleanedInput.length(); i++) { // loop through the cleaned input string to populate both queues
            forwardQueue.add(cleanedInput.charAt(i)); // add each character to forwardQueue
            backwardQueue.add(cleanedInput.charAt(cleanedInput.length() - 1 - i)); // add characters in reverse order to backwardQueue
        }

        boolean isPalindrome = true; // variable to store if the input is a palindrome
        while (!forwardQueue.isEmpty()) { // compare elements from both queues to check for palindrome
            if (!forwardQueue.poll().equals(backwardQueue.poll())) { // if elements differ, its not a palindrome
                isPalindrome = false; // set flag to false if mismatch occurs
                break; // exits the loop
            }
        }

        System.out.println("You entered: " + input); // display the original user input
        System.out.println("Judgement: " + (isPalindrome ? "Palindrome" : "Not Palindrome")); // output whether the input is a palindrome or not
    }

    private static void testWordPalindrome(Scanner scanner) { // method to test if the input string is a word-by-word palindrome
        System.out.print("Enter a string: "); // asks the user to enter a string
        String input = scanner.nextLine(); // stores the input string
        String[] words = input.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase().split("\\s+"); // clean input and split into words

        Queue<String> forwardQueue = new LinkedList<>(); // queue to store words in the order they appear
        Queue<String> backwardQueue = new LinkedList<>(); // queue to store words in the reverse order they appear

        for (int i = 0; i < words.length; i++) { // loop through the array of words to populate both queues
            forwardQueue.add(words[i]); // add words in original order to forwardQueue
            backwardQueue.add(words[words.length - 1 - i]); // add words in reverse order to backwardQueue
        }

        boolean isPalindrome = true; // variable to store if the input is a palindrome
        while (!forwardQueue.isEmpty()) { // compare elements from both queues to check for palindrome
            if (!forwardQueue.poll().equals(backwardQueue.poll())) { // if elements, differ, its not a palindrome
                isPalindrome = false; // set flag to false if mismatch occurs
                break; // exit the loop
            }
        }

        System.out.println("You entered: " + input); // display the original user input
        System.out.println("Judgment: " + (isPalindrome ? "Palindrome" : "Not Palindrome")); // output whether the input is a palindrome or not
    }
}