package baseball.entity;

public class BaseBallGame extends Computer {


    public void start(InputView view) {
        while (true) {
            randomGenerator();
            view.printFromUserView();
            int[] s = userMatchesComputerRandom(view.printToInputView());
        }
    }

    public void stop() {
    }

    public void reset() {
    }
}
