package baseball.entity;

import baseball.utils.MessageUtils;

public class BaseBallGame extends Computer {


    public void start(InputView inputView) {
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
