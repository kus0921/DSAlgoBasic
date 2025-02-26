package StringBasedProblems;

public class LongestUniformString {
//    Problem Statement-
//    This method should return an integer array with two elements that correctly identifies the location of the longest
//    uniform substring within the input string. The first element of the array should be the starting index of the longest
//    substring and the second element should be the length.
//
//            input: “abbbccda" the longest uniform substring is “bbb” (which starts at index 1 and is 3 characters long.
//
//    Signature :
//    int[] getLongestUniformString(String input) {
//    }
//
//    Test Cases –
//    Input : aabbbbbCdAA
//    Output – [2,5]

    public static int[] getLongestUniformString(String input) {
        int maxStart = -1;
        int maxLength = 0;
        int currentStart = 0;
        int currentLength = 1;

        if (input == null || input.isBlank()) {
            return new int[]{-1, 0};
        }
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                currentLength++;
            } else
            {
                if (currentLength > maxLength)
                {
                    maxStart = currentStart;
                    maxLength = currentLength;
                }
                currentStart = i;
                currentLength=1;
            }
        }
        if (currentLength > maxLength)
        {
            maxStart = currentStart;
            maxLength = currentLength;
        }
        return new int[]{maxStart, maxLength};
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(java.util.Arrays.toString(getLongestUniformString("abbbccda"))); // [1, 3]
        System.out.println(java.util.Arrays.toString(getLongestUniformString("aabbbbbCdAA"))); // [2, 5]
        System.out.println(java.util.Arrays.toString(getLongestUniformString("abc"))); // [0, 1]
        System.out.println(java.util.Arrays.toString(getLongestUniformString(""))); // [-1, 0]
        System.out.println(java.util.Arrays.toString(getLongestUniformString("aaaaaa"))); // [0, 6]
    }
}
