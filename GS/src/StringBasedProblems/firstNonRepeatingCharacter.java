package StringBasedProblems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class firstNonRepeatingCharacter extends RuntimeException {
    String string;

    public static void main(String[] args) {
        String s = "aaebbgcc";
        Map<Character, Long> characterLongMap = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        Optional<Map.Entry<Character, Long>> c = characterLongMap.entrySet().stream()
                .filter(characterLongEntry -> characterLongEntry.getValue()==1).findFirst();

    }
}
