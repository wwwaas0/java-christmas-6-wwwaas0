package christmas.model;

import java.util.List;

public class Discount {
    private final List<DiscountType> discounts;
    private final int visitDate;

    public Discount(List<DiscountType> discounts, int visitDate) {
        this.discounts = discounts;
        this.visitDate = visitDate;
    }

//    날짜를 매개변수에 받고, 어떤 할인이 해당되는지 반환
}
