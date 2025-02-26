import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {

        // Custom input array
        int arr[] = {3,4, 5, 2, 1};
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
    }
}
