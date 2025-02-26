import java.util.function.Consumer;
import java.util.function.Function;

public class Optional1<T> {
    private final T value;

    public Optional1(T value) {
        this.value = value;
    }

    public static <T> Optional1<T> of(T value) {
        if (value == null) throw new NullPointerException("Null not allowed");
        else
            return new Optional1<>(value);
    }

    public static <T> Optional1<T> ofNullable(T value) {
        return new Optional1<>(value);
    }

    public boolean isPresent() {
        return value != null;
    }

    public static <T> Optional1<T> empty() {
        return new Optional1<>(null);
    }

    public T get() {
        if (this.value == null) throw new IllegalStateException("No Value Present");
        return this.value;
    }

    public T orElse(T defaultValue) {
        return (this.value == null) ? defaultValue : value;
    }

    public void ifPresent(Consumer<T> consumer) {
        if (this.value != null) {
            consumer.accept(value);
        }
    }

    public <T> Optional1<T> map(Function<T, T> mapper) {
        if (this.value == null)
            return empty();
        else return Optional1.ofNullable(mapper.apply((T) value));
    }
}


