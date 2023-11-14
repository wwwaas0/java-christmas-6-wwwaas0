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

    public void start() {
        getVisiteDate();
        getTotalPaymentBefore();
        getTotalDiscount();
    }

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

    private HashMap<DiscountType, Integer> getDiscounts() {
        Discount discount = new Discount(date, totalPaymentBeforeDiscount, order);
        OutputView.totalDiscounts(discount.getDiscounts());
        return discount.getDiscounts();
    }

    private void getTotalDiscount() {
        HashMap<DiscountType, Integer> discountTypes = getDiscounts();

        int totalDiscount = 0;
        for (DiscountType discountType : discountTypes.keySet()) {
            if(discountType != DiscountType.GIFT){
                totalDiscountAmount += discountTypes.get(discountType);
            }
            totalDiscount += discountTypes.get(discountType);
        }
        OutputView.totalDiscountPayment(totalDiscount);
        getExpectedPayment();
        OutputView.eventOnDecember(totalDiscount);
    }

    private void getExpectedPayment() {
        int expectedAmount = totalPaymentBeforeDiscount - totalDiscountAmount;
        OutputView.expectedPayment(expectedAmount);
    }
}
