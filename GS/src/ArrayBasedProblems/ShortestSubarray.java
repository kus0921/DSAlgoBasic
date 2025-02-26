package ArrayBasedProblems;

public class ShortestSubarray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int k1 = 6;
        System.out.println(subArrayExceedsSum(arr1, k1)); // Output: 2

        int[] arr2 = {1, 2, 3, 4};
        int k2 = -1;
        System.out.println(subArrayExceedsSum(arr2, k2)); // Output: 4 (array length)
    }

    private static int subArrayExceedsSum(int[] arr, int target)
    {
        if (target < 0) {
            return arr.length; // Edge case: If target is negative, return array length
        }
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum >= target && left < arr.length) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

}


//Problem Statement:
//Your task is ultimately to implement a function that takes in an array and a integer.
//You want to return the *LENGTH* of the shortest subarray whose sum is at least the integer,
//and -1 if no such sum exists.
//
//Signature:
//
//public static int subArrayExceedsSum(int arr[], int target) {
//}
//
//Test Cases:
//      Input:[1,2,3,4,] , k=6
//     Output :2
//
//     Input:[1,2,3,4,] , k=-1
//     Output :12


//for (int right = 0; right < arr.length; right++) {
//            sum += arr[right];
//            while (sum >= target && left < arr.length) {
//                minLength = Math.min(minLength, (right - left + 1));
//                sum = sum - arr[left];
//                left++;
//            }