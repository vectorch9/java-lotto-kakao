package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    public static final int WINNING_LOTTO_SIZE = 7;
    private final LottoNumber lottoNumber;

    public WinningLotto(List<Integer> winningNumbers, Integer bonusNumber) {
        List<Integer> numbers = new ArrayList<>(winningNumbers);
        numbers.add(bonusNumber);
        validateNumbersSize(numbers);
        this.lottoNumber = new LottoNumber(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != WINNING_LOTTO_SIZE) {
            throw new IllegalArgumentException("당첨로또는 6개의 숫자와 보너스 숫자여야 합니다");
        }
    }
}
