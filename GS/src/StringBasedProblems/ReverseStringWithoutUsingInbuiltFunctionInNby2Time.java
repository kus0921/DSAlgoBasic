package StringBasedProblems;

public class ReverseStringWithoutUsingInbuiltFunctionInNby2Time {

    static String reverseString(String s) {
        char[] chars = s.toCharArray();
        if (s == null || s.isBlank()) {
            return "";
        }
        int left = 0, right = chars.length-1;
        while (left < right) {
            char temp = chars[right];
            chars[right] = chars[left];
            chars[left] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Hello"));
    }
}
