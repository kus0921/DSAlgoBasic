package ArrayBasedProblems;

import java.util.Arrays;

public class KLargestElementsQuickSelect {
    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 8, 25, 15};
        int k = 3;

        int[] kLargest = quickSelect(arr, arr.length - k, 0, arr.length - 1);
        
        System.out.println("K Largest Elements: " + Arrays.toString(kLargest));
    }

    public static int[] quickSelect(int[] arr, int kIndex, int left, int right) {
        if (left <= right) {
            int pivotIndex = partition(arr, left, right);
            if (pivotIndex == kIndex) {
                return Arrays.copyOfRange(arr, pivotIndex, arr.length);
            } else if (pivotIndex > kIndex) {
                return quickSelect(arr, kIndex, left, pivotIndex - 1);
            } else {
                return quickSelect(arr, kIndex, pivotIndex + 1, right);
            }
        }
        return new int[0];
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right], i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
