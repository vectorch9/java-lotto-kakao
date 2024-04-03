package lotto.controller;

import java.util.List;

import lotto.domain.Prizes;
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
        int lottoCount = lotto.size();
        WinningLotto winningLotto = publishWinningLotto();

        Prizes prizes = new Prizes(lotto, winningLotto);

        printReward(prizes);
        view.printRewardRate(prizes.getRewardRate(LottoMachine.LOTTO_PRICE * lottoCount));
    }

    private List<Lotto> buyLotto() {
        int expense = view.promptExpense();
        List<Lotto> lotto = lottoMachine.issue(expense);
        view.printLotto(lotto);
        return lotto;
    }

    private WinningLotto publishWinningLotto() {
        List<Integer> numbers = view.promptWinningNumbers();
        Integer bonus = view.promptBonusNumber();
        return new WinningLotto(numbers, bonus);
    }

    private void printReward(Prizes prizes) {
        view.printPrizeHeader();
        Prize.reversedValuesForReward().forEach(prize -> printPrize(prize, prizes));
    }

    private void printPrize(Prize prize, Prizes prizes) {
        int prizeCount = prizes.count(prize);
        view.printPrizeInfo(prize, prizeCount);
    }
}
