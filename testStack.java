import java.util.Scanner;
import java.util.Stack;

public class testStack {
    public static void topToBottom(Stack<Integer> stack) { // Displays stack contents from top to bottom without changing the stack
        Stack<Integer> tempStack = (Stack<Integer>) stack.clone(); // Clone the stack to avoid modification
        System.out.print("Stack content: ");
        while (!tempStack.isEmpty()) { // while the cloned stack is not empty
            System.out.print(tempStack.pop() + " "); // print and pop the elements from the cloned stack
        }
        tempStack = (Stack<Integer>) stack.clone(); // clone the stack again for further use
        System.out.println(); // move to a new line
        System.out.print("Function output: ");
        while (!tempStack.isEmpty()) { // repeat the loop to print again for function output
            System.out.print(tempStack.pop() + " ");
        }
        System.out.println(); // end with a new line
    }
    public static void bottomToTop(Stack<Double> stack) { // Displays stack contents from bottom to top without changing the stack
        Stack<Double> tempStack = (Stack<Double>) stack.clone(); // Clone the stack to avoid modification
        Stack<Double> reversedStack = new Stack<>(); // create a new stack to store reversed elements
        System.out.print("Stack content: ");
        while (!tempStack.isEmpty()) { // while cloned stack has elements
            System.out.print(tempStack.pop() + " "); // print and pop elements from the top of the stack
        }
        tempStack = (Stack<Double>) stack.clone(); // clone the original stack again
        while (!tempStack.isEmpty()) { // loop to reverse the stack
            reversedStack.push(tempStack.pop()); // pop elements from tempStack and push them onto reverseStack
        }
        System.out.println(); // new line
        System.out.print("Function output: ");
        while (!reversedStack.isEmpty()) { // print the reversed stack
            System.out.print(reversedStack.pop() + " "); // pop and print elements from reversedStack
        }
        System.out.println(); // new line at the end
    }
    public static Stack<String> flipStack(Stack<String> stack) { // flips the stack content and returns the flipped stack
        Stack<String> tempStack = new Stack<>(); // create a temporary stack to hold flipped elements
        while (!stack.isEmpty()) { // while the original stack is not empty
            tempStack.push(stack.pop()); // pop elements from original stack and push onto the tempoary stack
        }
        return tempStack; // return the flipped stack
    }
    public static boolean searchStack(Stack<Integer> stack, int target) { // searches the stack for a target value without changing the stack
        Stack<Integer> tempStack = (Stack<Integer>) stack.clone(); // Clone the stack to avoid modification
        while (!tempStack.isEmpty()) { // while the cloned stack has elements
            if (tempStack.pop() == target) { // if the popped element matches the target
                return true; // return true if target is found
            }
        }
        return false; // return false if target is not found in the stack
    }
    public static void topToBottomDouble(Stack<Double> stack) { // displays the stack contents for a double stack from top to bottom
        Stack<Double> tempStack = (Stack<Double>) stack.clone(); // clone the stack to avoid modifications
        while (!tempStack.isEmpty()) { // while cloned stack is not empty
            System.out.print(tempStack.pop() + " "); // pop and print each element from top to bottom
        }
        System.out.println(); // new line
    }
    public static void displayMenu() { // Utility function to display the main menu
        System.out.println("\n-----MAIN MENU-----"); // print main menu header
        System.out.println("1. Test function topToBottom with integer stack"); // prints option 1
        System.out.println("2. Test function bottomToTop with double stack"); // prints option 2
        System.out.println("3. Test function flipStack with string stack"); // prints option 3
        System.out.println("4. Test function searchStack with integer stack"); // prints option 4
        System.out.println("5. Exit program"); // prints option 5
        System.out.println("Please enter your choice: "); // prompt the user to enter their choice
    }
    public static void main(String[] args) { // main method to test the program
        Scanner scanner = new Scanner(System.in); // initialize the scanner to read user input
        int option; // variable to store user's choice

        do { // loop until the user chooses to exit
            displayMenu(); // display the main menu
            option = scanner.nextInt(); // read the user's menu choice
            scanner.nextLine();  // clear the newline character
            switch (option) { // switch based on user's choice
                case 1: // test topToBottom
                    System.out.println("\nTesting function topToBottom:");
                    System.out.print("Enter integers to push onto the stack (space-separated): ");
                    String[] intInputs = scanner.nextLine().split(" "); // read integers input
                    Stack<Integer> intStack = new Stack<>(); // create a new integer stack
                    for (String s : intInputs) { // loop through input strings
                        intStack.push(Integer.parseInt(s)); // convert string to integer and push onto the stack
                    }
                    topToBottom(intStack); // call the topToBottom function
                    break;
                case 2: // test bottomToTop
                    System.out.println("\nTesting function bottomToTop:");
                    System.out.print("Enter doubles to push onto the stack (space-separated): ");
                    String[] doubleInputs = scanner.nextLine().split(" "); // read doubles input
                    Stack<Double> doubleStack = new Stack<>(); // create a new double stack
                    for (String s : doubleInputs) { // loop through input strings
                        doubleStack.push(Double.parseDouble(s)); // convert string to double and push onto the stack
                    }
                    bottomToTop(doubleStack); // call the bottomToTop function
                    break;
                case 3: // test flipStack
                    System.out.println("\nTesting function flipStack:");
                    System.out.print("Enter strings to push onto the stack (space-separated): ");
                    String[] strInputs = scanner.nextLine().split(" "); // read strings input
                    Stack<String> strStack = new Stack<>(); // create a new string stack
                    for (String s : strInputs) { // loops through input strings
                        strStack.push(s); // push each string onto the stack
                    }
                    System.out.print("Stack content before calling flipStack: ");
                    for (String s : strStack) { // print stack contents before flipping
                        System.out.print(s + " ");
                    }
                    System.out.println();
                    strStack = flipStack(strStack); // call the flipStack function
                    System.out.print("Stack content after calling flipStack: ");
                    for (String s : strStack) { // print stack contents after flipping
                        System.out.print(s + " ");
                    }
                    System.out.println();
                    break;
                case 4: // test searchStack
                    System.out.println("\nTesting function searchStack:");
                    System.out.print("Enter integers to push onto the stack (space-separated): ");
                    String[] intInputsSearch = scanner.nextLine().split(" "); // read integers input for search
                    Stack<Integer> searchIntStack = new Stack<>(); // create a new integer stack
                    for (String s : intInputsSearch) { // loop through input strings
                        searchIntStack.push(Integer.parseInt(s)); // convert string to integer and push onto the stack
                    }
                    System.out.print("Stack content: ");
                    for (int i : searchIntStack) { // print stack contents
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    System.out.print("Enter target value to search for: ");
                    int target = scanner.nextInt(); // read the target value to search for
                    boolean found = searchStack(searchIntStack, target); // call searchStack function
                    System.out.println("Function output: " + found);  // print whether the target was found or not
                    break;
                case 5: // exit
                    System.out.println("Exiting program."); // inform the user that the program is exiting
                    break;
                default: // invalid menu option
                    System.out.println("Invalid option. Please try again."); // inform the user if they entered an invalid option
            }
        } while (option != 5); // continue looping until option 5 is selected
        scanner.close(); // close the scanner
    }
}
