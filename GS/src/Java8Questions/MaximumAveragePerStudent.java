package Java8Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumAveragePerStudent {
    public static void main(String[] args) {
        String[][] arr = {
                {"Bobby", "87"},
                {"Charles", "100"},
                {"Eric", "64"},
                {"Charles", "22"}
        };
        Map<String, List<Integer>> scores = new HashMap<>();
        Map<String, Double> resultMap = new HashMap<>();
        for (String[] a : arr) {
            String name = a[0];
            int marks = Integer.parseInt(a[1]);
        scores.putIfAbsent(name,new ArrayList<>());
        scores.get(name).add(marks);
        }
        double result =Double.MIN_VALUE;
        for(Map.Entry<String,List<Integer>> entry:scores.entrySet())
        {

            double average = entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0);
            resultMap.put(entry.getKey(),average);
        }

        //System.out.println(result);
        resultMap.forEach((s, aDouble) -> System.out.println(s+":"+aDouble));

    }

}