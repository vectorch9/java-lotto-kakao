package lotto.controller;

import java.util.List;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;
import lotto.view.View;

public class Controller {
    private final View view;
    private final LottoMachine lottoMachine;

    public Controller(View view) {
        this.view = view;
        this.lottoMachine = new LottoMachine();
    }

    public void run() {
        List<Lotto> lotto = buyLotto();
        WinningLotto winningLotto = issueWinningLotto();

        Buyer buyer = new Buyer(lotto, winningLotto);

        printReward(buyer);
    }

    private List<Lotto> buyLotto() {
        int expense = view.promptExpense();
        List<Lotto> lotto = lottoMachine.issue(expense);
        view.printLotto(lotto);
        return lotto;
    }

    private WinningLotto issueWinningLotto() {
        List<Integer> numbers = view.promptWinningNumbers();
        Integer bonus = view.promptBonusNumber();
        return new WinningLotto(numbers, bonus);
    }

    private void printReward(Buyer buyer) {
        view.printPrizeHeader();
        Prize.reversedValuesForReward().forEach(prize -> printPrize(prize, buyer));
        view.printRewardRate(buyer.getRewardRate());
    }

    private void printPrize(Prize prize, Buyer buyer) {
        int prizeCount = buyer.getPrizeCount(prize);
        view.printPrizeInfo(prize, prizeCount);
    }
}
