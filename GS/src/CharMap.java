import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharMap {
    public static void main(String[] args) {
        String[] input = new String[]{"dr apj abdul kalam",
                "pratibha patil",
                "pranab mukherjee",
                "ram nath kovind",
                "droupadi murmu"
        };
        Map<Character, Long> characterLongMap = new HashMap<>();
        Arrays.stream(input)
                .flatMap(s -> Arrays.asList(s.split("")).stream())
                // .forEach(System.out::println);
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).
                ifPresent(System.out::println);
    }
}
