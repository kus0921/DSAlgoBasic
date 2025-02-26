import java.lang.reflect.Field;

public class Validator {
    public static void validate(Object object) throws IllegalAccessException {

        Class<?> claz = object.getClass();
        Field[] fields = claz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
//            if (field.isAnnotationPresent(NotEmpty.class)) {
//                Object value = field.get(object);
//                NotEmpty notEmpty = field.getAnnotation(NotEmpty.class);
//                if (value == null || value.toString().trim() == "") {
//                    throw new IllegalArgumentException(notEmpty.message());
//                }
//            }
            // Validate @Range
            if (field.isAnnotationPresent(Range.class)) {
                Range range = field.getAnnotation(Range.class);
                Object value = field.get(object);
                if (value instanceof Integer) {
                    int intValue = (Integer) value;
                    if (intValue < range.min() || intValue > range.max()) {
                        throw new IllegalArgumentException(range.message());
                    }
                }
            }
        }
    }
}


