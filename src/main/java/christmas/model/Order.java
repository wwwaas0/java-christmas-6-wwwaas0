package christmas.model;

import christmas.validator.InputValidator;
import christmas.validator.OrderValidator;
import christmas.view.InputView;

import java.util.HashMap;
import java.util.List;

public class Order {
    private final HashMap<Menu, Integer> orders;

    public Order(String orders) {
        this.orders = orderProcessing(orders);
    }

    public HashMap<Menu, Integer> getOrders() {
        return orders;
    }

    private HashMap<Menu, Integer> orderProcessing(String orders) {
        try {
            HashMap<Menu, Integer> newOrders = new HashMap<>();
            List<String> orderItems = List.of(orders.split(","));

            for (String item : orderItems) {
                List<String> menuAndNumber = List.of(item.split("-"));

                Menu menu = getMenuByKoreanName(menuAndNumber.get(0));
                int menuNumber = newOrders.getOrDefault(menu, 0) + Integer.parseInt(menuAndNumber.get(1));
                newOrders.put(menu, menuNumber);
            }
            validate(newOrders);
            return newOrders;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("알맞지 않은 주문 형식입니다.");
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

    private void validate(HashMap<Menu, Integer> orders) {
        InputValidator.notOnTheMenu(orders);
        InputValidator.moreThan1(orders.values());
        OrderValidator.maxOrder(orders);
        OrderValidator.isOnlyDrinks(orders);
    }
}
