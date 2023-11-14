package christmas.controller;

import christmas.model.Menu;

import java.util.HashMap;

public class DiscountController {
    private static InputController inputController;
    private static int visiteDate;
//    start 메소드

    //  get할인 전 총 주문 금액 구하기
    /*
    input controller에서 주문 목록 받아와서 총 주문 금액 계산
     */
    public int getTotalPayment(HashMap<Menu, Integer> orders) {
        int total = 0;
        for (Menu menu : orders.keySet()) {
            int price = menu.getPrice();
            int number = orders.get(menu);
            total += price * number;
        }
        return total;
    }


//    get 해당되는 할인 내역 구하기
    /*
    input controller에서 크리스마스 디데이 추가 할인 금액 받아오기
    Discount 클래스에서 방문 날짜, 할인 전 총 주문 금액 주고 어떤 할인이 적용되는지 리스트로 받아오기
     */

//    get 총 혜택 금액 구하기
    /*
    할인 내역 매개변수로 받은 다음, 총 할인 금액 계산
     */

//    할인 후 예상 결제 금액 구하기
    /*
    총 주문 금액, 총 할인 금액 매개변수로 받아서 예상 결제 금액 구하기
    할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액
     */

//    총 할인 금액 구하기
    /*
    총 할인 금액, 증정 메뉴 있는지 없는지 매개변수로 받아와서 총 할인 금액 계산
    총 할인 금액 = 할인 금액의 합계 + 증정 메뉴의 가격
     */
}
