package lotto;

import lotto.controller.Controller;
import lotto.domain.LottoMachine;
import lotto.random.RandomLottoMachine;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        LottoMachine lottoMachine = new RandomLottoMachine();
        Controller controller = new Controller(view, lottoMachine);

        controller.run();
    }
}
