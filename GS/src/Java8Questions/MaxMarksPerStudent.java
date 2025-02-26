package Java8Questions;

import java.util.*;
import java.util.stream.Collectors;

public class MaxMarksPerStudent {
    public static void main(String[] args) {
        // Sample input: Map of student names to a list of their marks
        Map<String, List<Integer>> studentMarks = new HashMap<>();
        studentMarks.put("Alice", Arrays.asList(78, 85, 90, 88));
        studentMarks.put("Bob", Arrays.asList(65, 75, 70, 60));
        studentMarks.put("Charlie", Arrays.asList(90, 95, 85, 100));

        studentMarks.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
                        stringListEntry -> stringListEntry.getValue().stream().max(Integer::compareTo).orElse(0)))
                .forEach((s, integer) -> System.out.println(s + ":" + integer));
    }

}
