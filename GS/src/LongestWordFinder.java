import java.util.HashSet;
import java.util.Set;

public class LongestWordFinder {

    public static Set<String> longestWord(String letters, Set<String> dictionary) {
        Set<String> result = new HashSet<>();
        int maxLength = 0;
        for (String word : dictionary) {
            if (canFormWord(word, letters)) {
                if (word.length() > maxLength) {
                    result.clear();
                    result.add(word);
                } else if (word.length() == maxLength) {
                    result.add(word);
                }
            }
        }


        return result;
    }

    //word ->to  letters ->"oet"
    private static boolean canFormWord(String word, String letters) {
        int[] charArr = new int[26];
        for (char c : letters.toCharArray()) {
            charArr[c - 'a']++;
        }
        for (char c : word.toCharArray()) {
            if (--charArr[c - 'a'] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String letters = "oet";
        Set<String> dictionary = new HashSet<>();
        dictionary.add("to");
        dictionary.add("toe");
        dictionary.add("toes");
        Set<String> result = longestWord(letters, dictionary);
        System.out.println(result); // Output: [toe]
    }
}



