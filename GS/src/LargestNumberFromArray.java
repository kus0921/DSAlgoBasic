import java.util.Arrays;
import java.util.stream.Stream;

public class LargestNumberFromArray {

    public static void main(String[] args)
    {
        int arr[] = {1, 34, 3, 98, 9, 76, 45, 4};
        Arrays.stream(arr)
                .mapToObj(i -> i + "")
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .reduce((a, b) -> a + b)
                .ifPresent(System.out::println);

    }
}
