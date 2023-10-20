package baseball.utils;

import java.util.Arrays;

public class MessageUtils {

    public static final String GAME_START = "숫자 야구 게임을 시작합니다. ";
    public static final String PLEASE_ASK_NUMBER = "숫자를 입력해주세요 : ";
    public static final String GAME_EXIT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_BASEBALL_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String NOTHING_BASEBALL = "낫싱";

    public static final String COMMON_MATCHES_MSG = "%d볼 %d스트라이크";


    public static final int USER_INPUT_THREE_SIZE = 3;
    public static final int CHECK_STRIKE_MIN = 1;
    public static final int CHECK_BALL_MIN = 1;

    public static void commonFormatter(int[] userScore) {
        int ball = userScore[0];
        int strike = userScore[1];
        validateNothingBall(userScore);
        allMatcherFromUserScoreSizeTwo(ball, strike);
        ballFormatter(ball);
        strikeFormatter(strike);
    }

    public static void allMatcherFromUserScoreSizeTwo(int ball, int strike) {
        if (ball >= CHECK_BALL_MIN && strike >= CHECK_STRIKE_MIN) {
            String allMatcherSizeTwo = String.format(COMMON_MATCHES_MSG, ball, strike);
            System.out.println(allMatcherSizeTwo);
        }


    }

    public static void ballFormatter(int ball) {
        String[] formatSplit = COMMON_MATCHES_MSG.split(" ");
        String formatterBallMsg = String.format(formatSplit[0], ball);
        if (ball >= CHECK_BALL_MIN) {
            System.out.println(formatterBallMsg);
        }
    }

    public static void strikeFormatter(int strike) {
        String[] formatSplit = COMMON_MATCHES_MSG.split(" ");
        String formatterStrikeMsg = String.format(formatSplit[1], strike);
        if (strike >= CHECK_STRIKE_MIN) {
            System.out.print(formatterStrikeMsg);
        }
    }

    public static void validateNothingBall(int[] userScores) {
        if (Arrays.stream(userScores).allMatch(score -> score == 0)) {
            System.out.println(NOTHING_BASEBALL);
        }
    }

}
