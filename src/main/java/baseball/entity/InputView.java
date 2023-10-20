package baseball.entity;

import static baseball.utils.MessageUtils.PLEASE_ASK_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {


    public void printFromUserView() {
        System.out.print(PLEASE_ASK_NUMBER);
    }

    public List<Integer> printToInputView() {
        String[] userInputValue = Console.readLine().split("");
        return Arrays.stream(userInputValue).mapToInt(Integer::valueOf).
                boxed().collect(Collectors.toList());
    }
}
