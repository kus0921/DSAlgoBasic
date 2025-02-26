public class RotatedSortedArraySearch {
    public static void main(String[] args) {
        RotatedSortedArraySearch searcher = new RotatedSortedArraySearch();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 8;
        System.out.println(searcher.searchRotatedArray(nums, target)); // Output: 4
    }

    int searchRotatedArray(int[] arr, int target) {
        if (arr == null) return -1;
        int low = 0;
        int high = arr.length-1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            if (arr[low] < arr[mid])
            {
                if (  target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= arr[high]) {
                    low=mid + 1;
                }else
                {
                  high=mid - 1;
                }

            }
        }
        return -1;

    }


    int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) return mid;
            if (nums[low] < nums[mid]) { // to check which half is sorted
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
