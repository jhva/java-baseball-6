package baseball;


import baseball.entity.BaseBallGame;
import baseball.entity.InputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGame baseBallGame = new BaseBallGame();
        InputView inputView = new InputView();
        baseBallGame.start(inputView);
    }
}
