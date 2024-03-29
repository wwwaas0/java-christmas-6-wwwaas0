package christmas.view;

import christmas.model.DiscountType;
import christmas.model.Menu;
import christmas.model.Order;

import java.util.HashMap;

public class OutputView {
    public static void info(int date){
        System.out.println("12월 "+date+"일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public static void orderMenu(Order order) {
        System.out.println("\n<주문 메뉴>");
        for (Menu menu : order.getOrders().keySet()) {
            System.out.println(menu.getKoreanName() + " " + order.getOrders().get(menu) + "개");
        }
    }

    public static void paymentBeforDiscount(int payment) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(String.format("%,d원", payment));
    }

    public static void giftMenu(boolean hasGift) {
        System.out.println("\n<증정 메뉴>");
        if (hasGift == true) {
            System.out.println("샴페인 1개");
        }
        if (hasGift == false) {
            System.out.println("없음");
        }
    }

    public static void totalDiscounts(HashMap<DiscountType, Integer> discountTypes) {
        System.out.println("\n<혜택 내역>");
        for (DiscountType discountType : discountTypes.keySet()) {
            if(discountType != DiscountType.NO_DISCOUNT){
                System.out.println(String.format("%s: -%,d원", discountType.getKoreanName(), discountTypes.get(discountType)));
            }
            if(discountType == DiscountType.NO_DISCOUNT){
                System.out.println("없음");
            }
        }
    }

    public static void totalDiscountPayment(int payment) {
        System.out.println("\n<총혜택 금액>");
        if(payment == 0){
            System.out.println(String.format("%,d원", payment));
        }
        if(payment != 0){
            System.out.println(String.format("-%,d원", payment));
        }

    }

    public static void expectedPayment(int payment) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(String.format("%,d원", payment));
    }

    public static void eventOnDecember(int totalDiscount) {
        System.out.println("\n<12월 이벤트 배지>");
        if (totalDiscount < 5000) {
            System.out.println("없음");
        }
        if (totalDiscount >= 5000 && totalDiscount < 10000) {
            System.out.println("별");
        }
        if (totalDiscount >= 10000 && totalDiscount < 20000) {
            System.out.println("트리");
        }
        if (totalDiscount >= 20000) {
            System.out.println("산타");
        }
    }
}
