import java.util.Scanner; 

public class PrintReverse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // create a scanner to read input from the user
        String input; // declares a variable to hold the user's input
        String again = "Y"; // initialize a variable to repeat

        while(again.equals("Y")){ // loop as long as the user wants to try again

            System.out.print("Entered String: "); // prompts the user to enter a string
            input = sc.nextLine(); // read the string
            System.out.print("Reversed string: "); // print a label for the reversed string output
            printCharsReverse(input); // calls the method to print the string in reverse
            System.out.print("\nTry Again(Y/N): "); // asks the user if they want to try again \n makes it show up on a new line
            again = sc.nextLine(); // holds the user's input to try again or not
        }
    }

    public static void printCharsReverse(String str) { // method to print characters of input string in reverse
        if(str.length() == 0) // base case
            return; // if string is empty, ends the loop

        printCharsReverse(str.substring(1)); // recursive case to process the string excluding the first character
        System.out.print(str.charAt(0)); // print the first character after the rest of the string has been reversed
    }
}