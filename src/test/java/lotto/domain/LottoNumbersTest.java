package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LottoNumbersTest {
    @Test
    void 로또_숫자는_1이상_45이하가_아니면_예외를_던진다() {
        assertAll(
            () -> assertThatThrownBy(() -> new LottoNumbers(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(RuntimeException.class),
            () -> assertThatThrownBy(() -> new LottoNumbers(List.of(46, 2, 3, 4, 5, 6)))
                .isInstanceOf(RuntimeException.class)
        );
    }

    @Test
    void 로또_숫자는_중복_숫자가_있으면_예외를_던진다() {
        assertAll(
            () -> assertThatThrownBy(() -> new LottoNumbers(List.of(2, 2, 3, 4, 5, 6)))
                .isInstanceOf(RuntimeException.class),
            () -> assertThatThrownBy(() -> new LottoNumbers(List.of(6, 2, 3, 4, 5, 6)))
                .isInstanceOf(RuntimeException.class)
        );
    }
}
