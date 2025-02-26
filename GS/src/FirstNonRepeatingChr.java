import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstNonRepeatingChr {
    public static char getFirstNonRepeatingCharacter(String word) {
        if (word == null) return 0;
        Map<Character, Integer> charMap = new HashMap<>();
//        for (char c : word.toCharArray()) {
//            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
//        }
//        for (char c : word.toCharArray())
//        {
//            if (charMap.get(c) == 1) {
//                return c;
//            }
//        }
        char[] chars = word.toCharArray();
      //  System.out.println(chars.length);
//        for(char c:chars){
//            System.out.println(c);
//        }
        Arrays.stream(word.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + ":" + value));

        return 0;
    }

    public static void main(String[] args) {
        getFirstNonRepeatingCharacter("apple");
    }

    @Test
    public void testFirstNonRepeatingChr() {
        System.out.println(getFirstNonRepeatingCharacter("apple"));
    }
}
