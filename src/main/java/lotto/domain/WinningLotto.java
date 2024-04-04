package lotto.domain;

import java.util.Collection;

public class WinningLotto {

    public static final int WINNING_LOTTO_SIZE = 6;
    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(Collection<Integer> winningNumbers, Integer bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.lottoNumbers = new LottoNumbers(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private void validate(Collection<Integer> winningNumbers, Integer bonusNumber) {
        validateNumbersSize(winningNumbers);
        validateUnique(winningNumbers, bonusNumber);
    }

    private void validateNumbersSize(Collection<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_LOTTO_SIZE) {
            throw new IllegalArgumentException("당첨로또는 6개의 숫자와 보너스 숫자여야 합니다");
        }
    }

    private void validateUnique(Collection<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨로또의 보너스 숫자는 6개 숫자와 겹치면 안됩니다");
        }
    }

    public Prize match(Lotto lotto) {
        int matchCount = lotto.countMatch(lottoNumbers);
        boolean isBonusMatched = lotto.contains(bonusNumber);
        return Prize.of(matchCount, isBonusMatched);
    }
}
