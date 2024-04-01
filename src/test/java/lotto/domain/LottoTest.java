package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 7, 8, 9})
    void 로또_숫자는_6개가_아니면_에외를_던진다(int size) {
        List<Integer> numbers = Stream.iterate(1, x -> x + 1).limit(size).collect(Collectors.toList());

        assertThatThrownBy(() -> new Lotto(numbers))
            .isInstanceOf(RuntimeException.class);
    }
}
