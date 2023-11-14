package christmas.controller;

import christmas.model.*;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class InputController {

    //    get식당 예상 방문 날짜
    public VisitDate getVisitDate() {
        VisitDate visitDate = new VisitDate(InputView.visitDate());
        return visitDate;
    }

    //    get주문할 메뉴 및 개수
    public Order getOrders() {
        Order order = new Order(InputView.orderMenus());
        return order;
    }
}
