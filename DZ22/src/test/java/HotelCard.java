import com.codeborne.selenide.SelenideElement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.codeborne.selenide.Selenide.$;

public class HotelCard {
    public SelenideElement getHotelCard() {
        return $("[data-testid='property-list-map-card']").hover();
    }

    public String getHotelName(SelenideElement hotelCard) {
        return hotelCard.$("[data-testid='header-title']").getText();
    }

    public String getStars(SelenideElement hotelCard) {
        String starsText = hotelCard.$("[data-testid='rating-stars']").attr("aria-label");
        Pattern pattern = Pattern.compile("\\d+([.,]\\d+)?");
        Matcher matcher = pattern.matcher(starsText);
        return matcher.find() ? matcher.group() : "";
    }

    public String getScore(SelenideElement hotelCard) {
        String score = hotelCard.$(".ac4a7896c7").getText();
        Pattern pattern = Pattern.compile("(\\d+,\\d+)");
        Matcher matcher = pattern.matcher(score);
        return matcher.find() ? matcher.group(1) : "";
    }

    public String getReviews(SelenideElement hotelCard) {
        String reviews = hotelCard.$(".abf093bdfe").getText();
        return reviews.replaceAll("[^0-9]", "");
    }

    public String getCost(SelenideElement hotelCard) {
        return hotelCard.$("[data-testid='price-and-discounted-price']").getText();
    }

    public void clickHotelCard(SelenideElement hotelCard) {
        hotelCard.click();
    }

}
