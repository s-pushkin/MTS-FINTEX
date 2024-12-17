import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.qameta.allure.selenide.AllureSelenide;
import static com.codeborne.selenide.Selenide.sleep;



public class BookingMapTest {
    private static final int sleepTime = 3000;
    public String hotelName;
    public String score;
    public String starsText;
    public String reviews;
    public String cost;
    public String reviewCount;
    public String priceText;
    public String starsHotel;
    public String hotelTitle;
    public String reviewScore;
    public String outputReviews;

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        MainPage mainPage = new MainPage();
        HotelCard hotelCardPage = new HotelCard();
        HotelDetailsPage hotelDetailsPage = new HotelDetailsPage();
        CheckHotelParam checkHotelParam = new CheckHotelParam();
    }

    @Test
    public void bookingTest() {
        MainPage mainPage = new MainPage();
        HotelCard hotelCardPage = new HotelCard();
        HotelDetailsPage hotelDetailsPage = new HotelDetailsPage();
        CheckHotelParam checkHotelParam = new CheckHotelParam();

        mainPage.openBooking();
        sleep(sleepTime);

        mainPage.setTownName("Прага");
        sleep(sleepTime);

        mainPage.setDate();
        sleep(sleepTime);

        mainPage.submitSearch();
        sleep(sleepTime);

        mainPage.openMap();
        sleep(sleepTime);

        SelenideElement hotelCard = hotelCardPage.getHotelCard();
        sleep(sleepTime);

        hotelName = hotelCardPage.getHotelName(hotelCard);
        starsText = hotelCardPage.getStars(hotelCard);
        score = hotelCardPage.getScore(hotelCard);
        reviewCount = hotelCardPage.getReviews(hotelCard);
        cost = hotelCardPage.getCost(hotelCard);
        hotelCardPage.clickHotelCard(hotelCard);
        sleep(sleepTime);

        Selenide.switchTo().window(1);
        hotelTitle = hotelDetailsPage.getHotelName();
        reviewScore = hotelDetailsPage.getReviewScore();
        priceText = hotelDetailsPage.getPrice();
        starsHotel = hotelDetailsPage.getStarsCount();
        outputReviews = hotelDetailsPage.getReviewsCount();

        checkHotelParam.checkParamHotel();
    }




}


