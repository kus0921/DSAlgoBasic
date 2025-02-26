package DynamicProgramming;

public class RockCollector {
    public static Integer optimalPath(Integer[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Create a DP table to store the max rocks collectible at each point
        int[][] dp = new int[rows][cols];
        
        // Initialize the bottom-left corner (starting point in So_Cal)
        dp[rows - 1][0] = grid[rows - 1][0];
        
        // Fill the last row (can only move right)
        for (int col = 1; col < cols; col++) {
            dp[rows - 1][col] = dp[rows - 1][col - 1] + grid[rows - 1][col];
        }
        
        // Fill the remaining cells (moving up or from left)
        for (int row = rows - 2; row >= 0; row--) {
            // First column (can only move up)
            dp[row][0] = dp[row + 1][0] + grid[row][0];
            
            // Fill the rest of the row
            for (int col = 1; col < cols; col++) {
                dp[row][col] = Math.max(dp[row + 1][col], dp[row][col - 1]) + grid[row][col];
            }
        }
        
        // The top-right cell contains the maximum rocks collectible
        return dp[0][cols - 1];
    }
    
    public static void main(String[] args) {
        Integer[][] grid = {
            {0, 0, 0, 0, 5},
            {0, 1, 1, 1, 0},
            {2, 0, 0, 0, 0}
        };
        
        System.out.println("Maximum rocks collected: " + optimalPath(grid)); // Output: 10
    }
}
