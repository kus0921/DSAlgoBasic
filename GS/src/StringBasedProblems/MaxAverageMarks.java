package StringBasedProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxAverageMarks {

    public static void main(String[] args) {
        String[][] input = {{"Sarah", "91"}, {"Goldie", "92"}, {"Elaine", "93"}, {"Elaine", "95"}, {"Goldie", "94"}, {"Sarah", "93"}};
        System.out.println(bestAverageGrade(input)); // Output: 94
    }

    private static double bestAverageGrade(String[][] input) {
        Map<String, Double> avgDouble = Arrays.stream(input)
                .collect(Collectors.groupingBy(s -> s[0], Collectors.averagingInt(s -> Integer.parseInt(s[1]))));
       return avgDouble.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();

    }
}


