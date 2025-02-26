package StringBasedProblems;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GroupOfAnagrams {

//    Given a list of words, group them by anagrams
//    Input: List of "cat", "dog", "god"
//    Output: A Set of Sets of anagrams: {{‘cat'}, {‘dog', ‘god'}}

    public static void getSetsOfAnagram(List<String> words) {
      Map<String,Set<String>> anagrams = new LinkedHashMap<>();
      for(String word:words){
          char[] chars = word.toCharArray();
          Arrays.sort(chars);
          anagrams.computeIfAbsent(Arrays.toString(chars), k->new HashSet<>()).add(word);
      }
      anagrams.entrySet().forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList(new String[]{"cat", "dog", "god","act"});
        getSetsOfAnagram(words);
    }
}


/// String sortedWord;
///        Map<String,Set<String>> wordAnagramGroupSet= new HashMap<>();
///         for(String word:words){
///             char[] arr=word.toCharArray();
///             Arrays.sort(arr);
///             sortedWord = Arrays.toString(arr);
///             wordAnagramGroupSet.computeIfAbsent(sortedWord,k->new HashSet<>()).add(word);
///        }
/// wordAnagramGroupSet.entrySet().forEach(System.out::println);