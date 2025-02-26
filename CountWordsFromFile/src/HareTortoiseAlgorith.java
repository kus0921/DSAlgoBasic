public class HareTortoiseAlgorith {
    public static int getLoopLength(int arr[]) {
        int slow = 0, fast = 0, loopLength = 0;
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
            if (slow <= 0 || fast <= 0 || slow >= arr.length || fast >= arr.length)
            {
                return -1;
            }
        } while (slow != fast);
        System.out.print("Fast :" + fast+"->");
       do {
            loopLength++;
            slow = arr[slow];
            // fast=arr[arr[fast]];
            System.out.print("slow :" + slow+"->");
        }
       while (slow != fast);
        return loopLength;
    }

    public static void main(String[] args) {
        int[] rr = {1, 2, 3, 4, 2};
        int result = getLoopLength(rr);
        System.out.println(result);
    }
}
