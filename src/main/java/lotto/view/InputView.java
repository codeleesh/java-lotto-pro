package lotto.view;
import util.ServiceUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String SEPARATOR = ",";
    private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public InputView() {}

    public static String inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.next();
    }

    public static String inputManualPurchaseLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력헤주세요.");
        return scanner.next();
    }

    public static BufferedReader inputManualLottoNumbers() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return br;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return ServiceUtil.splitNumbers(scanner.next());
    }

    public static int inputWinningBonusNumbers() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.next());
    }
}
