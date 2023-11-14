package christmas.model;

public enum DiscountType {
    CHRISTMAS_D_DAY("크리스마스 디데이 할인"),
    WEEKDAY("평일 할인"),
    WEEKEND("주말 할인"),
    SPECIAL("특별 할인"),
    GIFT("증정 이벤트"),
    NO_DISCOUNT("적용되는 할인 없음");
    private final String koreanName;

    DiscountType(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }
}
