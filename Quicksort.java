import java.util.Arrays;
import java.util.Scanner;

public class Quicksort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your array size: ");
        int n = sc.nextInt();
        System.out.println("Enter your array elements: ");
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quicksort(arr, 0, n - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    static void quicksort(int arr[], int start, int end) {
        if(start >= end) return; // Fix base case

        int pivotIndex = partition(arr, start, end);
        quicksort(arr, start, pivotIndex - 1);
        quicksort(arr, pivotIndex + 1, end);
    }

    static int partition(int arr[], int start, int end) {
        int pivot = arr[start];
        int count = 0;

        // Count elements <= pivot
        for(int i = start + 1; i <= end; i++) {
            if(arr[i] <= pivot) count++;
        }

        int pivotIndex = start + count;

        // Swap pivot to its correct position
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[start];
        arr[start] = temp;

        // Arrange elements around pivot
        int i = start, j = end;
        while(i < pivotIndex && j > pivotIndex) {
            while(arr[i] <= pivot) i++;
            while(arr[j] > pivot) j--;
            if(i < pivotIndex && j > pivotIndex) {
                // Swap out-of-place elements
                int temp2 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp2;
                i++;
                j--;
            }
        }

        return pivotIndex;
    }
}