package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int promptExpense() {
        System.out.println("구입금액을 입력해주세요.");
        return scanner.nextInt();
    }

    public List<Integer> promptWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return Arrays.stream(nextNotBlankLine().split(","))
                     .map(String::trim)
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    private String nextNotBlankLine() {
        String line = scanner.nextLine();
        if (line.isBlank()) {
            return nextNotBlankLine();
        }
        return line;
    }

    public int promptBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        return scanner.nextInt();
    }
}

