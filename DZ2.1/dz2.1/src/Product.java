/**
 * Класс, представляющий продукт с его характеристиками.
 * Он хранит данные о количестве, цене и скидке на продукт,
 * а также позволяет вычислить общую стоимость с учётом скидки.
 */
public class Product {

     // Количество продукта
     private int quantity;

     // Цена за единицу продукта
     private double price;

     // Скидка на продукт
     private double discount;

     /**
      * Метод инициализации параметров продукта.
      *
      * @param quantity Количество продукта
      * @param price Цена продукта
      * @param discount Скидка на продукт
      */
     public void initialize(int quantity, double price, double discount) {
          this.quantity = quantity;
          this.price = price;
          this.discount = discount;
          totalCost();
     }

     /**
      * Метод для вычисления и вывода общей стоимости
      * с учетом и без учета скидки.
      */
     private void totalCost() {
          double costWithDiscount = Math.round(quantity * price * (1 - discount) * 100.0) / 100.0;
          double costWithoutDiscount = Math.round(quantity * price * 100.0) / 100.0;

          System.out.println("Cost with discount: " + costWithDiscount);
          System.out.println("Cost without discount: " + costWithoutDiscount);
     }
}

