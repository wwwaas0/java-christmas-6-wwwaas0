package christmas.validator;

import christmas.model.Menu;
import christmas.view.InputView;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;

public class InputValidator {
    public static int isDigit(String date) {
        try {
            return Integer.parseInt(date);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            InputView.visitDate();
        }
        return 0;
    }

    public static void outOfRange(int date) {
        if (date < 1 || date > 31) {
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            InputView.visitDate();
        }
    }

    public static void notOnTheMenu(HashMap<Menu, Integer> orders) {
        for (Menu menu : orders.keySet()) {
            if (!menuExists(menu)) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                InputView.orderMenus();
            }
        }
    }

    private static boolean menuExists(Menu menu) {
        return EnumSet.allOf(Menu.class).contains(menu);
    }

    public static void moreThan1(Collection<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                InputView.orderMenus();
            }
        }
    }

}
