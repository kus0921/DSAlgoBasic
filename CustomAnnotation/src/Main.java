//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            // Valid user
            User validUser = new User("Alice", 25);
            Validator.validate(validUser);
            System.out.println("Valid user passed validation!");

            // Invalid user: Empty name
            User invalidUser1 = new User("", 25);
            Validator.validate(invalidUser1);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            System.err.println("Validation failed: " + e.getMessage());
        }

        try {
            // Invalid user: Age out of range
            User invalidUser2 = new User("Bob", 150);
            Validator.validate(invalidUser2);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            System.err.println("Validation failed: " + e.getMessage());
        }
    }
}
