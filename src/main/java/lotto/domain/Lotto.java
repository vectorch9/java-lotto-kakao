package lotto.domain;

import java.util.List;

public class Lotto {

    public static final int LOTTO_SIZE = 6;

    private final LottoNumbers numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersLength(numbers);
        this.numbers = new LottoNumbers(numbers);
    }

    private void validateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 숫자는 6개여야 합니다");
        }
    }

    public LottoNumbers getNumbers() {
        return numbers;
    }
}
