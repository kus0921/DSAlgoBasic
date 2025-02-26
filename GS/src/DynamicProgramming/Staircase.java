package DynamicProgramming;

public class Staircase {
    public static int countSteps(int steps) {
        if (steps <0) {
            return 0;
        }
        if (steps == 0) return 1;
        int[] dp = new int[steps + 1];
        dp[0] = 1;
        if (steps >= 1) dp[1] = 1;
        if (steps >= 2) dp[2] = 2;
        for (int i = 3; i <=steps; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[steps];
    }

    public static void main(String[]args)

    {
        System.out.println(countSteps(3));  // Output: 4
        System.out.println(countSteps(1));  // Output: 1
        System.out.println(countSteps(2));  // Output: 2
        System.out.println(countSteps(10)); // Output: 274
        System.out.println(countSteps(-5)); // Output: 0
    }
}