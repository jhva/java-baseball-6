package baseball.entity;


import static baseball.constants.BaseBallGameNumber.CHECK_STRIKE_MAX;
import static baseball.constants.BaseBallMessage.CHECK_GAME_EXIT_NUMBER;
import static baseball.constants.BaseBallMessage.GAME_START;

import baseball.utils.InputView;
import baseball.utils.MessageUtils;
import java.util.Objects;

public class BaseBallGame {

    private boolean hasGame = true;
    private final Computer computer;

    public BaseBallGame() {
        this.computer = new Computer();
    }


    public void start(InputView inputView) {
        System.out.println(GAME_START);
        computer.randomGenerator();
        while (hasGame) {
            inputView.printFromUserView();
            int[] userScore = computer.userMatchesComputerRandom(inputView.printToInputView());
            int strike = userScore[1];
            MessageUtils.commonFormatter(userScore);
            checkForStrike(inputView, strike);
        }
    }

    public void checkForStrike(InputView inputView, int strike) {
        if (strike == CHECK_STRIKE_MAX) {
            boolean hasThreeStrike = MessageUtils.hasCurrentThreeStrike(strike);
            stop(inputView, hasThreeStrike);
        }
    }

    public void stop(InputView inputView, boolean hasThreeStrike) {
        if (hasThreeStrike) {
            validateGameControllerValue(inputView.printGameContinueFromUserInput());
        }
    }


    public void validateGameControllerValue(String userInput1or2) {
        if (Objects.equals(userInput1or2, CHECK_GAME_EXIT_NUMBER)) {
            hasGame = false;
        }
        reset();
    }

    public void reset() {
        if (hasGame) {
            computer.randomGenerator();
        }
    }
}