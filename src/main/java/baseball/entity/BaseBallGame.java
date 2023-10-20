package baseball.entity;

import static baseball.utils.MessageUtils.GAME_START;

import baseball.utils.MessageUtils;

public class BaseBallGame extends Computer {


    public void start(InputView inputView) {
        System.out.println(GAME_START);
        while (true) {
            randomGenerator();
            inputView.printFromUserView();
            int[] s = userMatchesComputerRandom(inputView.printToInputView());
            MessageUtils.commonFormatter(s);
        }
    }

    public void stop() {
    }

    public void reset() {
    }
}
