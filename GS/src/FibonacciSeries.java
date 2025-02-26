public class FibonacciSeries {
    public static void generateFibonacci(int n) {
//        int i1 = 0;
//        int i2 = 1;
//        if (n >= 1) {
//            System.out.println(i1);
//        }
//        if (n >= 2) {
//            System.out.println(i2);
//        }
//        if (n >= 3) {
//            for (int i = 3; i <= n; i++) {
//                System.out.println(i1+i2);
//                int t = i1+i2;
//                i1=i2;
//                i2=t;
//            }
//
//        }
        while(n>=0){
            System.out.println(generateFibonacciUsingRecursion(n));
            n--;
        }
    }
    public static int generateFibonacciUsingRecursion(int n){

        if(n<=1){
            return n;
        }
        else return generateFibonacciUsingRecursion(n-1)+generateFibonacciUsingRecursion(n-2);

    }

    public static void main(String[] args) {

        generateFibonacci(5);
    }
}
