import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckHotelParam extends BookingMapTest {
    public void checkParamHotel(){
        assertEquals(hotelName, hotelTitle, "Название отеля неверно");
        assertEquals(score, reviewScore, "Оценка неверно");
        assertEquals(priceText, cost, "Стоимость неверно");
        assertEquals(starsText, starsHotel, "Количество звёзд неверно");
        assertEquals(reviewCount, outputReviews, "Количество отзывов неверно");
    }
}
