package christmas.validator;

public class InputValidator {
    //    식당 방문 날짜
//    숫자 아닌 것 입력
    public static void isDigit(String date) {
        try {
            Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력이 숫자가 아닙니다.");
        }
    }

    //    1~31 벗어난 숫자 입력
    public static void outOfRange(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException("없는 날짜입니다.");
        }
    }

//    주문할 메뉴 및 개수 입력
//    메뉴판에 없는 메뉴 입력
//    메뉴 입력이 예시와 다름
//    메뉴 개수가 1 이상이 아님


}
