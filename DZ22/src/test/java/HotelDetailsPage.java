import com.codeborne.selenide.SelenideElement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HotelDetailsPage {
    public String getHotelName() {
        SelenideElement nameElement = $("#hp_hotel_name h2");
        return nameElement.getText();
    }

    public String getReviewScore() {
        String reviewScore = $x("//*[@id='js--hp-gallery-scorecard']/a/div/div/div/div[1]").getText();
        Pattern pattern = Pattern.compile("(\\d+,\\d+)");
        Matcher matcher = pattern.matcher(reviewScore);
        return matcher.find() ? matcher.group(1) : "";
    }

    public String getPrice() {
        SelenideElement priceElement = $(".prco-valign-middle-helper");
        return priceElement.getText();
    }

    public String getStarsCount() {
        SelenideElement allStars = $(".a455730030.d542f184f1");
        int starsCount = allStars.findAll("span.fcd9eec8fb").size();
        return String.valueOf(starsCount);
    }

    public String getReviewsCount() {
        String reviewCountText = $x("//*[@id='js--hp-gallery-scorecard']/a/div/div/div/div[2]/div[2]").getText();
        String output = reviewCountText.replaceAll("\\s+", "");
        return output.replaceAll("[^0-9]", "");
    }

}
