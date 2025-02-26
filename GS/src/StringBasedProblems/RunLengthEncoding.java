package StringBasedProblems;

public class RunLengthEncoding {

    //Problem Statement-
    //For a string input the function returns output encoded as follows:
    //"a" -> "a1"
    //"aa" -> "a2"
    //"aabbb" -> "a2b3"
    //                "aabbbaa" -> "a2b3a2"
    //
    //Signature :
    //                    String rle(String input) {
    //                     }
    //
    //Test Case:
    //                 Input : aaabbbaad
    //                 Output: a3b3a2d1
    public static String rle(String input)
    {
        if(input==null||input.isBlank()){
            return "";
        }
    StringBuilder result= new StringBuilder();
        int n=input.length();
        char currChar=input.charAt(0);
        int currentLength=1;
        StringBuilder temp= new StringBuilder("" + currChar);

        for(int i=1;i<n;i++)
        {
            temp.append(currChar);
            if(input.charAt(i)==input.charAt(i-1)){
                currentLength++;
            }else{
                if(currentLength>2)
                {
                result.append(currChar).append(currentLength);
                }
                {result.append(temp); }
                currChar=input.charAt(i);
                currentLength=1;
                temp=new StringBuilder();

            }

        }
        result.append(currChar).append(currentLength);
        return  result.toString();
    }

    public static void main(String[] args) {
        System.out.println(rle("aabbbcccddee"));
        System.out.println(rle("aa"));
        System.out.println(rle("wwwwaaxxxyzzzkk"));
        System.out.println(rle(null));
        System.out.println(rle(""));
    }
}
