import com.codeborne.selenide.Selenide;
public class MainPage {
    public void openMainPage() {
        Selenide.open("https://www.booking.com/");
    }
    public void setTownName(String town) {
        Selenide.$("input[name='ss']").setValue(town);
    }
}
