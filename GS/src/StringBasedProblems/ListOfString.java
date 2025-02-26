package StringBasedProblems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListOfString {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("baba");
        strings.add("aai");
        strings.add("cat");
        strings.add("elephant");
        strings.add("dog");

        Collections.sort(strings);
        System.out.println(strings);
    }
}
