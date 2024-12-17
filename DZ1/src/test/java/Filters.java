import com.codeborne.selenide.Selenide;
public class Filters {
    public void applyRatingFilter() {
        Selenide.$("[data-filters-item='class:class=5'] input").click();
    }
}
