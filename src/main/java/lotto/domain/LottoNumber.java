package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 숫자는 1에서 45 사이여야 합니다");
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LottoNumber) {
            return number == ((LottoNumber) obj).number;
        }
        return false;
    }
}
