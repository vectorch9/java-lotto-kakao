package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Buyer {

    private final List<Lotto> lotto;
    private final WinningLotto winning;
    private final Map<Prize, Integer> prizes;

    public Buyer(List<Lotto> lotto, WinningLotto winning) {
        this.lotto = lotto;
        this.winning = winning;
        this.prizes = calculatePrizes(lotto, winning);
    }

    private EnumMap<Prize, Integer> calculatePrizes(List<Lotto> lotto, WinningLotto winning) {
        EnumMap<Prize, Integer> prizes = new EnumMap<>(Prize.class);

        lotto.forEach(element -> {
            Prize prize = winning.match(element);
            Integer count = prizes.getOrDefault(prize, 0);
            prizes.put(prize, count + 1);
        });

        return prizes;
    }

    public Integer getPrizeCount(Prize prize) {
        return prizes.getOrDefault(prize, 0);
    }

    public double getRewardRate() {
        AtomicLong totalReward = new AtomicLong();
        prizes.forEach((prize, count) -> {
            totalReward.addAndGet((long)prize.getReward() * count);
        });
        return (double)totalReward.getPlain() / (lotto.size() * LottoMachine.LOTTO_PRICE);
    }
}
