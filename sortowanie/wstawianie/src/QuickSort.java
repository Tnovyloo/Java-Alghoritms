import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort the left and right subarrays
            quickSort(arr, low, pivotIndex - 1);  // Left side of the pivot
            quickSort(arr, pivotIndex + 1, high); // Right side of the pivot
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        System.out.println("Pivot: " + pivot);

        int i = low - 1; // Pointer for the smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);

        return i + 1;
    }
    

    public static int[] swap(int[] tab, int one, int two) {
        int temp = tab[one];
        tab[one] = tab[two];
        tab[two] = temp;
        return tab;
    }

    
    public static void main(String[] args) {
        int[] array = {3, 2, 5, 0, 1, 8, 7, 6, 9, 4};

        quickSort(array, 0, array.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
