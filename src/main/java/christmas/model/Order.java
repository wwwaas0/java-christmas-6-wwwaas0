package christmas.model;

import christmas.view.InputView;

import java.util.HashMap;
import java.util.List;

public class Order {
    private final HashMap<Menu, Integer> orders;
    private final int totalPayment;

    public Order(HashMap<Menu, Integer> orders, int totalPayment) {
        this.orders = orders;
        this.totalPayment = totalPayment;
    }
}
