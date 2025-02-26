import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class MostFrequentWord {

    public static void getMostFrequentWord() {

        List<String> sentences = Arrays.asList(
                "The quick brown fox jumps over the lazy dog",
                "A quick brown fox jumps over the lazy dog and the lazy cat",
                "The lazy dog sleeps"
        );

        String mostFrequentWord = sentences.stream()
                // Split each sentence into words and flatten into a single stream of words
                .flatMap(sentence -> Arrays.stream(sentence.toLowerCase().split("\\s+")))
                // Collect word frequencies into a Map
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                // Find the word with the maximum frequency
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No words found");

        System.out.println("Most Frequent Word: " + mostFrequentWord);
    }

    public static void main(String[] args) {
//        Given a list of strings representing sentences, write a Java program to find the most common word in the sentences. Ignore case sensitivity and punctuation. If there are multiple words with the same maximum frequency, return any of them.
//
//
//        Input:
//
//        "The quick brown fox jumps over the lazy dog.",
//                "A quick brown fox jumps over the lazy dog and the lazy cat.",
//                "The lazy dog sleeps."
        getMostFrequentWord();
//        List<String> sentences = Arrays.asList(
//                "The quick brown fox jumps over the lazy dog",
//                "A quick brown fox jumps over the lazy dog and the lazy cat",
//                "The lazy dog sleeps"
//        );
//
//        Map<String, Long> frequencyMap = new HashMap<>();
//        IntStream.range(0, 3)
//                .forEach(
//                        i -> frequencyMap.putAll(
//                                Arrays.stream(sentences.get(i)
//                                                .split(" "))
//                                        .map(String::toLowerCase)
//                                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())))
//                );
//
//        frequencyMap.entrySet().forEach(System.out::println);


    }

}

