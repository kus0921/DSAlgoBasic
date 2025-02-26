package MathematicalProblems;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {
    public static List<Long> primeFactorization(long number) {

        List<Long> primeFactors = new ArrayList<>();
        while (number % 2 == 0) {
            primeFactors.add(2L);
            number /= 2;
        }
        for (int i = 3; i * i < number; i += 2) {
            if (number % i == 0) {
                primeFactors.add((long) i);
            }
            number /= i;
        }
        if (number > 2)
            primeFactors.add(number);
       // primeFactors.forEach(System.out::println);
        return primeFactors;
    }

    public static void main(String[] args) {
        System.out.println("Prime factors of 6: " + primeFactorization(6)); // [2, 3]
        System.out.println("Prime factors of 5: " + primeFactorization(5)); // [5]
        System.out.println("Prime factors of 12: " + primeFactorization(12)); // [2, 2, 3]
        System.out.println("Prime factors of 30: " + primeFactorization(30)); // [2, 3, 5]
    }
}
