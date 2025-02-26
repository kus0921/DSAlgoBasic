import java.util.Arrays;
import java.util.concurrent.*;

public class CalculateSumOfArrayUsingCallable implements Callable<Integer> {
    public final int[] numbers;
    public CalculateSumOfArrayUsingCallable(int[] numbers) {
        this.numbers = numbers;
    }


    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args)  {
        int[] nums = {2, 3, 4, 5, 6, 7};
        //Callable<Integer> callable = (n)->{return Arrays.stream(n).boxed().sum();}
        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            Future<Integer> future = service.submit(new CalculateSumOfArrayUsingCallable(nums));
            System.out.println(future.get());
            service.shutdown();
        } catch (ExecutionException | InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
