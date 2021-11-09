package lotto.enums;

import lotto.domain.MatchResult;

import java.util.Arrays;

public enum Ranking {

    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND_BONUS(5, true, 30_000_000, "5개 일치, 보너스볼 일치"),
    SECOND(5, false, 1_500_000, "5개 일치"),
    THIRD(4, false, 50_000, "4개 일치"),
    FORTH(3, false, 5_000, "3개 일치"),
    MISS(0, false, 0, null);

    private final int correct;
    private final boolean bonusMatch;
    private final int amount;
    private final String message;

    Ranking(int correct, boolean bonusMatch, int amount, String message) {
        this.correct = correct;
        this.bonusMatch = bonusMatch;
        this.amount = amount;
        this.message = message;
    }

    public static Ranking findCorrect(final MatchResult matchResult) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> matchResult.isResultMatch(ranking.correct))
                .filter(ranking -> matchResult.isBonusMatch(ranking.bonusMatch))
                .findAny()
                .orElse(MISS);
    }

    public int getAmount() {
        return this.amount;
    }

    public int getCorrect() {
        return this.correct;
    }

    public String getMessage() { return this.message; }

    public int totalWinningMoney(final int hitCount) {
        return this.amount * hitCount;
    }
}
