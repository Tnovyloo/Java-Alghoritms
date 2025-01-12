import java.util.ArrayList;

public class App {

    public static void insertionSort(int[] arr) {
        // for (int i = 1; i < arr.length; i++) {
        //     int position = i;
        //     int value = arr[i];

        //     while (position > 0 && arr[position - 1] > value) {
        //         arr[position] = arr[position - 1];
        //         position --;
        //     }

        //     arr[position] = value;
        // }

        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int position = i;

            while (position > 0 && arr[position - 1] > value) {
                arr[position] = arr[position - 1];
                position--;
            }

            arr[position] = value;
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        

        int[] table = {2, 1, 50, 48, 30, 31, 93, 32, 102, 100, 192, 193, 190};

        insertionSort(table);

    }
}
