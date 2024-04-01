package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LottoNumberTest {
    @Test
    void 로또_숫자는_1이상_45이하가_아니면_예외를_던진다() {
        assertAll(
            () -> assertThatThrownBy(() -> new LottoNumber(List.of(0,2,3,4,5,6)))
                .isInstanceOf(RuntimeException.class),
            () -> assertThatThrownBy(() -> new LottoNumber(List.of(46,2,3,4,5,6)))
                .isInstanceOf(RuntimeException.class)
        );
    }
}
