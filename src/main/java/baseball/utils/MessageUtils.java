package baseball.utils;

import static baseball.constants.BaseBallGameNumber.CHECK_BALL_MIN;
import static baseball.constants.BaseBallGameNumber.CHECK_STRIKE_MAX;
import static baseball.constants.BaseBallGameNumber.CHECK_STRIKE_MIN;
import static baseball.constants.BaseBallGameNumber.NOTHING_BALL;
import static baseball.constants.BaseBallGameNumber.USER_SCORE_BALL_FIX_INDEX;
import static baseball.constants.BaseBallGameNumber.USER_SCORE_STRIKE_FIX_INDEX;
import static baseball.constants.BaseBallMessage.COMMON_MATCHES_MSG;
import static baseball.constants.BaseBallMessage.GAME_EXIT;
import static baseball.constants.BaseBallMessage.NOTHING_BASEBALL;
import static baseball.constants.BaseBallMessage.RESTART_BASEBALL_GAME;

public class MessageUtils {

    public static void commonFormatter(int[] userScore) {
        int ball = userScore[0];
        int strike = userScore[1];
        validateNothingBall(ball, strike);
        allMatcherFromUserScoreSizeOne(ball, strike);
        ballFormatter(ball, strike);
        strikeFormatter(strike, ball);
    }

    public static void allMatcherFromUserScoreSizeOne(int ball, int strike) {
        if (ball >= CHECK_BALL_MIN && strike >= CHECK_STRIKE_MIN) {
            String allMatcherSizeTwo = String.format(COMMON_MATCHES_MSG, ball, strike);
            System.out.println(allMatcherSizeTwo);
        }
    }

    public static String splitterCommonMsg(int values, int userScoreCheckIndex) {
        String[] formatSplit = COMMON_MATCHES_MSG.split(" ");
        return String.format(formatSplit[userScoreCheckIndex], values);
    }

    public static void ballFormatter(int ball, int strike) {
        String formatterBallMsg = splitterCommonMsg(ball, USER_SCORE_BALL_FIX_INDEX);
        if (ball > NOTHING_BALL && strike == NOTHING_BALL) {
            System.out.println(formatterBallMsg);
        }
    }

    public static void strikeFormatter(int strike, int ball) {
        String formatterStrikeMsg = splitterCommonMsg(strike, USER_SCORE_STRIKE_FIX_INDEX);
        if (strike > NOTHING_BALL && ball == NOTHING_BALL) {
            System.out.println(formatterStrikeMsg);
        }
    }

    public static boolean hasCurrentThreeStrike(int strike) {
        boolean current = false;
        if (strike == CHECK_STRIKE_MAX) {
            System.out.println(GAME_EXIT);
            System.out.println(RESTART_BASEBALL_GAME);
            current = true;
        }
        return current;
    }

    public static void validateNothingBall(int ball, int strike) {
        if (ball == NOTHING_BALL && strike == NOTHING_BALL) {
            System.out.println(NOTHING_BASEBALL);
        }
    }

}
