import java.util.HashMap;

public class FractionToDecimal {
    public static void main(String[] args) {
        // Example input
        int numerator = 1;
        int denominator = 3;

        // Perform division and format result
        String result = fractionToDecimal(numerator, denominator);
        System.out.println("Result: " + result);
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        // Handle edge cases
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        // Handle negative numbers
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Work with positive values for simplicity
        long num = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);

        // Append the integer part
        result.append(num / denom);
        num %= denom;

        if (num == 0) {
            return result.toString(); // No fractional part
        }

        // Append the decimal point
        result.append(".");

        // Map to store remainders and their positions
        HashMap<Long, Integer> remainderMap = new HashMap<>();
        StringBuilder fractionalPart = new StringBuilder();

        while (num != 0) {
            // If this remainder has been seen before, it's the start of a repeating sequence
            if (remainderMap.containsKey(num)) {
                int startIndex = remainderMap.get(num);
                fractionalPart.insert(startIndex, "(");
                fractionalPart.append(")");
                result.append(fractionalPart);
                return result.toString();
            }

            // Store the current remainder and its position
            remainderMap.put(num, fractionalPart.length());

            // Perform division for the next digit
            num *= 10;
            fractionalPart.append(num / denom);
            num %= denom;
        }

        // If no repeating sequence is found, append the fractional part as is
        result.append(fractionalPart);
        return result.toString();
    }
}
