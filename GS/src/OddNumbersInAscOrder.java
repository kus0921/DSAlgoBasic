import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OddNumbersInAscOrder {
    public static void main(String[] args) {
        IntStream.range(0,10).filter(n->n%2!=0)
                .boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
