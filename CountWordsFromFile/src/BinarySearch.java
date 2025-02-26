public class BinarySearch {
    public static int searchNumber(int n, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 6, 7, 8, 1, 2, 3};
        int[] arr = {5, 1, 2, 3, 4};
        int n = 1;
        System.out.println(searchNumber(1, arr1));
    }

}
