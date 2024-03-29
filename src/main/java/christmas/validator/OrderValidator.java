package christmas.validator;

import christmas.model.Menu;

import java.util.HashMap;

public class OrderValidator {
    public static void isOnlyDrinks(HashMap<Menu, Integer> orders) {
        boolean othersWithoutDrinks = false;
        for (Menu menu : orders.keySet()) {
            if (!menu.getCategory().equals("음료")) {
                othersWithoutDrinks = true;
            }
        }
        if (othersWithoutDrinks == false) {
            throw new IllegalArgumentException("[ERROR] 음료만 주문시 주문 불가합니다.");
        }
    }

    public static void maxOrder(HashMap<Menu, Integer> orders) {
        if (orders.keySet().size() > 20) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문 가능합니다.");
        }
    }


}
