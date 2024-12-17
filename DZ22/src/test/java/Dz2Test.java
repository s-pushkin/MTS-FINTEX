import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Dz2Test {
    private static final int sleepTime = 3000;
    private String hotelName;
    private String score;
    private String starsText;
    private String reviews;
    private String cost;
    private String reviewCount;
    private String priceText;
    private String starsHotel;
    private String hotelTitle;
    private String reviewScore;
    private String outputReviews;

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Test
    public void bookingTest() {
        MainPage mainPage = new MainPage();
        HotelCard hotelCardPage = new HotelCard();
        HotelDetailsPage hotelDetailsPage = new HotelDetailsPage();

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

        checkHotelParam();
    }

    public void checkHotelParam() {
        assertEquals(hotelName, hotelTitle, "Hotel Name неверно");
        assertEquals(score, reviewScore, "Оценка неверно");
        assertEquals(priceText, cost, "Стоимость неверно");
        assertEquals(starsText, starsHotel, "Звёзды неверно");
        assertEquals(reviewCount, outputReviews, "Количество отзывов неверно");
    }



}


