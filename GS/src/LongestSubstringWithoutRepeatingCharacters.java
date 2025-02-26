import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {


    public static int lengthOfLongestSubstring(String s)
    {
        int start = 0, maxLength = 0;
        Set<Character> seen = new LinkedHashSet<>();
        for(int left=0;left<s.length();left++){
            char currChar= s.charAt(left);
            while(seen.contains(currChar)){
                seen.remove(s.charAt(start++));
            }
            seen.add(currChar);
            maxLength=Math.max(maxLength,seen.size());
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // Output: 3 ("abc")
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // Output: 1 ("b")
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // Output: 3 ("wke")
        System.out.println(lengthOfLongestSubstring(""));         // Output: 0
        System.out.println(lengthOfLongestSubstring("abcdef"));   // Output: 6 ("abcdef")
    }
}












// for (int end = 0; end < s.length(); end++) {
//            char currChar = s.charAt(end);
//            while (seen.contains(currChar)) {
//                seen.remove(s.charAt(start++));
//            }
//            seen.add(currChar);
//            maxLength = Math.max(maxLength, seen.size());
//        }