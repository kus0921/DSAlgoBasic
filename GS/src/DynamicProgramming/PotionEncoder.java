package DynamicProgramming;

public class PotionEncoder {
    private static Integer minimalSteps(String ingredients) {
        int n = ingredients.length();
        StringBuilder expanded = new StringBuilder();
        int startIndex = 0;
        for (int index = 1; index <= n; index++)
        {
            String pattern = ingredients.substring(startIndex, index);
            if ((index + startIndex) <= n) {
                if (pattern.equals(ingredients.substring(index, pattern.length()))) {
                    expanded.append(pattern);
                    expanded.append("*");
                    startIndex = index;
                }
            }
        }
        System.out.println(expanded);
        if (expanded.length() < n) return expanded.length();
        else
            return n;
    }
    public static void main(String[] args) {
        //  System.out.println(minimalSteps("ABCDABCE")); // Output: 8
        System.out.println(minimalSteps("ABCABCE")); // Output: 5
    }
}
