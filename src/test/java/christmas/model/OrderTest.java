package christmas.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @DisplayName("알맞은 할인 전 총 주문 금액을 출력한다.")
    @Test
    void 할인_전_총_주문금액_테스트(){

    }



//    @DisplayName("각 일치하는 로또가 1개씩 나와야한다.")
//    @Test
//    void 당첨_내역_출력_확인(){
//        List<Lotto> lottos = new ArrayList<>();
//        lottos.add(new Lotto("2,14,19,21,24,45"));
//        lottos.add(new Lotto("2,14,19,23,36,41"));
//        lottos.add(new Lotto("2,14,19,23,35,40"));
//        lottos.add(new Lotto("2,14,19,23,35,45"));
//        lottos.add(new Lotto("2,14,19,23,35,44"));
//        lottos.add(new Lotto("3,4,5,6,7,8"));
//
//        Lotto lotto = new Lotto("2,14,19,23,35,44");
//        int bonus = 45;
//
//        Map<LottoResultFormat, Integer> result = new LinkedHashMap<>();
//        result.put(LottoResultFormat.THREE, 1);
//        result.put(LottoResultFormat.FOUR, 1);
//        result.put(LottoResultFormat.FIVE, 1);
//        result.put(LottoResultFormat.FIVE_BONUS, 1);
//        result.put(LottoResultFormat.SIX, 1);
//        result.put(LottoResultFormat.FAIL, 1);
//
//        LottoController lottoController = new LottoController();
//        Assertions.assertThat(lottoController.getLottoResults(lotto.getNumbers(), lottos, bonus)).isEqualTo(result);
//    }
//
//
//    //총 수익률 계산
//    @DisplayName("수익률 계산")
//    @Test
//    void 수익률_계산(){
//        List<Lotto> lottos = new ArrayList<>();
//        lottos.add(new Lotto("2,14,19,21,24,45"));
//        lottos.add(new Lotto("2,14,19,23,36,41"));
//        lottos.add(new Lotto("9,10,11,12,13,14"));
//        lottos.add(new Lotto("3,4,5,6,7,8"));
//        lottos.add(new Lotto("11,12,13,14,15,16"));
//
//        Lotto lotto = new Lotto("2,14,19,23,35,44");
//        int bonus = 45;
//
//        LottoController lottoController = new LottoController();
//        double returnOnLotto = lottoController.calculateReturnOnLotto(lottoController.getLottoResults(lotto.getNumbers(), lottos, bonus), 5000);
//        Assertions.assertThat(returnOnLotto).isEqualTo(1100.0);
//
//    }
}
