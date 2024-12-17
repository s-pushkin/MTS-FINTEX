import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public void openBooking() {
        open("https://www.booking.com/");
    }

    public void setTownName(String town) {
        $("input[name='ss']").setValue(town);
    }

    public void setDate() {
        $x("/html/body/div[3]/div[2]/div/form/div/div[2]/div").click();
        sleep(3000);
        $("[data-date='2024-12-25']").click();
        $("[data-date='2024-12-26']").click();
    }

    public void submitSearch() {
        $x("//button[@type='submit' and contains(@class, 'a83ed08757')]").click();
    }

    public void openMap() {
        $x("/html/body/div[4]/div/div[2]/div/div[2]/div[3]/div[1]/div[1]/div/div/div/div/button").click();
    }



}
