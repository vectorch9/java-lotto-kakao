package lotto.support;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;

public class StubLottoMachine extends LottoMachine {

    private final List<Integer> numbers;

    public StubLottoMachine(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public StubLottoMachine() {
        this(List.of(1, 2, 3, 4, 5, 6));
    }

    @Override
    protected Lotto issue() {
        return new Lotto(numbers);
    }
}
