package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Prize;
import lotto.domain.Prizes;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public Controller(InputView inputView, OutputView outputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        List<Lotto> lotto = buyLotto();
        int lottoCount = lotto.size();
        WinningLotto winningLotto = publishWinningLotto();

        Prizes prizes = new Prizes(lotto, winningLotto);

        printReward(prizes);
        outputView.printRewardRate(prizes.getRewardRate(LottoMachine.LOTTO_PRICE * lottoCount));
    }

    private List<Lotto> buyLotto() {
        long expense = inputView.promptExpense();

        int manualCount = inputView.promptManualCount();
        List<List<Integer>> manualNumbers = inputView.promptManualNumbers(manualCount);
        List<Lotto> lotto = manualNumbers.stream()
                                         .map(Lotto::new)
                                         .collect(Collectors.toList());
        expense -= LottoMachine.LOTTO_PRICE * manualCount;

        lotto.addAll(lottoMachine.issue(expense));
        outputView.printLotto(lotto, manualCount);
        return lotto;
    }

    private WinningLotto publishWinningLotto() {
        List<Integer> numbers = inputView.promptWinningNumbers();
        Integer bonus = inputView.promptBonusNumber();
        return new WinningLotto(numbers, bonus);
    }

    private void printReward(Prizes prizes) {
        outputView.printPrizeHeader();
        Prize.reversedValuesForReward().forEach(prize -> printPrize(prize, prizes));
    }

    private void printPrize(Prize prize, Prizes prizes) {
        int prizeCount = prizes.count(prize);
        outputView.printPrizeInfo(prize, prizeCount);
    }
}
