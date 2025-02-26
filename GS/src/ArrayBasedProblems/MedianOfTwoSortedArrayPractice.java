package ArrayBasedProblems;


public class MedianOfTwoSortedArrayPractice {
    public static double findMedianSotedArrays1(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        if (m > n) {
            findMedianSotedArrays1(b, a);
        }
        int left = 0, right = m;
        int median = (m + n + 1) / 2;
        while (left <= right) {
            int partitionA = (left + right) / 2;
            int partitionB = (median - partitionA);
            int l1 = (partitionA == 0) ? Integer.MIN_VALUE : a[partitionA - 1];
            int l2 = (partitionB == 0) ? Integer.MIN_VALUE : b[partitionB - 1];
            int r1 = (partitionA == m) ? Integer.MAX_VALUE : a[partitionA];
            int r2 = (partitionB == n) ? Integer.MAX_VALUE : b[partitionB];
//            if (partitionA > 0) {
//                l1 = a[partitionA - 1];
//            }
//            if (partitionB > 0) {
//                l2 = b[partitionB - 1];
//            }
//            if (partitionA < m) {
//                r1 = a[partitionA];
//            }
//            if (partitionB < n) {
//                r2 = a[partitionB];
//            }
            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 0) {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return (Math.max(l1, l2));
                }
            } else if (l1 > r2) {
                right = partitionA - 1;
            } else {
                left = partitionA + 1;
            }

        }
        throw new IllegalArgumentException("Arrays are not sorted");
    }

    public static void main(String[] args) {
        int[] Arr1 = {1, 3};
        int[] Arr2 = {2, 4};
        System.out.println("Median: " + findMedianSotedArrays1(Arr1, Arr2)); // Output: 2.5

        int[] Arr3 = {1, 3};
        int[] Arr4 = {2};
        System.out.println("Median: " + findMedianSotedArrays1(Arr3, Arr4)); // Output: 2.0
    }

}

