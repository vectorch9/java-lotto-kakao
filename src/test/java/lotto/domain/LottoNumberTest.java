package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
    @Test
    void 로또_숫자는_1이상_45이하가_아니면_예외를_던진다() {
        assertAll(
            () -> assertThatThrownBy(() -> new LottoNumber(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(RuntimeException.class),
            () -> assertThatThrownBy(() -> new LottoNumber(List.of(46, 2, 3, 4, 5, 6)))
                .isInstanceOf(RuntimeException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 7, 8, 9})
    void 로또_숫자는_6개가_아니면_에외를_던진다(int size) {
        List<Integer> numbers = Stream.iterate(1, x -> x + 1).limit(size).collect(Collectors.toList());

        assertThatThrownBy(() -> new LottoNumber(numbers))
            .isInstanceOf(RuntimeException.class);
    }
}
