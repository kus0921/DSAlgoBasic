public class SnowCapture {

    public static int calculateTrappedSnow(int[] heights) {
        if (heights == null || heights.length < 3)
            return 0;
        int trappedSnow = 0;
        int length = heights.length;
        int[] rightMax = new int[length];
        int[] leftMax = new int[length];

        leftMax[0] = heights[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }
        rightMax[length - 1] = heights[length - 1];
        for (int i = length - 2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }

        for (int i = 0; i < length; i++) {
        trappedSnow+=Math.max(0, Math.min(rightMax[i],leftMax[i])-heights[i]);
        }

        return trappedSnow;
    }

    public static void main(String[] args) {
        // Example test case
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = calculateTrappedSnow(heights);
        System.out.println("Total trapped snow: " + result); // Output: 6
    }


    //  if (heights == null || heights.length < 3) {
    //            return 0; // No snow can be trapped
    //        }
    //
    //        int n = heights.length;
    //
    //        // Arrays to store the maximum height to the left and right of each position
    //        int[] leftMax = new int[n];
    //        int[] rightMax = new int[n];
    //
    //        // Fill the leftMax array
    //        leftMax[0] = heights[0];
    //        for (int i = 1; i < n; i++) {
    //            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
    //        }
    //
    //        // Fill the rightMax array
    //        rightMax[n - 1] = heights[n - 1];
    //        for (int i = n - 2; i >= 0; i--) {
    //            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
    //        }
    //
    //        // Calculate the total trapped snow
    //        int trappedSnow = 0;
    //        for (int i = 0; i < n; i++) {
    //            trappedSnow += Math.max(0, Math.min(leftMax[i], rightMax[i]) - heights[i]);
    //        }
}
