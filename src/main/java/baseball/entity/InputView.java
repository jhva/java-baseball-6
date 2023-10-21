package baseball.entity;

import static baseball.exception.ErrorMsg.ERROR_USER_INPUT_SIZE_VALUE;
import static baseball.utils.MessageUtils.PLEASE_ASK_NUMBER;
import static baseball.utils.MessageUtils.USER_MAX_SIZE;

import baseball.exception.UserInputSizeException;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {


    public void printFromUserView() {
        System.out.print(PLEASE_ASK_NUMBER);
    }

    public String printGameContinueFromUserInput() {
        return Console.readLine();
    }

    public List<Integer> printToInputView() {
        String[] userInputValue = Console.readLine().split("");
        checkUserInputSize(userInputValue.length);
        return Arrays.stream(userInputValue).mapToInt(Integer::valueOf).
                boxed().collect(Collectors.toList());
    }

    public void checkUserInputSize(int userInputLen) {
        if (userInputLen != USER_MAX_SIZE) {
            throw new UserInputSizeException(ERROR_USER_INPUT_SIZE_VALUE);
        }
    }
}
