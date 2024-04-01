package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class PrizeTest {

    // @Test
    // void 숫자를_6개_맞추면_1등이다() {
    //     Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
    //     WinningLotto winning = new WinningLotto(List.of(1,2,3,4,5,6), 7);
    //     Prize prize = Prize.match(winning, lotto);
    //
    //     assertThat(prize).isEqualTo(Prize.FIRST);
    // }
    //
    // @Test
    // void 숫자를_5개_맞추고_보너스_숫자를_맞추면_2등이다() {
    //     Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
    //     WinningLotto winning = new WinningLotto(List.of(1,2,3,4,5,6), 7);
    //     Prize prize = Prize.match(winning, lotto);
    //
    //     assertThat(prize).isEqualTo(Prize.SECOND);
    // }
}
