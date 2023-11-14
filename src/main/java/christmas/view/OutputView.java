package christmas.view;

import christmas.model.DiscountType;
import christmas.model.Menu;
import christmas.model.Order;

import java.util.List;

public class OutputView {
    //    주문 메뉴 출력
    public static void orderMenu(Order order) {
        System.out.println("<주문 메뉴>");
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
        System.out.println(String.format("-%,d", payment));
    }

    //    할인 후 예상 결제 금액 출력
    public static void expectedPayment(int payment) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(String.format("%,d원", payment));
    }

//    12월 이벤트 배지 출력
    /*
    총 혜택 금액을 매개 변수로 받고 그에 따라 출력
    5천 원 미만: 없음
    5천 원 이상: 별
    1만 원 이상: 트리
    2만 원 이상: 산타
     */
}
