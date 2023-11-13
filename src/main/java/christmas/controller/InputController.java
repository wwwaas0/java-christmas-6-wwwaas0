package christmas.controller;

import christmas.model.Discount;
import christmas.model.Order;
import christmas.model.VisitDate;
import christmas.view.InputView;

public class InputController {

//    get식당 예상 방문 날짜
    /*
    InputView에서 입력 받은 후, Discount 객체에 저장
     */
    public VisitDate getVisitDate(){
        VisitDate visitDate = new VisitDate(InputView.visitDate());
        return visitDate;
    }

//    get주문할 메뉴 및 개수
    /*
    InputView에서 입력 받은 후, Order 객체의 해시맵에 저장
     */
    public VisitDate getOrders(){

    }

//    크리스마스 디데이 할인의 1000원에 추가로 적용되는 +a 구하기
    /*
    예상 방문 날짜 받아서 계산
     */
}
