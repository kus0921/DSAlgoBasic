package NumericalProblems;

/*Returns second smallest element in array x. If x has fewer than 2 elements returns 0.
Signature:
    int secondSmallest(int[] x)
Test Cases:
    Input:[ -1, 0, 1, -2, 2]
    Output: -1
    Input:[ 0, 1]
    Output: 1
 */
public class SecondSmallestElement {
    public static int secondSmallest(int[] x) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int j : x) {
            if (j < smallest)
            {

                secondSmallest=smallest;
                smallest = j;
            }
            //else if(j>smallest&&j<secondSmallest){
              //  secondSmallest=j;
            //}

        }
        return secondSmallest;
    }

    public static void main(String[] args) {
        System.out.println(secondSmallest(new int[]{-1, 0, 1, -2, 2}));
    }
}
