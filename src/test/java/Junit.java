import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Junit {
    //найти классы, которые лежат в src Test
    //найти в них те, в которых есть @
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException,
            IllegalAccessException {
        for (Method declaredMethod : SimpleTest.class.getDeclaredMethods()) { //написали цикл 
            Test test = declaredMethod.getAnnotation(Test.class);
            if (test != null) { //если не ноль
                try {
                    declaredMethod.invoke(
                            SimpleTest.class.getConstructor().newInstance());
                    //не хватает обработки ошибки, нужно добавить try catch
                } catch (InvocationTargetException e) {
                    if (e.getCause() instanceof AssertionError)  {        //вернуть исключение
                    System.out.println("Test " + declaredMethod.getName() + " failed: " + e.getCause().getMessage());
                    continue;
                } else {
                        System.out.println("Test " + declaredMethod.getName() + " broked: " + e.getCause().getMessage());
                        continue;
                    }
                }
                System.out.println("Test " + declaredMethod.getName() + " passed: ");
            }
        }
    }
}
