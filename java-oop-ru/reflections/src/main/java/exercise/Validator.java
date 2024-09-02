package exercise;

import java.lang.reflect.Field;
// BEGIN
import java.util.List;
import java.util.ArrayList;

public class Validator {
    public static List<String> validate(Object object) {
        var invalidFields = new ArrayList<String>();
        var fields = object.getClass().getDeclaredFields();

        for (var field: fields) {
            var notNull = field.getAnnotation(NotNull.class);

            if (notNull == null) {
                continue;
            }

            try {
                field.setAccessible(true);
                Object value = field.get(object);
                if (value == null) {
                    invalidFields.add(field.getName());
                }
            } catch(Exception e) {

            }
        }

        return invalidFields;
    }
}
// END
