package ArrayBasedProblems;

import java.util.PriorityQueue;

public class KLargestElementsHeap {
    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 8, 25, 15};
        int k = 3;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        System.out.println(minHeap.stream().max(Integer::compare).orElse(0));
    }
}