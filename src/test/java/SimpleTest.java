import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Класс с тестами, сравнивающими 3 и 2") //будет показано, что тесты проверют
public class SimpleTest {

    //@Disabled - если не нужно выполнять все тесты в классе SimpleTest
        @Test //аннотация
        @DisplayName("Тест проверяет, что 3 меньше 2") //будет показано, что тест проверяет
    void test(){
        Assertions.assertTrue(3 < 2); //проверка, что 3 меньше 2
        //аннотация - является частью мета информации классов, в которых она используется
        //метаинформация - связанная с тестом информация для хранения чего-то дополнительного (привязки к коду)
        //не все аннотации является метинформации, 3 вида: SOURSE - аннотация, которая не попадает в метинформацию (служат для улучшения читаемости кода)
   //CLASS (для продвинутых) и RUNTIME отличаются уровнем, когда можно получить доступ к этой метинформацией.
    }

    @Test
        void test1(){
        Assertions.assertTrue(2 < 3);
        }

        @Test
        @Disabled //тест не будет выполняться
    void test2(){
        throw new NullPointerException();
    }
}