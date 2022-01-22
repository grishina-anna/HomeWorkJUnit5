import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;

public class HomeWorkTest {

    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    static Stream<Arguments> commonSearchTestCsvSource() {
        return Stream.of(
                Arguments.of("Титаник", "Джеймс"),
                Arguments.of("Декстер", "Джон")
        );
    }

  @CsvSource(value = {
        "Титаник, Джеймс",
        "Декстер, Джон"
    })

  @ParameterizedTest(name = "Тестирование поиска фильма: {0}")
  void commonSearchTest(String testData, String expected) {
      open("https://www.kinopoisk.ru/");
      $("[type=\"text\"]").setValue(testData).pressEnter();
      $("[class=\"director\"]").shouldHave(Condition.text(expected));
  }

    @AfterEach
    void AfterEach() {
        clearBrowserCookies(); }
}
