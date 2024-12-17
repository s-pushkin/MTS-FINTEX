import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.Condition;

public class SearchResultPage {
    public void clickSearchButton() {
        Selenide.$x("//button[@type='submit' and contains(@class, 'a83ed08757')]").click();
    }
    public void checkPageTitle(String expectedText) {
        Selenide.$("h1.f6431b446c").shouldHave(Condition.text(expectedText));
    }
}
