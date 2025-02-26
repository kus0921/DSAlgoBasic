//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            try {
                System.out.println("Inner try block.");
                // This will throw an exception.
                throw new ArithmeticException("Inner exception");
            } catch (ArithmeticException e) {
                System.out.println("Caught in inner catch block: " + e.getMessage());
                // This will throw another exception.
                throw new NullPointerException("Inner catch block exception");
            } finally {
                System.out.println("Inner finally block.");
                // This will throw yet another exception.
                throw new ArrayIndexOutOfBoundsException("Inner finally block exception");
            }
        } catch (Exception e) {
            System.out.println("Caught in outer catch block: " + e.getMessage());
        }
    }
}
