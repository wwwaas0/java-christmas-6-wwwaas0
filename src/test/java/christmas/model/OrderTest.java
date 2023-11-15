package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderTest {
    @DisplayName("알맞은 주문 내역을 출력한다.")
    @Test
    void 주문_내역_테스트(){
        String orders = "티본스테이크-1,타파스-1,초코케이크-1,제로콜라-2";

        assertThatThrownBy(() -> new Order(orders))
                .hasMessageContaining("티본스테이크 1개")
                .hasMessageContaining("타파스 1개")
                .hasMessageContaining("초코케이크 1개")
                .hasMessageContaining("제로콜라 2개");
    }
}
