package ArrayBasedProblems;

public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {

        while (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            mergeArrays(arr, left, mid, right);
        }
    }

    public static void mergeArrays(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        for(int i = 0; i < n1; i++)
        {
            leftArray[i] = arr[left + i];
        }
        for(int j = 0; j < n2; j++)
        {
            rightArray[j] = arr[mid+1+j];
        }
        int k = left, i = 0, j = 0;
        while (i < n1 && j < n2)
        {
            if (leftArray[i] <= rightArray[j])
            {
                arr[k] = leftArray[i];
                i++;
            } else
            {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1)
        {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            arr[k] = rightArray[j];
            k++;
            j++;
        }
    }

    // Function to print an array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method to test Merge Sort
    public static void main(String[] args)
    {
        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("Original Array:");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("Sorted Array:");
        printArray(array);
    }
}

