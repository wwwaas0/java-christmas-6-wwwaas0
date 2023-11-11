package christmas.model;

public enum Menu {
    MUSHROOM_SOUP("애피타이저", 6000),
    TAPAS("애피타이저", 5500),
    CAESAR_SALAD("애피타이저",8000),
    T_BONE_STEAK("메인",55000),
    BBQ_RIB("메인",54000),
    SEAFOOD_PASTA("메인",35000),
    CHRISTMAS_PASTA("메인",25000),
    CHOCOLATE_CAKE("디저트",15000),
    ICE_CREAM("디저트",5000),
    ZERO_COKE("음료",3000),
    RED_WINE("음료",60000),
    CHAMPAGNE("음료",25000);

    private final String category;
    private final int price;

    Menu(String category, int price) {
        this.category = category;
        this.price = price;
    }
}
