package lotto.domain;

public enum Prize {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    NONE(0);

    private final int reward;

    Prize(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return this.reward;
    }
}