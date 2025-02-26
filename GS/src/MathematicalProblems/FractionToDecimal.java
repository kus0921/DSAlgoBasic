package MathematicalProblems;

import java.util.HashMap;
//Implement the method provided numerator and denominator will return a string representing fraction's decimal
// form. Some fractions in decimal form have cyclic decimal points
public class FractionToDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero.");
        }

        StringBuilder result = new StringBuilder();

        // Check if the result is negative
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Convert both numbers to positive long values to handle edge cases
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Append the integer part
        result.append(num / den);

        // Check for no remainder
        long remainder = num % den;
        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");

        // Map to store remainders and their positions in the result
        HashMap<Long, Integer> remainderMap = new HashMap<>();
        while (remainder != 0) {
            // If the remainder has been seen before, it's a repeating cycle
            if (remainderMap.containsKey(remainder)) {
                int start = remainderMap.get(remainder);
                result.insert(start, "(");
                result.append(")");
                break;
            }

            // Store the remainder with its corresponding position
            remainderMap.put(remainder, result.length());

            // Multiply remainder by 10 and compute the next digit
            remainder *= 10;
            result.append(remainder / den);
            // Update the remainder
            remainder %= den;
        }

        return result.toString();
    }

    public static void main(String[] args) {
//        System.out.println(fractionToDecimal(1, 2)); // Output: "0.5"
//        System.out.println(fractionToDecimal(2, 3)); // Output: "0.(6)"
        System.out.println(fractionToDecimal(4, 333)); // Output: "0.(012)"
//        System.out.println(fractionToDecimal(1, 6)); // Output: "0.1(6)"
 //       System.out.println(fractionToDecimal(-50, 8)); // Output: "-6.25"
    }
}
