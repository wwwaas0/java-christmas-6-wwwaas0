package christmas.model;

import christmas.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class Discount {
    private final List<DiscountType> discounts;

    public Discount(int date, int paymentBeforeDiscount) {
        this.discounts = getDiscounts(date, paymentBeforeDiscount);
    }

    public List<DiscountType> getDiscounts() {
        return discounts;
    }

    //    날짜를 매개변수에 받고, 어떤 할인이 해당되는지 반환
    public List<DiscountType> getDiscounts(int date, int paymentBeforeDiscount) {
        List<DiscountType> discountTypes = new ArrayList<>();
        if(isDiscout(paymentBeforeDiscount)){
            if(isGift(paymentBeforeDiscount)){
                discountTypes.add(DiscountType.GIFT);
            }
            if(isChristmasDay(date)){
                discountTypes.add(DiscountType.CHRISTMAS_D_DAY);
            }
            if(isWeekday(date)){
                discountTypes.add(DiscountType.WEEKDAY);
            }
            if(isWeekend(date)){
                discountTypes.add(DiscountType.WEEKEND);
            }
            if(isSpecialDiscount(date)){
                discountTypes.add(DiscountType.SPECIAL);
            }
        }
        return discounts;
    }

    private boolean isDiscout(int paymentBeforeDiscount) {
        if (paymentBeforeDiscount >= 10000) {
            return true;
        }
        return false;
    }

    private boolean isGift(int paymentBeforeDiscount) {
        if(paymentBeforeDiscount >= 120000){
            return true;
        }
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
