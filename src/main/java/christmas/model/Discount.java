package christmas.model;

import christmas.validator.InputValidator;

import java.util.List;

public class Discount {
    private final List<DiscountType> discounts;
//

    public Discount(List<DiscountType> discounts) {
        this.discounts = discounts;
    }

    //    총 주문 금액 10,000원 이상부터 이벤트(할인?) 적용
    public boolean isDiscout(int payment) {
        if (payment >= 10000) {
            return true;
        }
        return false;
    }

    //    날짜를 매개변수에 받고, 어떤 할인이 해당되는지 반환
    public List<DiscountType> getDiscounts(int date) {

    }

    private boolean isWeekday(int date) {
        List<Integer> dates = List.of(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31);
        if(dates.contains(date)){
            return true;
        }
        return false;
    }
}
