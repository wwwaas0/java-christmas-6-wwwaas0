package christmas.controller;

import christmas.model.*;
import christmas.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class DiscountController {
    private static InputController inputController = new InputController();
    private static int date;
    private static int totalPaymentBeforeDiscount;
    private static int totalDiscountAmount;

    //    start 메소드
    public void start() {
        getVisiteDate();
        getTotalPaymentBefore();
        getTotalDiscount();
        getExpectedPayment();
        OutputView.eventOnDecember(totalDiscountAmount);
    }

    //  get할인 전 총 주문 금액 구하기
    private void getTotalPaymentBefore() {
        Order order = inputController.getOrders();
        HashMap<Menu, Integer> orders = order.getOrders();
        int total = 0;
        for (Menu menu : orders.keySet()) {
            int price = menu.getPrice();
            int number = orders.get(menu);
            total += price * number;
        }
        totalPaymentBeforeDiscount = total;
        OutputView.paymentBeforDiscount(totalPaymentBeforeDiscount);
    }

    private void getVisiteDate() {
        VisitDate visitDate = inputController.getVisitDate();
        date = visitDate.getVisitDate();
    }

    //    get 해당되는 할인 내역 구하기
    /*
    input controller에서 크리스마스 디데이 추가 할인 금액 받아오기
    Discount 클래스에서 방문 날짜, 할인 전 총 주문 금액 주고 어떤 할인이 적용되는지 리스트로 받아오기
     */
    private List<DiscountType> getDiscounts() {
        Discount discount = new Discount(date, totalPaymentBeforeDiscount);
        System.out.println("방문 날짜: "+date+", 할인 전 주문 금액: "+totalPaymentBeforeDiscount);
        System.out.println("discount 타입들: "+discount.getDiscounts());
        return discount.getDiscounts();
    }

    //    총 할인 금액 구하기
    /*
    총 할인 금액, 증정 메뉴 있는지 없는지 매개변수로 받아와서 총 할인 금액 계산
    총 할인 금액 = 할인 금액의 합계 + 증정 메뉴의 가격
     */
        /*
    할인 내역 매개변수로 받은 다음, 총 할인 금액 계산
     */
    private void getTotalDiscount() {
        int christmasDiscount = inputController.howMuchChristmasDiscount(date);
        List<DiscountType> discountTypes = getDiscounts();

        int totalDiscount = 0;
        for (DiscountType discountType : discountTypes) {

            if (discountType == DiscountType.CHRISTMAS_D_DAY) {
                totalDiscount += christmasDiscount;
            }
            if (discountType != DiscountType.CHRISTMAS_D_DAY) {
                totalDiscount += discountType.getDiscountPrice();
            }
        }
        totalDiscountAmount = totalDiscount;
        OutputView.totalDiscountPayment(totalDiscountAmount);
    }

    //    할인 후 예상 결제 금액 구하기
    /*
    총 주문 금액, 총 할인 금액 매개변수로 받아서 예상 결제 금액 구하기
    할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액
     */
    private void getExpectedPayment() {
        int expectedAmount = totalPaymentBeforeDiscount - totalDiscountAmount;
        OutputView.expectedPayment(expectedAmount);
    }
}
