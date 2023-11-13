package christmas.validator;

import christmas.model.Menu;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;

public class InputValidator {
    //    식당 방문 날짜
//    숫자 아닌 것 입력
    public static int isDigit(String date) {
        try {
            return Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력이 숫자가 아닙니다.");
        }
    }

    //    1~31 벗어난 숫자 입력
    public static void outOfRange(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException("[ERROR] 없는 날짜입니다.");
        }
    }

    //    주문할 메뉴 및 개수 입력
//    메뉴판에 없는 메뉴 입력
    public static void notOnTheMenu(HashMap<Menu, Integer> orders) {
        for (Menu menu : orders.keySet()) {
            if (!menuExists(menu)) {
                throw new IllegalArgumentException("[ERROR] 메뉴판에 없는 메뉴가 주문되었습니다");
            }
        }
    }

    // 메뉴가 메뉴판에 있는지 확인
    private static boolean menuExists(Menu menu) {
        return EnumSet.allOf(Menu.class).contains(menu);
    }

    //    메뉴 개수가 1 이상이 아님
    public static void moreThan1(Collection<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1) {
                throw new IllegalArgumentException("[ERROR] 메뉴의 개수가 1보다 적습니다.");
            }
        }
    }

}
