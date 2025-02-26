package StringBasedProblems;

//Problem Statement-
//The sentence “The quick brown fox jumps over the lazy dog" contains
// every single letter in the alphabet. Such sentences are called pangrams.
// write a function findMissingLetters, which takes a String “sentence,
// and returns all the letters it is missing (which prevent it from
// being a pangram). You should ignore the case of the letters in sentence,
// and your return should be all lower case letters, in alphabetical order.
//                  you should also ignore all non US-ASCII characters.
//Signature:
//String findMissingLetters(String sentence) {
//Test Cases:
//Input: The slow purple oryx meanders past the quiescent canine
//Output: bfgjkvz
public class Pangrams {
    public static String isPangram(String sentence) {
        StringBuilder result = new StringBuilder();
        if (sentence == null || sentence.isBlank()) {
            return "Invalid input";
        }
        int[] alphabets = new int[26];
        for (int c : sentence.toLowerCase().trim().toCharArray())
        {if((c - 'a'>=0) && (c-'a'<26))
            alphabets[c - 'a']++;
        }
        for(int i=0;i<26;i++){
            if (alphabets[i] ==0)
            {
                result.append((char)(i+'a'));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(isPangram("The quick brown fox jumps over the lazy dog"));
        System.out.println(isPangram("The slow purple oryx meanders past the quiescent canine"));
    }
}
