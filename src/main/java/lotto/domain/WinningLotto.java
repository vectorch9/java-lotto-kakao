package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final LottoNumber lottoNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        this.lottoNumber = new LottoNumber(numbers);
    }
}
