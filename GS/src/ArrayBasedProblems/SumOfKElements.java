package ArrayBasedProblems;

public class SumOfKElements {
    static int maxSum(int[] arr, int k) {
        int sum = 0,maxSum=0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int left=0;
        maxSum=sum;
        for(int i=k;i<arr.length;i++){
            sum+=arr[i];
            sum-=arr[left++];
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 5, 6, 7, 8};//,
        int k = 3;//, find max Sum of consecutive of k number,
        System.out.println(maxSum(arr, k));
    }
}
