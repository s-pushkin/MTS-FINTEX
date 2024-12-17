import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

public class HotelCard {
    public void checkHotelRatings() {
        ElementsCollection ratingElements = Selenide.$$("[data-testid='rating-stars']");

        for (int i = 0; i < ratingElements.size(); i++) {
            String starsText = ratingElements.get(i)
                    .parent()
                    .shouldBe(Condition.visible)
                    .attr("aria-label");

            int stars = Integer.parseInt(starsText.split(" ")[0]);
            if (stars != 5) {
                throw new AssertionError("Количество звезд не соответствует!");
            }
        }
    }
}
