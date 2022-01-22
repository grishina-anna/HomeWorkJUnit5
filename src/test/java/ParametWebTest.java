//import com.codeborne.selenide.Condition;
//import com.codeborne.selenide.Selenide;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.util.List;
//import java.util.stream.Stream;
//
//public class ParametWebTest {
//        //параметризированные тесты - когда тесты отличаются набором входных данных
//
//        @BeforeEach
//            //выполнится 2 раза (для каждого теста)
//        void beforeEach() {
//            System.out.println("@BeforeEach");
//        }
//@CsvSource(value = { //аннтоция, позволяющая сначала указать 1 данные и проверить наличие текста после , , а затем проверить вторые данные и также проверить наличие текста
//        "Selenide; September 26, 2020",
//        "Junit; 5 is the next generation of"
//        //иногда запятая встречаетмся в тескта, тогда можно указать делиметр и использовать любой символ
//}, delimiter = ';')
//  @ValueSource(strings = {"Selenide", "Junit"}) //предоставляет данные для тестов в виде примитивных данных /стрингов/пассов; strings - название метода
//  @ValueSource(ints = {1, 2} )                  // , разделяет список запуска теста. сначала "Selenide", потом "Allure"

//если нужно ввести строку и найти цифры
//@CsvSource(value = { //аннтоция, позволяющая сначала указать 1 данные и проверить наличие текста после , , а затем проверить вторые данные и также проверить наличие текста
//        "Selenide; 1/true",
//        "Junit; 2"
//@ParameterizedTest(name = "Тестирование общего алгоритма: {0}") //{0} - первый аргумент
//void commonSearchTest(String testData, int expectedResult) {
//        Selenide.open("https://ya.ru");
//    Selenide.$("#text").setValue(testData).pressEnter();
//    Selenide.$$("li.serp-item")
//            .first()
//            .shouldHave(Condition.text(expectedResult));
    //            .shouldHave(Condition.text("September 26, 2020"));
//            .shouldHave(Condition.text("5 is the next generation of"));

//        static Stream<Arguments> commonSearcheDataProvider() {
//            return Stream.of(
//                    Arguments.of("Selenide", false, List.of("1", "2")),
//                    Arguments.of("Junit", true, "3", "4")
//            );
//        }

//        @MethodSource("commonSearcheDataProvider")
//        //указывается имя специального статического метода, который называется дата провайдер
//        // можно ввести любые объекты
//        @ParameterizedTest(name = "Тестирование общего алгоритма: {0}")
//            //{0} - первый аргумент
//        void commonSearchTest(String testData, boolean flag, List<String> list) {  //в наш тест приходит 1(!) параметр
//            System.out.println("Flag: " + flag);
//            System.out.println("List: " + list.toString());
//            Selenide.open("https://ya.ru");
//            Selenide.$("#text").setValue(testData).pressEnter();
//            Selenide.$$("li.serp-item")
//                    .first()
//                    .shouldHave(Condition.text(testData));
//            .shouldHave(Condition.text("September 26, 2020"));
//            .shouldHave(Condition.text("5 is the next generation of"));
//  }
//        }
//    }
