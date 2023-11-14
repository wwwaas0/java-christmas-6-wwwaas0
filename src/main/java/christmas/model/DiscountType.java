package christmas.model;

public enum DiscountType {
    CHRISTMAS_D_DAY(1000, "크리스마스 디데이 할인"),
    WEEKDAY(2023, "평일 할인"),
    WEEKEND(2023, "주말 할인"),
    SPECIAL(1000, "특별 할인"),
    GIFT(25000, "증정 이벤트"),
    NO_DISCOUNT(0, "적용되는 할인 없음");

    private final int discountPrice;
    private final String koreanName;

    DiscountType(int discountPrice, String koreanName) {
        this.discountPrice = discountPrice;
        this.koreanName = koreanName;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }
}
