package StringBasedProblems;

public class ReverseString {

public static String reverseString(String input)
{
   //using for loop
//    StringBuilder result= new StringBuilder();
//    for(int i=input.length()-1;i>=0;i--){
//        result.append(input.charAt(i));
//    } return result.toString();
    //using while recusion
    if(input.isEmpty()){
        return input;
    }
    return reverseString(input.substring(1))+input.charAt(0);

}

    public static void main(String[] args) {
        System.out.println(reverseString("abcd"));
    }
}
