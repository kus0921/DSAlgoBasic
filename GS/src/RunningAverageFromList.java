import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class RunningAverageFromList {
//    calculate running average from list of integer.
//    using java 8 steam api.
//    i/p->(10, 20, 30, 40)
//    o/p->10,15,20,25


    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(10, 20, 30, 40);
        IntStream.range(0,arr.size())
                .forEach((i-> System.out.println(arr.subList(0,i+1)
                        .stream().mapToInt(Integer::intValue)
                        .average().orElse(0))));
    }
}
