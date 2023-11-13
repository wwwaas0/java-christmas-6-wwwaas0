package christmas.model;

import christmas.validator.InputValidator;

import java.util.List;

public class Discount {
    private final List<DiscountType> discounts;
    private final int visitDate;

    public Discount(List<DiscountType> discounts, int visitDate) {
        this.discounts = discounts;
        this.visitDate = visitDate;
    }

    private void validate(String date) {
        int intDate = InputValidator.isDigit(date);
        InputValidator.outOfRange(intDate);
    }
//    날짜를 매개변수에 받고, 어떤 할인이 해당되는지 반환
}
