import java.util.Arrays;

public class InserSort {

    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int position = i;
            int value = arr[i];

            while (position > 0 && arr[position - 1] > value) {
                arr[position] = arr[position - 1];
                position--;
            }

            arr[position] = value;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 0, 1, 8, 7, 6, 9, 4};

        insertSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
