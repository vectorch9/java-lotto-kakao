package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Prize {
    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIFTH(5000, 3, false),
    NONE(0, 0, false);

    private final int reward;
    private final int matchCount;
    private final boolean bonusMatched;

    Prize(int reward, int matchCount, boolean bonusMatched) {
        this.reward = reward;
        this.matchCount = matchCount;
        this.bonusMatched = bonusMatched;
    }

    public static Prize of(int matchCount, boolean bonusMatched) {
        return Arrays.stream(values())
            .filter(prize -> filterPrize(prize, matchCount, bonusMatched))
            .findFirst()
            .orElse(Prize.NONE);
    }

    private static boolean filterPrize(Prize prize, int matchCount, boolean bonusMatched) {
        return matchCount >= prize.matchCount && ((bonusMatched == prize.bonusMatched) || !prize.bonusMatched);
    }

    public int getReward() {
        return this.reward;
    }

    public boolean isBonusMatched() {
        return bonusMatched;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static List<Prize> reversedValuesForReward() {
        List<Prize> prizes = Arrays.asList(Prize.values());
        Collections.reverse(prizes);
        return prizes.stream()
            .filter(Prize::isNotNone)
            .collect(Collectors.toList());
    }

    private boolean isNotNone() {
        return this != NONE;
    }
}
