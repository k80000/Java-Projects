import java.util.*;

public class bucketSorting { // defines the class bucketSorting
    public static void bucketSort(int[] arr) { // takes an array of integers and sorts it using bucket sort
        if (arr.length <= 0) { // checks if the array is empty, and if so, returns without sorting
            return;
        }

        int maxValue = Arrays.stream(arr).max().getAsInt(); // finds the max value in the array
        int minValue = Arrays.stream(arr).min().getAsInt(); // finds the min value in the array

        int bucketCount = (maxValue - minValue) / arr.length + 1; // calculates the number of buckets needed based on the range of values in the array
        List<List<Integer>> buckets = new ArrayList<>(bucketCount); // creates a list of empty buckets

        for (int i = 0; i < bucketCount; i++) { // initializes each bucket as an empty ArrayList
            buckets.add(new ArrayList<>());
        }
        for (int num : arr) { // distributes the elements of the array into the appropriate buckets
            int bucketIndex = (num - minValue) / arr.length; // calculates which bucket the number should go into
            buckets.get(bucketIndex).add(num); // adds the number to the corresponding bucket
        }
        int currentIndex = 0; // initializes an index to keep track of the position in the original array
        for (List<Integer> bucket : buckets) { // iterates through each bucket
            Collections.sort(bucket); // sorts the individual bucket
            for (int num : bucket) { // moves the sorted numbers from the bucket back into the original array
                arr[currentIndex++] = num;
            }
        }
    }
    public static void main(String[] args) { // main method
        Scanner sc = new Scanner(System.in); // creates a scanner object to read user input
        System.out.println("Enter a series of integers separated by spaces: "); // prompts the user to enter a series of integers
        String input = sc.nextLine(); // reads the user's input

        String[] inputstring = input.split("\\s+"); // splits the input string by spaces and stores it in an array of strings
        int[] arr = new int[inputstring.length]; // initializes an array of integrs with the same length as the input string array

        for (int i = 0; i < inputstring.length; i++) { // converts each string in the input array to an integer and stores it in the integer array
            arr[i] = Integer.parseInt(inputstring[i]);
        }
        System.out.println("Unsorted Array: "); // prints the unsorted array
        bucketSort(arr); // calls the bucketSort method
        System.out.println("Sorted Array: " + Arrays.toString(arr)); // prints the sorted array
    }
}