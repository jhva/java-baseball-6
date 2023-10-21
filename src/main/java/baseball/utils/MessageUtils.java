package baseball.utils;

public class MessageUtils {

    public static final String GAME_START = "숫자 야구 게임을 시작합니다. ";
    public static final String PLEASE_ASK_NUMBER = "숫자를 입력해주세요 : ";
    public static final String GAME_EXIT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_BASEBALL_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String NOTHING_BASEBALL = "낫싱";
    public static final String COMMON_MATCHES_MSG = "%d볼 %d스트라이크";
    public static final String CHECK_GAME_EXIT_NUMBER = "2";


    public static final int CHECK_STRIKE_MAX = 3;
    public static final int CHECK_GAME_CONTINUE_NUMBER = 1;
    public static final int CHECK_STRIKE_MIN = 1;
    public static final int CHECK_BALL_MIN = 1;
    public static final int RANDOM_RANGE_START_NUMBER = 1;
    public static final int RANDOM_RANGE_FINAL_NUMBER = 9;
    public static final int RANDOM_SIZE = 3;
    public static final int USER_SCORE_BALL_FIX_INDEX = 0;
    public static final int USER_SCORE_STRIKE_FIX_INDEX = 1;
    public static final int USER_MAX_SIZE = 3;
    public static final int NOTHING_BALL = 0;

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
