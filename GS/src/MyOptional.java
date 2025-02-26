import java.util.function.Consumer;
import java.util.function.Function;

public class MyOptional<T> {
    private final T value;

    // Private Constructor
    private MyOptional(T value) {
        this.value = value;
    }

    // Factory method - Create an instance with a non-null value
    public static <T> MyOptional<T> of(T value) {
        if (value == null) {
            throw new NullPointerException("Value cannot be null");
        }
        return new MyOptional<>(value);
    }

    // Factory method - Create an empty optional
    public static <T> MyOptional<T> empty() {
        return new MyOptional<>(null);
    }

    // Factory method - Create an instance that allows null values
    public static <T> MyOptional<T> ofNullable(T value) {
        return new MyOptional<>(value);
    }

    // Check if value is present
    public boolean isPresent() {
        return value != null;
    }

    // Get the value (throws exception if empty)
    public T get() {
        if (value == null) {
            throw new IllegalStateException("No value present");
        }
        return value;
    }

    // Return value if present, otherwise return default
    public T orElse(T defaultValue) {
        return (value != null) ? value : defaultValue;
    }

    // Execute consumer if value is present
    public void ifPresent(Consumer<T> consumer) {
        if (value != null) {
            consumer.accept(value);
        }
    }

    // Transform the value using a function
    public <R> MyOptional<R> map(Function<T, R> mapper) {
        if (!isPresent()) {
            return empty();
        }
        return MyOptional.ofNullable(mapper.apply(value));
    }

    @Override
    public String toString() {
        return isPresent() ? "MyOptional[" + value + "]" : "MyOptional.empty";
    }
}
