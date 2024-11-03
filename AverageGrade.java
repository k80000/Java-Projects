import java.util.Scanner;

public class AverageGrade {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); // create a scanner to read input from the user
        System.out.println("Class size: "); // prompts the user to input the class size
        int students = sc.nextInt(); // stores the number of students
        int[] grades = new int[students]; // creates an array that holds each student's grades
        System.out.println("Entered grades: "); // prompts the user to enter the grades for each student
        for(int i = 0; i < students; i++){
            grades[i] = checkNumber(sc); // get and validate each student's grade, then stores in the array
        }
        double average = computeAverage(grades, 0, 0); // recursively calculates the average of the grades
        System.out.println("Class average: " + String.format("%.2f", average)); // prints average, formatted to 2 decimals
    }
    public static double computeAverage(int[] grades, int index, int sum){ // recursive method to calculate the average
        if(index == grades.length){ // base case
            return (double) sum / grades.length; // calculates the average by dividing the sum by the number of grades
        }
        return computeAverage(grades, index + 1, sum + grades[index]); // recursive case adds the current grade to the sum and moves on to the next grade

    }
    public static int checkNumber(Scanner sc){ // method to validate the grades entered
        int num;
        while (true){
            if(sc.hasNextInt()){ // check if input is an int
                num = sc.nextInt(); // read the int
                if(num >= 0 && num <= 100){ // method to validate that the number is within 0-100
                    break; // if valid, exit the loop
                }
                else{
                    System.out.println("Invalid number, please enter a number between 0-100"); // prompts the user to re-enter a valid number
                }
            }
        }
        return num; // return the validated number

    }
}
