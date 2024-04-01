package lotto.domain;

import java.util.List;
import java.util.Set;

public class LottoNumber {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBERS_SIZE = 6;

    public LottoNumber(List<Integer> numbers) {
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersRange(numbers);
        validateNumbersSize(numbers);
        validateNumbersUnique(numbers);
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(Integer number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 숫자는 1에서 45 사이여야 합니다");
        }
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 숫자는 6개여야 합니다");
        }
    }

    private void validateNumbersUnique(List<Integer> numbers) {
        Set<Integer> numbersSet = Set.copyOf(numbers);
        if (numbers.size() != numbersSet.size()) {
            throw new IllegalArgumentException("로또 숫자는 중복되면 안됩니다");
        }
    }
}
