import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FracToDec {
    public static String fractionToDeimal(long num, long deno) {
        if (deno == 0) throw new ArithmeticException("Invalid operation");
        StringBuilder result = new StringBuilder();
        if ((num < 0) ^ (deno < 0)) {
            result.append("-");
        }
        num = Math.abs(num);
        deno = Math.abs(deno);
        result.append(num / deno);
        Long remainder = num % deno;
        if (remainder == 0) return result.toString();
        result.append(".");
        Map<Long, Integer> remainderKeyMap = new LinkedHashMap<>();
        while (remainder != 0) {
            if (remainderKeyMap.containsKey(remainder)) {
                Integer start = remainderKeyMap.get(remainder);
                result.insert(start, "(");
                result.append(")");
                break;
            }
            remainderKeyMap.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / deno);
            remainder = remainder % deno;


        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDeimal(10, 3));
        System.out.println(fractionToDeimal(22, 7));
        System.out.println(fractionToDeimal(23, -7));
    }


    //if (deno == 0) throw new ArithmeticException("Err");
    //        StringBuilder result = new StringBuilder();
    //        if ((num < 0) ^ (deno < 0)) {
    //            result.append("-");
    //        }
    //        num = Math.abs(num);
    //        deno = Math.abs(deno);
    //        result.append(num / deno);
    //        long remainder = num % deno;
    //        if (remainder == 0) return result.toString();
    //        result.append(".");
    //        Map<Long, Integer> remainderKeymap = new HashMap<>();
    //        while (remainder != 0)
    //        {
    //            if (remainderKeymap.containsKey(remainder))
    //            {
    //                int start = remainderKeymap.get(remainder);
    //                result.insert(start, "(");
    //                result.append(")");
    //                break;
    //            }
    //            remainderKeymap.put(remainder, result.length());
    //            remainder *= 10;
    //            result.append(remainder / deno);
    //            remainder = remainder % deno;
    //        }
}


