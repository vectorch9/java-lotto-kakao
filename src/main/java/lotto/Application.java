package lotto;

import lotto.controller.Controller;
import lotto.domain.LottoMachine;
import lotto.random.RandomLottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoMachine lottoMachine = new RandomLottoMachine();
        Controller controller = new Controller(inputView, outputView, lottoMachine);

        controller.run();
    }
}
