import java.util.Arrays;
import java.util.stream.IntStream;

public class reverseWithoutSpecialCharacterReversing {


    public static void reverseWithoutSpecialCharacterReversing(String word)
    {
        String pattern="[^a-zA-Z]";
       // String specialCharacters=word.replaceAll("[a-zA-z]","");
        StringBuilder wordWithoutSpecialCharacters=new StringBuilder(word.replaceAll(pattern,"")).reverse();
//        int i=0;
//         for(String s:word.split("")){
//             if(s.matches(pattern)){
//                 wordWithoutSpecialCharacters.insert(i,s);
//             }
//             i++;
//         }

         Arrays.stream(word.split(""))
                         .filter(s->s.matches(pattern))
                                 .forEach(s->wordWithoutSpecialCharacters.insert(word.indexOf(s),s));


        System.out.println(wordWithoutSpecialCharacters);
    }

    public static void main(String[] args) {
        String pattern="/gH?yZx";
        reverseWithoutSpecialCharacterReversing(pattern);
    }
}
