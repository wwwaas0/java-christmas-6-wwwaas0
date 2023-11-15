package christmas.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import christmas.validator.InputValidator;
import christmas.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    @DisplayName("1~31 외의 날짜를 입력한 경우")
    @Test
    void 범위_외_날짜_테스트() {
        String invalidDate = "32";

        assertThatThrownBy(() -> new VisitDate(invalidDate))
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @DisplayName("주어진 주문 형식에 맞지 않는 경우")
    @Test
    void 주문_형식_테스트() {
        String invalidOrder = "티본스테이크-1 바비큐립-1 초코케이크-2 제로콜라-1";

        assertThatThrownBy(() -> new Order(invalidOrder))
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("중복 주문한 경우")
    @Test
    void 중복_주문_테스트() {
        String invalidOrder = "티본스테이크-1,제로콜라-1,초코케이크-2,제로콜라-1";

        assertThatThrownBy(() -> new Order(invalidOrder))
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    //메뉴에 없는 음식 주문
    @DisplayName("메뉴에 없는 음식을 주문한 경우")
    @Test
    void 없는_메뉴_테스트() {
        String invalidOrder = "티본스테이크-1,토마호크-1,제로콜라-1";

        assertThatThrownBy(() -> new Order(invalidOrder))
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    //음료만 시킨 경우
    @DisplayName("음료만 주문한 경우")
    @Test
    void 음료만_주문_테스트() {
        String invalidOrder = "제로콜라-2,레드와인-1";

        assertThatThrownBy(() -> new Order(invalidOrder))
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    //20개 넘는 메뉴 시킨 경우
    @DisplayName("음료만 주문한 경우")
    @Test
    void 주문_20개_이상_테스트() {
        String invalidOrder = "제로콜라-4,레드와인-2,티본스테이크-4,초코케이크-2,크리스마스파스타-2,해산물파스타-2,양송이수프-4,바비큐립-4";

        assertThatThrownBy(() -> new Order(invalidOrder))
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
