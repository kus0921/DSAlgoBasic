package MathematicalProblems;

public class PowerOfTen {
    static boolean ifPowerOfTen(long num)
    {
        while (num > 1) {
            if (num % 10 != 0) return false;
            num /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(ifPowerOfTen(0));
    }
}
