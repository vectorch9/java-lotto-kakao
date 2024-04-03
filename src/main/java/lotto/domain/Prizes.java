package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Prizes {

    private final int lottoCount;
    private final Map<Prize, Integer> prizes;

    public Prizes(List<Lotto> lotto, WinningLotto winning) {
        this.lottoCount = lotto.size();
        this.prizes = calculatePrizes(lotto, winning);
    }

    private Map<Prize, Integer> calculatePrizes(List<Lotto> lotto, WinningLotto winning) {
        Map<Prize, Integer> prizes = new EnumMap<>(Prize.class);

        lotto.forEach(element -> {
            Prize prize = winning.match(element);
            Integer count = prizes.getOrDefault(prize, 0);
            prizes.put(prize, count + 1);
        });

        return prizes;
    }

    public Integer count(Prize prize) {
        return prizes.getOrDefault(prize, 0);
    }

    public double getRewardRate(long principal) {
        return (double) sum() / principal;
    }

    private Long sum() {
        return prizes.entrySet().stream()
                     .map(entry -> entry.getKey().getReward(entry.getValue()))
                     .reduce(Long::sum)
                     .orElse(0L);
    }
}
