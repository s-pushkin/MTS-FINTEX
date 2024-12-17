import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class BookingTest {
    private static final int sleepTime = 2000;
    private MainPage mainPage = new MainPage();
    private SearchResultPage searchResultsPage = new SearchResultPage();
    private Filters filters = new Filters();
    private HotelCard hotelCard = new HotelCard();


    @BeforeAll
    static void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @Test
    public void bookingTestAnt()  {
        mainPage.openMainPage();
        mainPage.setTownName("Анталья");
        sleep(sleepTime);

        searchResultsPage.clickSearchButton();
        sleep(sleepTime);
        searchResultsPage.checkPageTitle("Анталья");
        sleep(sleepTime);

        filters.applyRatingFilter();
        sleep(sleepTime);

        hotelCard.checkHotelRatings();
        sleep(sleepTime);
    }
}


