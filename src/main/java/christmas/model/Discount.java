package christmas.model;

import christmas.validator.InputValidator;
import christmas.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Discount {
    private static final int SPECIAL_DISCOUNT = 1000;
    private static final int GIFT_EVENT = 25000;
    private static final int WEEKEND_DISCOUNT = 2023;
    private static final int WEEKDAY_DISCOUNT = 2023;
    private static final int CHRISTMAS_DISCOUNT = 1000;
private final HashMap<DiscountType, Integer> discounts;

    public Discount(int date, int paymentBeforeDiscount, Order order) {
        this.discounts = getDiscounts(date, paymentBeforeDiscount, order);
    }

    public HashMap<DiscountType, Integer> getDiscounts() {
        return discounts;
    }

    public HashMap<DiscountType, Integer> getDiscounts(int date, int paymentBeforeDiscount, Order order) {
        HashMap<DiscountType, Integer> discountTypes = new HashMap<>();
        if(isDiscout(paymentBeforeDiscount)){
            if(isGift(paymentBeforeDiscount)){
                discountTypes.put(DiscountType.GIFT, GIFT_EVENT);
            }
            if(isChristmasDay(date)){
                discountTypes.put(DiscountType.CHRISTMAS_D_DAY, howMuchChristmasDiscount(date));
            }
            if(isWeekday(date)){
                discountTypes.put(DiscountType.WEEKDAY, howMuchWeekdayDiscount(order));
            }
            if(isWeekend(date)){
                discountTypes.put(DiscountType.WEEKEND, howMuchWeekendDiscount(order));
            }
            if(isSpecialDiscount(date)){
                discountTypes.put(DiscountType.SPECIAL, SPECIAL_DISCOUNT);
            }
        }
        if(!isDiscout(paymentBeforeDiscount)){
            discountTypes.put(DiscountType.NO_DISCOUNT, 0);
        }
        return discountTypes;
    }

    public int howMuchChristmasDiscount(int visitDate) {
        int more = visitDate - 1;
        int totalDiscount = CHRISTMAS_DISCOUNT + more * 100;
        return totalDiscount;
    }

    public int howMuchWeekdayDiscount(Order order) {
        DiscountType discountWeekday = DiscountType.WEEKDAY;
        int desertNumber = order.getOrders().getOrDefault(Menu.CHOCOLATE_CAKE, 0) + order.getOrders().getOrDefault(Menu.ICE_CREAM, 0);
        int discount = WEEKDAY_DISCOUNT * desertNumber;
        return discount;
    }

    public int howMuchWeekendDiscount(Order order) {
        DiscountType discountWeekend = DiscountType.WEEKEND;
        int mainNumber = order.getOrders().getOrDefault(Menu.BBQ_RIB, 0) + order.getOrders().getOrDefault(Menu.CHRISTMAS_PASTA, 0)
                + order.getOrders().getOrDefault(Menu.SEAFOOD_PASTA, 0) + order.getOrders().getOrDefault(Menu.T_BONE_STEAK, 0);
        int discount = WEEKEND_DISCOUNT * mainNumber;

        return discount;
    }

    private boolean isDiscout(int paymentBeforeDiscount) {
        if (paymentBeforeDiscount >= 10000) {
            return true;
        }
        return false;
    }

    private boolean isGift(int paymentBeforeDiscount) {
        if(paymentBeforeDiscount >= 120000){
            OutputView.giftMenu(true);
            return true;
        }
        OutputView.giftMenu(false);
        return false;
    }

    private boolean isWeekday(int date) {
        List<Integer> dates = List.of(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31);
        if (dates.contains(date)) {
            return true;
        }
        return false;
    }

    private boolean isWeekend(int date) {
        List<Integer> dates = List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
        if (dates.contains(date)) {
            return true;
        }
        return false;
    }

    private boolean isChristmasDay(int date) {
        if (date <= 25) {
            return true;
        }
        return false;
    }

    private boolean isSpecialDiscount(int date) {
        List<Integer> dates = List.of(3, 10, 17, 24, 25, 31);
        if (dates.contains(date)) {
            return true;
        }
        return false;
    }
}
