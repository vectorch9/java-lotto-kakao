package lotto.controller;

import java.util.Arrays;
import java.util.List;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;
import lotto.view.View;

public class Controller {
    private final View view;

    public Controller(View view) {
        this.view = view;
    }

    public void run() {
        LottoMachine machine = new LottoMachine();
        int expense = view.promptExpense();
        List<Lotto> lotto = machine.issue(expense);
        view.printLotto(lotto);

        List<Integer> numbers = view.promptWinningNumbers();
        Integer bonus = view.promptBonusNumber();
        WinningLotto winningLotto = new WinningLotto(numbers, bonus);
        Buyer buyer = new Buyer(lotto, winningLotto);

        view.printPrizeHeader();
        Arrays.stream(Prize.values()).forEach(prize -> {
            int prizeCount = buyer.getPrizeCount(prize);
            view.printPrizeInfo(prize.getMatchCount(), prize.isBonusMatched(), prize.getReward(), prizeCount);
        });
        view.printRewardRate(buyer.getRewardRate());
    }
}
