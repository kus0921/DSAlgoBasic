package javastreamsSession3;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// agbt -> american express global business travels.
public class AGBTInterviewProblems {
    public static void main(String[] args)
    {
       /* *//*
        Q1. remove duplicates from string and return in the same order
        *//*
        String input = "slkdflksdnvkvlkdjlksdfdf";

        // 1
        StringBuilder builder = new StringBuilder();
        input.chars().distinct().forEach(t -> builder.append((char) t));
        String result = builder.toString();

        // 2
        result = Arrays.stream(input.split("")).distinct().collect(Collectors.joining());
        result = Arrays.stream(input.split("")).distinct().reduce("", (a, b) -> a + b);
        result = Arrays.stream(input.split("")).distinct().reduce((a, b) -> a + b).get();

      
        *//*
        Q3. Given a sentence find the word that has the 2nd (Nth) highest length.
        Note : skip(n) is used to skip first n stream objects
        *//*
        s = "I am interested123455 to grow in my organization";
        String secondHighest = Arrays.stream(s.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().get();

        *//*
        Q4. Find the length of the longest word
        *//*
        s = "I am interested123455 to grow in my organization";
        // 1 mx
        int lengthOfLongestWord = Arrays.stream(s.split(" ")).mapToInt(String::length).max().getAsInt();

        // 2 mp


        *//*
        Q6. Given a sentence, find the number of occurrence of each word
        *//*
        String sentence = "the quick brown fox jumps right over the little lazy dog";
        Map<String, Long> wordToCount = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // if we want to count all the character count in given sentence;
        Map<Character, Long> charToLong = sentence.
                chars().mapToObj(t -> (char) t).filter(t -> t != ' ')
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        *//*
        Q7. Given a word, find the occurrence of each character
        *//*
        input = "slkjdflksdjf";
        Map<Character, Long> characterToCount = input.chars().mapToObj(t -> (char) t)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        *//*
         * Q8. Given a string, find the words with the maximum number of vowels.
         * Solution : except for vowels, remove all characters from string in filter
         * *//*
        int maxVowelCount = 2;
        // String sentence = "the quick brown fox jumps right over the little lazy dog";
        *//* the -> e
           quick -> ui
           brown -> o
           fox -> o
         *//*

        // find word with max vowel count
        String vowelRegex = "[^aeiouAEIOU]";
        List<String> vowelWord = Arrays.stream(sentence.split(" "))
                .filter(t -> t.replaceAll(vowelRegex, "").length() == maxVowelCount)
                .collect(Collectors.toList());

        // group words according to their vowel count

        // group words according to their vowel count removing duplicates

        *//*
         * Q9. Given a list of integers, divide into two lists; one having even numbers and other having odd numbers.
         * *//*
        List<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Map<Boolean, List<Integer>> booleanListMap = numberList.stream().collect(Collectors.partitioningBy(t -> t % 2 == 0));
        Map<Boolean, Set<Integer>> booleanSetMap = numberList.stream().collect(Collectors.partitioningBy(t -> t % 2 == 0, Collectors.toSet()));

        *//*
         * Q10. Given an array of integers (2,34,54,23,33,20,59,11,19,37) group the numbers by the range they belong to.
         * The put should be {0=[2], 50=[54,59], 20=[23,20], 10=[11,19], 30=[34,33,37]}
         *
         *
         * *//*
        List<Integer> list1 = new ArrayList<>(Arrays.asList(2, 34, 54, 23, 33, 20, 59, 11, 19, 37));
        Map<Integer, List<Integer>> rangeToList = list1.stream().collect(Collectors.groupingBy(t -> t / 10 * 10));

        *//*
         * Q11. Given a List of Strings  ["as", "123", "32", "2as"], create another Integer list that contains only integers. The output should be: List<Integer> iList = [123,32]
         * *//*
        List<String> stringList = new ArrayList<>(Arrays.asList("as", "123", "32", "2as", ""));
        String numberOnlyRegex = "[0-9]+"; // + indicates all characters from string should be only from 0 - 9 and should be zero or more
        List<String> numberList1 = stringList.stream().filter(t -> t.matches(numberOnlyRegex)).collect(Collectors.toList());

        *//*
        * Q12. Given a numeric array , rearrange the elements to form a smallest possible value and largest possible value
               input is: int arr[] = {1, 34, 3, 98, 9, 76, 45, 4};
               output  : 133444576998
        * *//*
        int arr[] = {1, 34, 3, 32, 98, 9, 76, 45, 4};
        String smallestPossibleNumber = Arrays.stream(arr).mapToObj(t -> t + "").sorted((a, b) -> (a + b).compareTo(b + a)).collect(Collectors.joining());

        String largestPossibleNumber = Arrays.stream(arr).mapToObj(t -> t + "").sorted((a, b) -> (b + a).compareTo(a + b)).collect(Collectors.joining());
        ;

        *//*
         * Q13. Given a String, find the first non-repeated character. (Google interview)
         * *//*
        String str = "slkdjfirrjes";
        // s -> str.indexOf(s) = 0 == str.lastIndexOf(s) = 11
        // l -> 1 == 1
        String firstNonRepeated = str.chars().mapToObj(t -> String.valueOf((char) t)).filter(t -> str.indexOf(t) == str.lastIndexOf(t)).findFirst().get();

        *//*
         * Q8. Reverse a string with special characters and special character position shouldn't be changed.
         * Example : input  = "a-Bb--e"
         *           output = "e-bB--a"
         * *//*
        // 1
        input = "a-Bb--e";
        AGBTInterviewProblems.reverseStringWithoutReversingSpecialCharacters1(input);

       *//* // 2
        AGBTInterviewProblems.reverseStringWithoutReversingSpecialCharacters2(input);

        // 3
        String reversedString = reverseNothingButLetters(input);*//*

    }

    private static String reverseNothingButLetters(String s) {
        int n = s.length();
        int startToEnd = 0;
        int endToStart = n - 1;
        StringBuilder builder = new StringBuilder();
        Predicate<Character> insideBoundary = t -> (t >= 'A' && t <= 'Z') || (t >= 'a' && t <= 'z');


        while (startToEnd < n && endToStart >= 0) {
            if (insideBoundary.test(s.charAt(startToEnd)) && insideBoundary.test(s.charAt(endToStart))) {
                builder.append(s.charAt(endToStart));
                endToStart--;
                startToEnd++;
            } else if (!insideBoundary.test(s.charAt(startToEnd))) {
                builder.append(s.charAt(startToEnd));
                startToEnd++;
            } else {
                endToStart--;
            }
        }

        return builder.toString();
    }
*/
        AGBTInterviewProblems.reverseStringWithoutReversingSpecialCharacters1(input);
    }


    static void reverseStringWithoutReversingSpecialCharacters2(String input) {
        String specialCharsRegex = "[^0-9a-zA-Z]";
        String[] inputArray = input.split("");
        StringBuilder reverseBuilder = new StringBuilder(input.replaceAll(specialCharsRegex, "")).reverse();
        IntStream.range(0, input.length())   
		.filter(i -> specialCharsRegex.matches(inputArray[i]))     //filter indexes of special characters only from input String
		.forEach(i -> reverseBuilder.insert(i, inputArray[i]));   // insert special characters at indexes filtered in previous step
    }

  



    }
}
