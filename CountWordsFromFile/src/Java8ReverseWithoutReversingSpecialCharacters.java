import java.util.stream.IntStream;

public class Java8ReverseWithoutReversingSpecialCharacters {
    public static void reverse(String input){
        String[]inputArray=input.split("");
        String regex = "[^0-9a-zA-z]";
        StringBuilder reverseWithOutSpecialChars= new StringBuilder(input.replaceAll(regex, "")).reverse();
        IntStream.range(0,input.length())
                .filter(i->inputArray[i].matches(regex))
                .forEach(i->reverseWithOutSpecialChars.insert(i,inputArray[i]));
        System.out.println(reverseWithOutSpecialChars);
    }

    public static void main(String[] args) {
        reverse("$a#b!c");
    }
}
