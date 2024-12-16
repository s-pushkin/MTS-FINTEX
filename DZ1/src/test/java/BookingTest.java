import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingTest {
    @Test
    public void bookingTestAnt()  {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open("https://www.booking.com/");
        $("input[name='ss']").setValue("Анталья");

        sleep(2000);

        $x("//button[@type='submit' and contains(@class, 'a83ed08757')]").click();

        sleep(2000);

        $("h1.f6431b446c").shouldHave(Condition.text("Анталья"));

        sleep(2000);

        $("[data-filters-item='class:class=5'] input").click();

        sleep(2000);

        ElementsCollection ratingElements = $$("[data-testid='rating-stars']");

        for (int i = 0; i < ratingElements.size(); i++) {
            String starsText = ratingElements.get(i)
                    .parent()
                    .shouldBe(Condition.visible)
                    .attr("aria-label");

            int stars = Integer.parseInt(starsText.split(" ")[0]);

            assertEquals(5, stars, "Количество звезд не соответствует!");

        }

        sleep(2000);

    }
}


