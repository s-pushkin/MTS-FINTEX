import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import io.qameta.allure.selenide.AllureSelenide;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.platform.commons.util.Preconditions.condition;

public class Dz2Test {
    @Test
    public void bookingTestAnt() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open("https://www.booking.com/");

        sleep(2000);

        $("input[name='ss']").setValue("Прага");

        sleep(2000);

        $x("/html/body/div[3]/div[2]/div/form/div/div[2]/div").click();
        sleep(2000);
        $("[data-date='2024-12-25']").click();
        $("[data-date='2024-12-26']").click();

        $x("//button[@type='submit' and contains(@class, 'a83ed08757')]").click();

        sleep(5000);

        $x("/html/body/div[4]/div/div[2]/div/div[2]/div[3]/div[1]/div[1]/div/div/div/div/button").click();

        sleep(5000);

        $("[data-testid='property-list-map-card']").hover();


        // Находим карточку отеля
        SelenideElement hotelCard = $("[data-testid='property-list-map-card']").shouldBe(visible);


        // Извлекаем название отеля
        String hotelName = hotelCard.$("[data-testid='header-title']").getText();


        // Извлекаем количество звезд
        String starsText = hotelCard.$("[data-testid='rating-stars']").attr("aria-label");
        Pattern pattern4 = Pattern.compile("\\d+([.,]\\d+)?");
        Matcher matcher4 = pattern4.matcher(starsText);
        if (matcher4.find()) {starsText = matcher4.group();}

        // Извлекаем оценку отеля
        SelenideElement scoreH = hotelCard.$(".ac4a7896c7");
        String score = scoreH.getText();
        System.out.println(score);
        Pattern pattern = Pattern.compile("(\\d+,\\d+)");
        Matcher matcher = pattern.matcher(score);
        if (matcher.find()) {score = matcher.group(1);}
        System.out.println(score);


        // Извлекаем текст с количеством отзывов
        String reviews = hotelCard.$(".abf093bdfe").getText();
        String outputReviews = reviews.replaceAll("[^0-9]", "");

        String cost = hotelCard.$("[data-testid='price-and-discounted-price']").getText();

        // Выводим результат
        System.out.println("Название отеля: " + hotelName);
        System.out.println("Количество звезд: " + starsText);
        System.out.println("Оценка: " + score);
        System.out.println("Количество отзывов: " + reviews);
        System.out.println("Стоимость: " + cost);

        hotelCard.click();


        sleep(5000);
        Selenide.switchTo().window(1);

        SelenideElement NameElement = $("#hp_hotel_name h2");
        String hotelTitle = NameElement.getText();



        String reviewScore = $x("//*[@id='js--hp-gallery-scorecard']/a/div/div/div/div[1]").getText();

        Pattern pattern1 = Pattern.compile("(\\d+,\\d+)");
        Matcher matcher1 = pattern.matcher(reviewScore);
        if (matcher1.find()) {reviewScore = matcher1.group(1);}


        SelenideElement priceElement = $(".prco-valign-middle-helper");
        String priceText = priceElement.getText();

        SelenideElement allStars = $(".a455730030.d542f184f1");
        int starsH = allStars.findAll("span.fcd9eec8fb").size();
        String starsHotel = starsH + "";


        String reviewCountText = $x("//*[@id='js--hp-gallery-scorecard']/a/div/div/div/div[2]/div[2]").getText();
        String output = reviewCountText.replaceAll("\\s+", "");
        String reviewCount = output.replaceAll("[^0-9]", "");


        assertEquals(hotelName, hotelTitle, "Hotel Name неверно");
        assertEquals(score, reviewScore, "Оценка неверно");
        assertEquals(priceText, cost, "Стоимость неверно");
        assertEquals(starsText, starsHotel, "Звёзды неверно");
        assertEquals(reviewCount, outputReviews, "Количество отзывов неверно");

    }
}
