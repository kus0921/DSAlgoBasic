package ArrayBasedProblems;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        
        if (m > n) {
            return findMedianSortedArrays(B, A);
        }
        
        int low = 0, high = m, medianPos = (m + n + 1) / 2;
        
        while (low <= high) {
            int partitionA = (low + high) / 2;
            int partitionB = medianPos - partitionA;
            
            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : A[partitionA - 1];
            int minRightA = (partitionA == m) ? Integer.MAX_VALUE : A[partitionA];
            
            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : B[partitionB - 1];
            int minRightB = (partitionB == n) ? Integer.MAX_VALUE : B[partitionB];
            
            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                high = partitionA - 1;
            } else {
                low = partitionA + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted properly");
    }
    
    public static void main(String[] args) {
        int[] Arr1 = {1, 3};
        int[] Arr2 = {2, 4};
        System.out.println("Median: " + findMedianSortedArrays(Arr1, Arr2)); // Output: 2.5
        
        int[] Arr3 = {1, 3};
        int[] Arr4 = {2};
        System.out.println("Median: " + findMedianSortedArrays(Arr3, Arr4)); // Output: 2.0
    }
}
