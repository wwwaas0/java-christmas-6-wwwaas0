package christmas.validator;

import christmas.model.Menu;

import java.util.HashMap;

public class OrderValidator {
    //    음료만 주문시 주문 불가
    public static void isOnlyDrinks(HashMap<Menu, Integer> orders) {
        boolean othersWithoutDrinks = false;
        for (Menu menu : orders.keySet()) {
            if(!menu.getCategory().equals("음료")){
                othersWithoutDrinks = true;
            }
        }
        if(othersWithoutDrinks == false){
            throw new IllegalArgumentException("음료만 주문시 주문 불가합니다.");
        }
    }
//    메뉴는 한번에 최대 20개까지만 주문 가능

//    총 주문 금액 10,000원 이상부터 이벤트(할인?) 적용
}
