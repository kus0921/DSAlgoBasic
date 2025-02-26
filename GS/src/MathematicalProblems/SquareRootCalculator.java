package MathematicalProblems;

public class SquareRootCalculator {

    // Method to calculate square root using the Newton-Raphson method
    public static double calculateSquareRoot(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Square root of negative numbers is not real.");
        }

        // Initial guess
        double guess = number / 2;
        double tolerance = 1e-5;
       while((guess*guess-number)>tolerance)
        {
           guess=(guess+number/guess)/2;
       }
        return guess;
    }

    public static void main(String[] args) {
        // Test cases
        double number1 = 25;
        double number2 = 49;
        double number3 = 2;
        double number4 = -4;

        try {
            System.out.println("Square root of " + number1 + " is: " + calculateSquareRoot(number1));
            System.out.println("Square root of " + number2 + " is: " + calculateSquareRoot(number2));
            System.out.println("Square root of " + number3 + " is: " + calculateSquareRoot(number3));
            System.out.println("Square root of " + number4 + " is: " + calculateSquareRoot(number4));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Using Math.sqrt for comparison
        System.out.println("\nUsing Math.sqrt for comparison:");
        System.out.println("Square root of " + number1 + " is: " + Math.sqrt(number1));
        System.out.println("Square root of " + number2 + " is: " + Math.sqrt(number2));
        System.out.println("Square root of " + number3 + " is: " + Math.sqrt(number3));
    }
}
