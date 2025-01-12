import java.util.Arrays;

public class InserSort {
    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int position = i;

            while (position > 0 && arr[position - 1] > value) {
                arr[position] = arr[position - 1];
                position--;
            }

            arr[position] = value;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 0, 1, 8, 7, 6, 9, 4};

        insertSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
