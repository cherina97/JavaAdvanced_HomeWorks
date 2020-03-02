package hw2;

import org.apache.log4j.Logger;

public class OrderLogic {
    // ініціалізація логера
    private static final Logger log = Logger.getLogger(OrderLogic.class);

    public void doOrder(){
        // логіка
        System.out.println("Замовлення оформлене!");
        // логування інфо
        log.info("Інформаційне повідомлення!");
        addToCart();
    }

    private void addToCart() {
        // додавання товару до корзини
        System.out.println("Товар доданий до корзини");
        // логування еррору
        log.error("Повідомлення про помилку");
    }
}
