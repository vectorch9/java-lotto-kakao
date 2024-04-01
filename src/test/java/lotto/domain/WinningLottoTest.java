package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 7, 8, 9})
    void 당첨로또는_로또숫자가_6개가_아니면_예외를_던진다(int size) {
        List<Integer> numbers = Stream.iterate(1, x -> x + 1).limit(size).collect(Collectors.toList());

        assertThatThrownBy(() -> new WinningLotto(numbers, 45))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 당첨로또는_중복_숫자가_있으면_예외를_던진다() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6))
            .isInstanceOf(RuntimeException.class);
    }
}
