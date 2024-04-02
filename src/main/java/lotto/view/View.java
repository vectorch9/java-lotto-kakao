package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import lotto.domain.Lotto;

public class View {

    private final Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }
    public int promptExpense() {
        System.out.println("구입금액을 입력해주세요.");
        return scanner.nextInt();
    }

    public void printLotto(List<Lotto> lotto) {
        System.out.printf("%d개를 구매했습니다.\n", lotto.size());
        lotto.forEach(System.out::println);
        System.out.println();
    }

    public List<Integer> promptWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return Arrays.stream(nextNotEmptyLine().split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private String nextNotEmptyLine() {
        String line = scanner.nextLine();
        while (line.isBlank()) {
            line = scanner.nextLine();
        }
        return line;
    }

    public int promptBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        return scanner.nextInt();
    }

    public void printPrizeHeader() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public void printPrizeInfo(int matchCount, boolean bonusMatched, int reward, int prizeCount) {
        System.out.printf("%d개 일치", matchCount);
        if (bonusMatched) {
            System.out.printf(", 보너스 볼 일");
        }
        System.out.printf(" (%d원) - %d개\n", reward, prizeCount);
    }

    public void printRewardRate(double rate) {
        System.out.printf("총 수익률은 %.2f입니다.\n", rate);
    }
}

