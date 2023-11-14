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
    private static Order order;

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
        order = inputController.getOrders();
        OutputView.info(date);
        OutputView.orderMenu(order);

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
    private HashMap<DiscountType, Integer> getDiscounts() {
        Discount discount = new Discount(date, totalPaymentBeforeDiscount, order);
        OutputView.totalDiscounts(discount.getDiscounts());
        return discount.getDiscounts();
    }

    //    총 할인 금액 구하기
    private void getTotalDiscount() {
//        List<DiscountType> discountTypes = getDiscounts();
        HashMap<DiscountType, Integer> discountTypes = getDiscounts();

        int totalDiscount = 0;
        for (DiscountType discountType : discountTypes.keySet()) {
            totalDiscount += discountTypes.get(discountType);
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
