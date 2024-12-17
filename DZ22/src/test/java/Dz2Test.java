
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.qameta.allure.selenide.AllureSelenide;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
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
    static void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @Test
    public void bookingTest() {

        mainPage();
        sleep(sleepTime);
        setTownName("Прага");
        sleep(sleepTime);
        setData();
        buttonClick();
        sleep(sleepTime);
        openMap();
        sleep(sleepTime);
        hotelCard();
        sleep(sleepTime);
        switchWindow(1);
        getHotelName();
        getReviewScore();
        getPrice();
        getStarsCount();
        getReviewsCount();
        checkHotelParam();

    }
    public void mainPage(){
        open("https://www.booking.com/");
    }
    public void setTownName(String Town){
        $("input[name='ss']").setValue(Town);
    }
    public void setData(){
        $x("/html/body/div[3]/div[2]/div/form/div/div[2]/div").click();
        sleep(sleepTime);
        $("[data-date='2024-12-25']").click();
        $("[data-date='2024-12-26']").click();
    }
    public void buttonClick(){
        $x("//button[@type='submit' and contains(@class, 'a83ed08757')]").click();
    }
    public void openMap(){
        $x("/html/body/div[4]/div/div[2]/div/div[2]/div[3]/div[1]/div[1]/div/div/div/div/button").click();
    }
    public void hotelCard(){
        $("[data-testid='property-list-map-card']").hover();

        SelenideElement hotelCard = $("[data-testid='property-list-map-card']").shouldBe(visible);

        String hotelName = hotelCard.$("[data-testid='header-title']").getText();

        String starsText = hotelCard.$("[data-testid='rating-stars']").attr("aria-label");
        Pattern pattern4 = Pattern.compile("\\d+([.,]\\d+)?");
        Matcher matcher4 = pattern4.matcher(starsText);
        if (matcher4.find()) {starsText = matcher4.group();}

        SelenideElement scoreH = hotelCard.$(".ac4a7896c7");
        String score = scoreH.getText();
        System.out.println(score);
        Pattern pattern = Pattern.compile("(\\d+,\\d+)");
        Matcher matcher = pattern.matcher(score);
        if (matcher.find()) {score = matcher.group(1);}
        System.out.println(score);

        String reviews = hotelCard.$(".abf093bdfe").getText();
        String outputReviews = reviews.replaceAll("[^0-9]", "");

        String cost = hotelCard.$("[data-testid='price-and-discounted-price']").getText();

        hotelCard.click();
    }
    public void switchWindow(int window){
        Selenide.switchTo().window(window);
    }
    public void getHotelName(){
        SelenideElement NameElement = $("#hp_hotel_name h2");
        String hotelTitle = NameElement.getText();
    }
    public void getReviewScore(){
        String reviewScore = $x("//*[@id='js--hp-gallery-scorecard']/a/div/div/div/div[1]").getText();
        Pattern pattern1 = Pattern.compile("(\\d+,\\d+)");
        Matcher matcher1 = pattern1.matcher(reviewScore);
        if (matcher1.find()) {reviewScore = matcher1.group(1);}
    }
    public void getPrice(){
        SelenideElement priceElement = $(".prco-valign-middle-helper");
        String priceText = priceElement.getText();
    }
    public void getStarsCount(){
        SelenideElement allStars = $(".a455730030.d542f184f1");
        int starsH = allStars.findAll("span.fcd9eec8fb").size();
        String starsHotel = starsH + "";
    }
    public void getReviewsCount(){
        String reviewCountText = $x("//*[@id='js--hp-gallery-scorecard']/a/div/div/div/div[2]/div[2]").getText();
        String output = reviewCountText.replaceAll("\\s+", "");
        String reviewCount = output.replaceAll("[^0-9]", "");
    }
    public void checkHotelParam(){
        assertEquals(hotelName, hotelTitle, "Hotel Name неверно");
        assertEquals(score, reviewScore, "Оценка неверно");
        assertEquals(priceText, cost, "Стоимость неверно");
        assertEquals(starsText, starsHotel, "Звёзды неверно");
        assertEquals(reviewCount, outputReviews, "Количество отзывов неверно");
    }

}
