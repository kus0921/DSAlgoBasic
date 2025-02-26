import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Questions {
    static void reverseStringWithoutReversingSpecialCharacters2(String input) {
        String specialCharsRegex = "[^0-9a-zA-Z]";
        StringBuilder reverseInputWithoutSpecialCharacters = new StringBuilder(input.replaceAll(specialCharsRegex, "")).reverse();
         String[] inputArray=input.split("");
        IntStream.range(0,input.length())
                .filter(i->inputArray[i].matches(specialCharsRegex))
                        .forEach(i->reverseInputWithoutSpecialCharacters.insert(i,inputArray[i]));
       System.out.println(reverseInputWithoutSpecialCharacters);
    }
    public static void main(String[] args) {
        reverseStringWithoutReversingSpecialCharacters2("$a@b!c&");
//        //   Q1. remove duplicates from string and return in the same order
//        String input = "slkdflksdnvkvlkdjlksdfdf";
//        StringBuffer sb = new StringBuffer();
//        input.chars().distinct().forEach(i->sb.append((char)i));
//       // String output = Arrays.stream(input.split("")).distinct().reduce("",(a,b) ->a+b);
//        String output = Arrays.stream(input.split("")).distinct().collect(Collectors.joining());
//        //System.out.println(output);
//        System.out.println(sb);


// Q3. Given a sentence find the word that has the 2nd (Nth) highest length.

        String s = "I am interested123455 to grow in my organization";

//        Arrays.stream(s.split(" ")).distinct()
//                .sorted(Comparator.comparing(String::length).reversed())
//                .skip(1).findFirst()
//                .ifPresent(System.out::println);

        // Q4. Find the length of the longest word

        //   Arrays.stream(s.split(" ")).map(String::length).max(Integer::compareTo).ifPresent(System.out::println);


        // Q6. Given a sentence, find the number of occurrence of each word
        String sentence = "the quick brown fox jumps right over the little lazy dog";
//        Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((k, v) -> System.out.println(k + ":" + v));
        // if we want to count all the character count in given sentence;
        //Arrays.stream(sentence.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((k, v) -> System.out.println(k + ":" + v));


        /*
         * Q8. Given a string, find the words with the maximum number of vowels.
         * Solution : except for vowels, remove all characters from string in filter
         */
        String vowelRegex = "[^aeiouAEIOU]";
//        Arrays.stream(sentence.split(" ")).map(t->t.replaceAll(vowelRegex,""))//.forEach(System.out::println);
//                .peek(System.out::println).map(String::length).max(Comparator.naturalOrder()).ifPresent(System.out::println);
        //group words according to their vowel count
//        Map<Integer, List<String>> map = Arrays.stream(sentence.split(" "))
//                .collect(Collectors.groupingBy(t -> t.replaceAll(vowelRegex, "").length()));
//        map.forEach((k, v) -> System.out.println(k + ":" + v));

        //*  * Q9. Given a list of integers, divide into two lists; one having even numbers and other having odd numbers.
        //        List<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        //        Map<Boolean,List<Integer>> even =numberList.stream().collect(Collectors.partitioningBy(t->t%2==0));
        //        even.forEach((k,v)-> System.out.println(k+":"+v));

        // Q10. Given an array of integers (2,34,54,23,33,20,59,11,19,37) group the numbers by the range they belong to.
        //      * The put should be {0=[2], 50=[54,59], 20=[23,20], 10=[11,19], 30=[34,33,37]}
        List<Integer> list1 = new ArrayList<>(Arrays.asList(2, 34, 54, 23, 33, 20, 59, 11, 19, 37));
//        Map<Integer, List<Integer>> rangeToList = list1.stream().collect(Collectors.groupingBy(t -> t / 10*10));
//        rangeToList.forEach((integer, integers) -> System.out.println(integer+":"+integers));


//       Q12. Given a numeric array , rearrange the elements to form a smallest possible value and largest possible value
//        input is: int arr[] = {1, 34, 3, 98, 9, 76, 45, 4};
//        output  : 133444576998
//                * *//*
//        int arr[] = {1, 34, 3, 32, 98, 9, 76, 45, 4};
//        String smallestPossibleNumber = Arrays.stream(arr)
//                .mapToObj(t -> t + "")
//                .sorted((a, b) -> (a + b).compareTo(b + a))
//                .collect(Collectors.joining());
//
//        String largestPossibleNumber=Arrays.stream(arr)
//                .mapToObj(t -> t + "")
//                .sorted((a, b) -> (b+a).compareTo(a+b))
//                .collect(Collectors.joining());
//
//        System.out.println(smallestPossibleNumber);
//        System.out.println(largestPossibleNumber);

//        // Q13. Given a String, find the first non-repeated character. (Google interview)
//        String str = "slkdjfirrjes";
//        String sub = "";
//        String token = "";
//        List<String> tokenList = new ArrayList<>();
//
//        for (int i = 0; i < str.length() - 1; i++) {
//            token = String.valueOf(str.charAt(i));
//            if (tokenList.contains(token))
//                continue;
//            else
//                tokenList.add(token);
//            sub = str.substring(i + 1);
//            if (!sub.contains(token)) {
//                System.out.println(token);
//                break;
//            }

        //Given an int array move all the even numbers to the right.
       // Output is: int arr [] = { 1,2,3,4,5,6,7,8,9,10} -> Expected out put is : { 1,3,5,7,9,2,4,6,8,10}

//        Integer arr [] = { 1,2,3,4,5,6,7,8,9,10};
//        List<Integer> arrayList = Arrays.asList(arr);
//        arrayList.stream()
//                .collect(Collectors.partitioningBy(i->i%2==0))
//                .entrySet().stream().map(Map.Entry::getValue)
//                .flatMap(Collection::stream)
//                .forEach(System.out::println);

         s ="aabbbcccc";
         //given a string convert it to a2b3c4
        s.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .forEach(e->System.out.print(e.getKey().toString()+e.getValue()));

    }
}
