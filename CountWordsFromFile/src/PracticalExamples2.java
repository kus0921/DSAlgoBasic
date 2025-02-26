import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

class PracticalExamples2 {
    public static void main(String[] args) {
        // basic functions  peek, limit, skip, filter, distinct, map, flatMap, boxed, sorted, count, min, max, forEach
//        int[] int1 = {1, 2, 2, 3, 4, 5, 5, 6};
//         OptionalInt maxElement = Arrays.stream(int1).distinct().max();
//        maxElement.ifPresent(System.out::println);
        int [] int1 = new int[]{12, 11, 13, 4, 15, 25, 6};
        List<Integer> sortedList = Arrays.stream(int1)
                .peek(System.out::println)
                .sorted() // as sorted() needs all the elements for sorting, all elements pass in one go through first peek
                .peek(System.out::println) // as toList() also needs all the elements to make a collection
                .boxed().toList();
        //sortedList.forEach(System.out::println);
    }
}