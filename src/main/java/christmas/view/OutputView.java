package christmas.view;

import christmas.model.DiscountType;
import christmas.model.Menu;
import christmas.model.Order;

import java.util.List;

public class OutputView {
    public static void info(int date){
        System.out.println("12월 +"+date+"일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    //    주문 메뉴 출력
    public static void orderMenu(Order order) {
        System.out.println("\n<주문 메뉴>");
        for (Menu menu : order.getOrders().keySet()) {
            System.out.println(menu.getKoreanName() + " " + order.getOrders().get(menu) + "개");
        }
    }

    //    할인 전 총 주문 금액 출력
    public static void paymentBeforDiscount(int payment) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(String.format("%,d원", payment));
    }

    //    증정 메뉴 출력
    /*
    boolean값으로 증정 메뉴 있는지 없는지 받아와서
    있으면, 샴페인 1개 증정
    없으면, 없음 출력
     */
    public static void giftMenu(boolean hasGift) {
        System.out.println("\n<증정 메뉴>");
        if (hasGift == true) {
            System.out.println("샴페인 1개");
        }
        if (hasGift == false) {
            System.out.println("없음");
        }
    }

    //    혜택 내역 출력
    public static void totalDiscounts(List<DiscountType> discountTypes) {
        System.out.println("\n<혜택 내역>");
        for (DiscountType discountType : discountTypes) {
            System.out.println(String.format(""));
            //할인 한국어 이름도 이넘 상수에 추가하기
        }
    }

    //    총 혜택 금액 출력
    public static void totalDiscountPayment(int payment) {
        System.out.println("\n<총혜택 금액>");
        if(payment == 0){
            System.out.println(String.format("%,d원", payment));
        }
        if(payment != 0){
            System.out.println(String.format("-%,d원", payment));
        }

    }

    //    할인 후 예상 결제 금액 출력
    public static void expectedPayment(int payment) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(String.format("%,d원", payment));
    }

    //    12월 이벤트 배지 출력
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
