package lotto.domain;

import static lotto.domain.Lotto.*;
import static lotto.domain.LottoNumbers.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {

    public static final int LOTTO_PRICE = 1000;

    public List<Lotto> issue(int money) {
        validateMoney(money);

        return Stream.generate(this::issue)
            .limit(money / LOTTO_PRICE)
            .collect(Collectors.toList());
    }

    private void validateMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 한장도 구매할 수 없습니다");
        }
    }

    private Lotto issue() {
        List<Integer> numbers = Stream.iterate(MIN_LOTTO_NUMBER, x -> x + 1)
            .limit(MAX_LOTTO_NUMBER)
            .collect(Collectors.toList());
        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = numbers.subList(0, LOTTO_SIZE);
        return new Lotto(lottoNumbers);
    }
}
