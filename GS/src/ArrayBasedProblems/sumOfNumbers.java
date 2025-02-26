package ArrayBasedProblems;

import java.util.*;

/*
  1.Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
                Inputs : nums = [2,7,11,15]
        target : 9
 */
public class sumOfNumbers
{
    public static void pairSum(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] == target) {
                System.out.println("Indexes :" + left + "," + right);
                left++;
            } else if (arr[left] + arr[right] < target) {
                left++;
            } else {
                right--;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 6, 7, 7, 11, 15};
        pairSum(nums, 9);
        int[] arr = {4, 1, 3, 5, 2, 7, 8, 9, 6, 2, 4, 9};
        pairSumUnsortedWithDuplicates(arr, 10);
    }

    private static void pairSumUnsortedWithDuplicates(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        Map<Integer, Integer> pairs = new HashMap<>();

        for (int i : arr) {
            if (seen.contains(target - i)) {
                pairs.put(Math.min(i, target - i), Math.max(i, target - i));
            }
            seen.add(i);
        }

        for (Map.Entry entry : pairs.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}


