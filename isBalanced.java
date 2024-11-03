public class isBalanced { // class to check if an expression is balanced in terms of parentheses/brackets
    static class Stack { // implements a stack data structure for storing characters
        private final char[] stackArray; // array to store characters in the stack
        private int top; // index to track the top of the stack
        private final int capacity; // maximum capacity of the stack

        public Stack(int capacity) { //initializes the stack with a given capacity
            this.capacity = capacity; // set stack capacity
            stackArray = new char[capacity]; // create an array to hold stack elements
            top = -1; // initialize the top of the stack to -1
        }
        public void push(char c) { // method to push a character onto the stack
            if (top == capacity - 1) { // checks if the stack is full
                System.out.println("Stack overflow"); // prints an error message if stack is full
                return; // exit witout pushing
            }
            stackArray[++top] = c; // increment top and add character to the stack
        }
        public char pop() { // method to pop a character from the stack
            if (isEmpty()) { // checks if the stack is empty
                System.out.println("Stack underflow"); // prints an error message if stack is empty
                return '\0'; // return a null character if there's nothing to pop
            }
            return stackArray[top--]; // return the top character and decrement the top index
        }
        public char peek() { // method to peek at the top character without popping it
            if (isEmpty()) { // check if the stack is empty
                return '\0'; // return a null character if the stack is empty
            }
            return stackArray[top]; // return the top character without removing it
        }
        public boolean isEmpty() { // method to check if the stack is empty
            return top == -1; // return true if top is -1, meaning the stack is empty
        }
    }
    public static boolean isBalanced(String expression) { // method to check if a given expression is balanced in terms of parentheses, braces, and brackets
        Stack stack = new Stack(expression.length()); // create a stack with a size equal to the length of the expression
        for (char c : expression.toCharArray()) { // loop through each character in the expression
            if (c == '(' || c == '{' || c == '[') { // if the character is an opening bracket, push it onto the stack
                stack.push(c);
            }
            else if (c == ')' || c == '}' || c == ']') { // if the character is a closing bracket, check for balance
                if (stack.isEmpty()) { // if the stack is empty when encountering a closing bracket, it's unbalanced
                    return false;
                }
                char top = stack.pop(); // pop the top of the stack for comparison
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) { // check if the popped character matches the closing bracket
                    return false; // if the brackets don't match, return false
                }
            }
        }
        return stack.isEmpty(); // if the stack is empty at the end, the expression is balanced; otherwise, it's not
    }
    public static void main(String[] args) { // main method to test the isBalanced method with various cases
        System.out.println(isBalanced("(())")); // test case 1: true
        System.out.println(isBalanced("{{[]}}")); // test case 2: true
        System.out.println(isBalanced("()[]{}")); // test case 3: true
        System.out.println(isBalanced("({[}")); // test case 4: false
    }
}