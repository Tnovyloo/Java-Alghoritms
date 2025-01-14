import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] arr) {

        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int leftIndex = 0, rightIndex = 0, insertIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                merged[insertIndex] = left[leftIndex];
                leftIndex++;
            } else {
                merged[insertIndex] = right[rightIndex];
                rightIndex++;
            }

            insertIndex++;
        }

        while (leftIndex < left.length) {
            merged[insertIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            merged[insertIndex++] = right[rightIndex++];
        }

        return merged;
    }
    
    public static void main(String[] args) {
        int[] table = {3, 2, 5, 0, 1, 8, 7, 6, 9, 4};
        table = mergeSort(table);
        for(int e : table) {
            System.out.println(e);
        }
    }
}
