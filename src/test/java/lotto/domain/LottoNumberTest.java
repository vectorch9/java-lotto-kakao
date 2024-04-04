package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = { 0, 46})
    void 로또_숫자가_1에서_45사이가_아니면_예외를_던진다(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 두_로또_숫자를_비교한다() {
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(1);
        LottoNumber lottoNumber3 = new LottoNumber(2);

        assertAll(
            () -> assertThat(lottoNumber1.equals(lottoNumber2)).isTrue(),
            () -> assertThat(lottoNumber1.equals(lottoNumber3)).isFalse()
        );
    }
}
