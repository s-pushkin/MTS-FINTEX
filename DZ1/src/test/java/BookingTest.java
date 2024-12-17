import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingTest {
    @BeforeAll
    static void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @Test
    public void bookingTestAnt()  {
        int sleepTime = 2000;
        mainPage();
        setTownName("Анталья");
        sleep(sleepTime);
        buttonClick();
        sleep(sleepTime);
        checkText();
        sleep(sleepTime);
        setRating();
        sleep(sleepTime);
        checkRating();
        sleep(sleepTime);
    }

    public void mainPage(){
        open("https://www.booking.com/");
    }
    public void setTownName(String Town){
        $("input[name='ss']").setValue(Town);
    }
    public void buttonClick(){
        $x("//button[@type='submit' and contains(@class, 'a83ed08757')]").click();
    }
    public void checkText(){
        $("h1.f6431b446c").shouldHave(Condition.text("Анталья"));
    }
    public void setRating(){
        $("[data-filters-item='class:class=5'] input").click();
    }

    public void checkRating(){
        ElementsCollection ratingElements = $$("[data-testid='rating-stars']");

        for (int i = 0; i < ratingElements.size(); i++) {
            String starsText = ratingElements.get(i)
                    .parent()
                    .shouldBe(Condition.visible)
                    .attr("aria-label");

            int stars = Integer.parseInt(starsText.split(" ")[0]);

            assertEquals(5, stars, "Количество звезд не соответствует!");

        }
    }
}


