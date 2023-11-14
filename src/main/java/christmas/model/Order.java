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
                newOrders = isDuplicateMenu(menuAndNumber, newOrders);
            }
            validate(newOrders);
            return newOrders;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            InputView.orderMenus();
        }
        return null;
    }

    private HashMap<Menu, Integer> isDuplicateMenu(List<String> menuAndNumber, HashMap<Menu, Integer> newOrders) {
        Menu menu = getMenuByKoreanName(menuAndNumber.get(0));
        if (newOrders.containsKey(menu)) {
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            InputView.orderMenus();
        }
        if (!newOrders.containsKey(menu)) {
            int menuNumber = Integer.parseInt(menuAndNumber.get(1));
            newOrders.put(menu, menuNumber);
        }

        return newOrders;
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
