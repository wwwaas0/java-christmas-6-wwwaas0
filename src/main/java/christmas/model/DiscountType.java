package christmas.model;

public enum DiscountType {
    CHRISTMAS_D_DAY(1000),
    WEEKDAY(2023),
    WEEKEND(2023),
    SPECIAL(1000),
    GIFT(25000),
    NO_DISCOUNT(0);

    private final int discountPrice;

    DiscountType(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }
}
