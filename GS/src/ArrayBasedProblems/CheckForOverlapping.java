package ArrayBasedProblems;

import java.util.Arrays;
import java.util.Comparator;

public class CheckForOverlapping {

    static boolean checkOverlappingIntervals(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(ar -> ar[0]));
       for(int i=1;i< arr.length;i++){
           if(arr[i][0]<arr[i-1][1])
               return true;
       }
        return false;
    }


    public static void main(String[] args) {
        int[][] arr = {{1, 4}, {10, 15}, {7, 10}};
        boolean result = checkOverlappingIntervals(arr);
        System.out.println(result ? "Overlapping intervals exist" : "No overlapping intervals");
    }
}
