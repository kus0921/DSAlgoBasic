import java.util.HashSet;

public class PairSumInArrayEqualToK {
    public static void sumOfPairBruteForce(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    System.out.println("Pair found:" + arr[i] + ":" + arr[j]);
                }
            }
        }

    }

    public static void sumOfPairHashSet(int[] arr, int sum) {
        //HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (Integer i : arr) {
            if (set.contains(sum - i)) {
                System.out.println("Found a pair:" + i + ":" + (sum - i));
            } else {
                set.add(i);
            }
        }
    }

    public static void sumByTwoPointer(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        int pairSum;
        while (low < high) {
            pairSum=arr[low]+arr[high];
            if(pairSum== k){
                System.out.println("Pair :"+arr[low]+":"+arr[high]);
            }
            else if(pairSum>k){
                high--;
            }else{
                low++;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // sumOfPairBruteForce(arr, 6);
        // sumOfPairHashSet(arr,6);
        sumByTwoPointer(arr,6);
    }
}
