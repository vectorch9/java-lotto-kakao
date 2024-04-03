package lotto.random;

import static lotto.domain.Lotto.LOTTO_SIZE;
import static lotto.domain.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MIN_LOTTO_NUMBER;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;

public class RandomLottoMachine extends LottoMachine {

    private final List<Integer> numbers;

    public RandomLottoMachine() {
        this.numbers = Stream.iterate(MIN_LOTTO_NUMBER, x -> x + 1)
                             .limit(MAX_LOTTO_NUMBER)
                             .collect(Collectors.toList());
    }

    @Override
    protected Lotto issue() {
        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = numbers.subList(0, LOTTO_SIZE);
        return new Lotto(lottoNumbers);
    }
}
