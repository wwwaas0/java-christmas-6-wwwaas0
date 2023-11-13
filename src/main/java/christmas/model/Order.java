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

    public void orderProcessing(String orders){
        List<String> orderItems = List.of(orders.split(","));
        for(String item: orderItems){
            List<String> menuAndNumber = List.of(item.split("-"));
            Menu menu = getMenuByKoreanName(menuAndNumber.get(0));
            this.orders.put(menu, Integer.parseInt(menuAndNumber.get(1)));
        }
    }

    private static Menu getMenuByKoreanName(String koreanName) {
        for (Menu menu : Menu.values()) {
            if (menu.getKoreanName().equals(koreanName)) {
                return menu;
            }
        }
        return null;
    }
}
