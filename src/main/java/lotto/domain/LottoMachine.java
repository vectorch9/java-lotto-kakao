package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class LottoMachine {

    public static final long LOTTO_PRICE = 1000;

    public List<Lotto> issue(long money) {
        validateMoney(money);

        return Stream.generate(this::issue)
                     .limit(money / LOTTO_PRICE)
                     .collect(Collectors.toList());
    }

    private void validateMoney(long money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 한장도 구매할 수 없습니다");
        }
    }

    abstract protected Lotto issue();
}
