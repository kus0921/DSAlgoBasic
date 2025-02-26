public class CycleLengthFinder {

    public static int findCycleLength(int[] arr, int startIndex) {
        if (arr == null || startIndex < 0 || startIndex >= arr.length)
            return -1;
        int slow = startIndex;
        int fast = startIndex;
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
            if (fast < 0 || fast >= arr.length || arr[fast] < 0 || arr[fast] >= arr.length) return -1;
        } while (slow != fast);
        int cycleLength = 0;
        int current = slow;
        do {
            slow = arr[slow];
            cycleLength++;
        } while (current != slow);
        return cycleLength;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 0}; // Cycle: 1 -> 2 -> 0 -> 1
        int startIndex1 = 0;
        System.out.println(findCycleLength(arr1, startIndex1)); // Output: 3

        int[] arr2 = {1, 2, 3, 4, 5, 6, 3}; // Cycle: 3 -> 4 -> 5 -> 6 -> 3
        int startIndex2 = 0;
        System.out.println(findCycleLength(arr2, startIndex2)); // Output: 4

        int[] arr3 = {1, 2, 3, 4, 5, 6, 7}; // No cycle
        int startIndex3 = 0;
        System.out.println(findCycleLength(arr3, startIndex3)); // Output: -1
    }
}


//if (arr == null || arr.length == 0 || startIndex < 0 || startIndex >= arr.length) {
//            return -1; // Invalid input
//        }
//
//        int slow = startIndex;
//        int fast = startIndex;
//
//        // Step 1: Detect a cycle using Floyd's algorithm
//        do {
//            slow = arr[slow]; // Move slow by one step
//            fast = arr[arr[fast]]; // Move fast by two steps
//
//            if (fast < 0 || fast >= arr.length || arr[fast] < 0 || arr[fast] >= arr.length) {
//                return -1; // No cycle, out of bounds
//            }
//        } while (slow != fast);
//
//        // Step 2: Find the cycle length
//        int cycleLength = 0;
//        int current = slow;
//
//        do {
//            current = arr[current];
//            cycleLength++;
//        } while (current != slow);