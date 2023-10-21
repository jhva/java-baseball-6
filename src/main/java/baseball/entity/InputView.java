package baseball.entity;

import static baseball.exception.ErrorMsg.ERROR_USER_INPUT_DUPLICATE_VALUE;
import static baseball.exception.ErrorMsg.ERROR_USER_INPUT_NOT_NUMERIC_VALUE;
import static baseball.exception.ErrorMsg.ERROR_USER_INPUT_SIZE_VALUE;
import static baseball.utils.MessageUtils.PLEASE_ASK_NUMBER;
import static baseball.utils.MessageUtils.USER_MAX_SIZE;

import baseball.exception.UserInputException;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {


    public void printFromUserView() {
        System.out.print(PLEASE_ASK_NUMBER);
    }

    public String printGameContinueFromUserInput() {
        return Console.readLine();
    }

    public List<Integer> printToInputView() {
        String userInputOnlyNumber = isUserInputNumeric(Console.readLine());
        checkUserInputSize(userInputOnlyNumber.length());
        String[] userInputValues = userInputOnlyNumber.split("");
        return checkDuplicatesAndReturnList(userInputValues);
    }

    public List<Integer> checkDuplicatesAndReturnList(String[] userInputValues) {
        Set<Integer> userInputValueSet = new HashSet<>();
        List<Integer> removeDuplicateAfterValues = new ArrayList<>();
        int idx = 0;
        while (idx < USER_MAX_SIZE) {
            userInputValueSet.add(Integer.parseInt(userInputValues[idx]));
            removeDuplicateAfterValues.add(Integer.parseInt(userInputValues[idx]));
            idx++;
        }
        checkSetLen(userInputValueSet.size());
        return removeDuplicateAfterValues;
    }

    public void checkSetLen(int setLength) {
        if (setLength < USER_MAX_SIZE) {
            throw new UserInputException(ERROR_USER_INPUT_DUPLICATE_VALUE);
        }
    }

    public void checkUserInputSize(int userInputLen) {
        if (userInputLen != USER_MAX_SIZE) {
            throw new UserInputException(ERROR_USER_INPUT_SIZE_VALUE);
        }
    }

    public String isUserInputNumeric(String userInput) {
        boolean isCheckNumberFrom1to9 = userInput.matches("^[1-9]+$");
        if (!isCheckNumberFrom1to9) {
            throw new UserInputException(ERROR_USER_INPUT_NOT_NUMERIC_VALUE);
        }
        return userInput;
    }
}
