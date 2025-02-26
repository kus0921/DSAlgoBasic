import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PowerOf10 {

    public static boolean isPowerOfTen(int n) {
        if (n <= 0)
            return false;
        while (n%10==0) {
            n = n / 10;
        }
        return n==1;
    }

    public static void main(String[] args) {
        int k=50;
        System.out.println(k+" is power of 10 "+isPowerOfTen(k));
        System.out.println(isPowerOfTen(1));     // true (10^0)
        System.out.println(isPowerOfTen(10));    // true (10^1)
        System.out.println(isPowerOfTen(100));   // true (10^2)
        System.out.println(isPowerOfTen(1000));  // true (10^3)
        System.out.println(isPowerOfTen(0));     // false
        System.out.println(isPowerOfTen(-10));   // false
        System.out.println(isPowerOfTen(50));    // false
        System.out.println(isPowerOfTen(101));   // f
    }
    @Test
    public void testPowerOfTenPositiveCases() {
        assertTrue(isPowerOfTen(11)); //, "1 is a power of 10 (10^0)"
//        assertTrue(isPowerOfTen.isPowerOfTen(10), "10 is a power of 10 (10^1)");
//        assertTrue(isPowerOfTen.isPowerOfTen(100), "100 is a power of 10 (10^2)");
//        assertTrue(isPowerOfTen.isPowerOfTen(1000), "1000 is a power of 10 (10^3)");
    }
}

