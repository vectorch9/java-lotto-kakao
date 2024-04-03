package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class PrizesTest {

    @Test
    void 로또들의_순위_목록을_구할_수_있다() {
        List<Lotto> lotto = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 3, 4, 5, 7)),
            new Lotto(List.of(1, 2, 3, 4, 5, 7)),
            new Lotto(List.of(1, 2, 3, 4, 7, 8))
        );
        WinningLotto winning = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Prizes prizes = new Prizes(lotto, winning);

        assertAll(
            () -> assertThat(prizes.count(Prize.FIRST)).isOne(),
            () -> assertThat(prizes.count(Prize.SECOND)).isEqualTo(2),
            () -> assertThat(prizes.count(Prize.THIRD)).isZero(),
            () -> assertThat(prizes.count(Prize.FOURTH)).isOne(),
            () -> assertThat(prizes.count(Prize.FIFTH)).isZero(),
            () -> assertThat(prizes.count(Prize.NONE)).isZero()
        );
    }

    @Test
    void 로또_수익률을_구할_수_있다() {
        List<Lotto> lotto = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 3, 4, 5, 7)),
            new Lotto(List.of(1, 2, 3, 4, 5, 7)),
            new Lotto(List.of(1, 2, 3, 4, 7, 8))
        );
        WinningLotto winning = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Prizes prizes = new Prizes(lotto, winning);

        assertThat(prizes.getRewardRate(4000)).isEqualTo(515012.5, within(0.1D));
    }
}
