import java.util.Scanner;

public class mergeSorting { // defines the mergeSorting class
    public static void merge(int[] arr, int left, int mid, int right) { // method to merge two halves of the array

        int n1 = mid - left + 1; // calculates size of the left subarray
        int n2 = right - mid; // calculates the size of the right subarray

        // creates temp arrays for the two subarrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) { // copies data to the left subarray
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) { // copies data to the right subarray
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0; // initial indexes of the right, left, and merged arrays
        int k = left;

        while (i < n1 && j < n2) { // merges the two subarrays into the original array in sorted order
            if (leftArray[i] <= rightArray[j]) { // if the element in the left subarray is smaller or equal
                arr[k] = leftArray[i]; // place the smaller element in the merged array
                i++; // move to the next element in the left subarray
            } else {
                arr[k] = rightArray[j]; // place the smaller element from the right subarray in the merged array
                j++; // move to the next element in the right subarray
            }
            k++; // move to the next position in the merged array
        }

        while (i < n1) { // copies any remaining elements from the left subarray
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) { // copies any remaining elements from the right subarray
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) { // recursively splits the array and sorts each half
        if (left < right) { // base condition to stop recursion
            int mid = (left + right) / 2; // finds the middle point to divide the array

            mergeSort(arr, left, mid); // recursively sorts the first half of the array
            mergeSort(arr, mid + 1, right); // recursively sorts the second half of the array
            merge(arr, left, mid, right); // merges the sorted halves
        }
    }

    public static void main(String[] args) { // main method
        Scanner sc = new Scanner(System.in); // creates a scanner object to read user input
        System.out.println("Enter a series of integers separated by spaces: "); // prompts the user for input
        String input = sc.nextLine(); // reads the user's input

        String[] inputStrings = input.split("\\s+"); // splits the input string into an array of strings, separated by spaces

        int[] arr = new int[inputStrings.length]; // initializes an integer array to store the converted input numbers
        for (int i = 0; i < inputStrings.length; i++) { // converts each input string to an integer
            if (!inputStrings[i].isEmpty()) {
                arr[i] = Integer.parseInt(inputStrings[i]);
            }
        }

        System.out.println("Original array: "); // prints the unsorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        mergeSort(arr, 0, arr.length - 1); // calls the mergeSort method to sort the array

        System.out.println("Sorted array: "); // prints the sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
