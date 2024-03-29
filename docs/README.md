## 구현 기능 목록
### 입력
* 12월 중 식당 예상 방문 날짜를 입력한다.
    ``````
    - 1~31 사이의 숫자 이외의 것 입력시 error
       "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."
    ``````
    * 크리스마스 디데이 할인: 1일 ~ 25일
    * 평일 할인(일요일~목요일), 주말 할인(금요일, 토요일): 1일 ~ 31일
    * 특별 할인: 3일, 10일, 17일, 24일, 25일, 31일


* 주문할 메뉴 및 개수 입력
    ``````
    - 메뉴판에 없는 메뉴를 입력하는 경우 error
       "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
  
    - 메뉴의 개수가 1 이상의 숫자가 아닐 경우 error
       "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
  
    - 메뉴 입력이 예시와 다른 경우 error
       "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
    ``````
    * 음료만 주문 시, 주문할 수 없다.
    * 메뉴는 한 번에 최대 20개까지만 주문 가능하다.
    * 총 주문 금액 10,000원 이상부터 이벤트가 적용된다.

    * error 발생시 모든 에러 메시지 앞에 "[ERROR]"를 붙인다.
    `````````
  <애피타이저>
  양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)
    
  <메인>
  티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)
    
  <디저트>
  초코케이크(15,000), 아이스크림(5,000)
    
  <음료>
  제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)

### 출력
* 주문 메뉴를 출력한다.
    * 주문 메뉴의 출력 순서는 자유롭게 한다.


* 할인 전 총주문 금액을 출력한다.


* 증정 메뉴를 출력한다.
    * 증정 이벤트에 해당하지 않는 경우, 증정 메뉴 "없음"으로 출력


* 혜택 내역을 출력한다.
    * 고객에게 적용된 이벤트 내역만 출력
    * 적용된 이벤트가 하나도 없다면 혜택 내역 "없음"으로 출력
    * 혜택 내역에 여러 개의 이벤트가 적용된 경우, 출력 순서는 자유롭게 출력
  ```
  크리스마스 디데이 할인: 1,000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가
  평일 할인(일요일~목요일): 디저트 메뉴를 메뉴 1개당 2,023원
  주말 할인(금요일, 토요일): 메인 메뉴를 메뉴 1개당 2,023원 할인
  특별 할인: 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인
  ```


* 총혜택 금액을 출력한다.
    * 총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격


* 할인 후 예상 결제 금액을 출력한다.
    * 할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액


* 12월 이벤트 배지를 출력한다.
    * 총혜택 금액에 따라 이벤트 배지의 이름을 다르게 출력한다.
    * 이벤트 배지가 부여되지 않는 경우, "없음"으로 출력
    ```
  5천 원 이상: 별
  1만 원 이상: 트리
  2만 원 이상: 산타
    ```