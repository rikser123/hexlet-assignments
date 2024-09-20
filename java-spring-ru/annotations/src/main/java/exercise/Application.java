package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        for (var method: Address.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Inspect.class)) {
                try {
                    var methodName = method.getName();
                    var result = method.invoke(address);
                    var returnType = result.getClass().getSimpleName();
                    var expectedReturnTypeFull = method.getReturnType();
                    var returnTypeFull = expectedReturnTypeFull.toString().contains(returnType) ? returnType : expectedReturnTypeFull;

                    System.out.println("Method " + methodName + " returns a value of type " + returnTypeFull + ".");
                } catch(Exception e) {

                }

            }
        }
        // END
    }
}
