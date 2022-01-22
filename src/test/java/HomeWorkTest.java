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

  @CsvSource(value = {
        "Титаник, Titanic",
        "Декстер, Dexter"
    })

  @ParameterizedTest(name = "Тестирование поиска фильма: {0}")
  public void commonSearchTest(String testData, String expected) {
      open("https://www.kinopoisk.ru/");
      $("[type=\"text\"]").setValue(testData).pressEnter();
      $("info").shouldHave(Condition.text(expected));
  }

    @AfterEach
    void AfterEach() {
        clearBrowserCookies(); }
}
