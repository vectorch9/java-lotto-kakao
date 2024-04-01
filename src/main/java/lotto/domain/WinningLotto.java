package lotto.domain;

import java.util.Collection;
import java.util.List;

public class WinningLotto {

    public static final int WINNING_LOTTO_SIZE = 6;
    private final LottoNumbers lottoNumbers;
    private final LottoNumbers bonusNumber;

    public WinningLotto(Collection<Integer> winningNumbers, Integer bonusNumber) {
        LottoNumbers lottoNumbers = new LottoNumbers(winningNumbers);
        LottoNumbers bonus = new LottoNumbers(List.of(bonusNumber));
        validate(lottoNumbers, bonus);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonus;
    }

    private void validate(LottoNumbers lottoNumbers, LottoNumbers bonus) {
        validateNumbersSize(lottoNumbers);
        validateUnique(lottoNumbers, bonus);
    }

    private void validateNumbersSize(LottoNumbers numbers) {
        if (numbers.size() != WINNING_LOTTO_SIZE) {
            throw new IllegalArgumentException("당첨로또는 6개의 숫자와 보너스 숫자여야 합니다");
        }
    }

    private void validateUnique(LottoNumbers lottoNumbers, LottoNumbers bonus) {
        if (lottoNumbers.countMatch(bonus) != 0) {
            throw new IllegalArgumentException("당첨로또의 보너스 숫자는 6개 숫자와 겹치면 안됩니다");
        }
    }

    public Prize match(Lotto lotto) {
        int matchCount = lotto.countMatch(lottoNumbers);
        boolean isBonusMatched = lotto.containsAll(bonusNumber);
        return Prize.of(matchCount, isBonusMatched);
    }
}
