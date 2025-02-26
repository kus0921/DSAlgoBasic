package MathematicalProblems;

public class FractionAddition {
    static void findFractioSum(int[] frac1, int[] frac2){
        int num1= frac1[0];
        int deno1=frac1[1];
        int num2=frac2[0];
        int deno2=frac2[1];
        int resultnum = num1*deno2+num2*deno1;
        int resultdeno=deno1*deno2;
        int gcd = findGCD(resultnum,resultdeno);
        resultnum/=gcd;
        resultdeno/=gcd;
        System.out.println(resultnum+"/"+resultdeno);
    }
    static int findGCD(int a, int b){
        if(b==0)
        {
            return Math.abs(a);
        }
        return findGCD(b,a%b);

    }
    public static void main(String[] args) {
        int[]a={1,2};
        int[]b={1,4};
        findFractioSum(a,b);
    }
}
