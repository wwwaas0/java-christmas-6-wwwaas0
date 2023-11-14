package christmas.controller;

import christmas.model.*;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class InputController {

    public VisitDate getVisitDate() {
        VisitDate visitDate = new VisitDate(InputView.visitDate());
        return visitDate;
    }

    public Order getOrders() {
        Order order = new Order(InputView.orderMenus());
        return order;
    }
}
