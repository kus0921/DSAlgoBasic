public class StringToIntConversion {
    public static int stringToInt(String s) {
        if (s == null && s.isEmpty()) {
            throw new NumberFormatException("Empty string");
        }
        int result = 0;
        boolean isNegative = false;
        char c = s.charAt(0);
        int startIndex = 0;
        if (c == '-') {
            isNegative = true;
            startIndex = 1;
        }
        for (int i = startIndex; i < s.length(); i++) {
            c=s.charAt(i);
            if (c < '0' || c > '9') {
                throw new NumberFormatException("Contains non numeric characters");
            }
            int digit = c - '0';
            result = result*10 + digit;
        }
        return isNegative ? -result : result;
    }


    public static void main(String[] args) {
        try {
            System.out.println(stringToInt("123"));       // Output: 123
            System.out.println(stringToInt("-456"));      // Output: -456
            System.out.println(stringToInt("0"));         // Output: 0
//            System.out.println(stringToInt("2147483647"));// Output: 2147483647 (Integer.MAX_VALUE)
//            System.out.println(stringToInt("-2147483648"));// Output: -2147483648 (Integer.MIN_VALUE)
            System.out.println(stringToInt("abc"));       // Throws NumberFormatException
        } catch (NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

