import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByNameAndAverageMarks {


    public static void method(){
        String name;
        Integer marks;
        List<Integer> markList=new ArrayList<>();
        String[][] scores = {
                {"Alice", "85"},
                {"Bob", "90"},
                {"Alice", "95"},
                {"Bob", "80"},
                {"Charlie", "100"}
        };
        Map<String, List<Integer>> studentMarksMap=new HashMap<>();
        for(String[] student:scores){
             name =student[0];
             marks= Integer.valueOf(student[1]);
             studentMarksMap.computeIfAbsent(name,k->new ArrayList<>()).add(marks);

        }

       // studentMarksMap.entrySet().forEach((e)-> System.out.println(e.getKey()+":"+e.getValue()));
       // studentMarksMap.entrySet().stream().collect(Collectors.groupingBy(Function.identity()));
    }
    @Test
    public void testMethod()
    {
        method();
    }
}
