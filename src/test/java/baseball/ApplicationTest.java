package baseball;

import static baseball.exception.ErrorMsg.ERROR_USER_INPUT_DUPLICATE_VALUE;
import static baseball.exception.ErrorMsg.ERROR_USER_INPUT_NOT_NUMERIC_VALUE;
import static baseball.exception.ErrorMsg.ERROR_USER_INPUT_SIZE_VALUE;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자가_입력한_값_중복체크_테스트() {

        String duplicateNumber = "122";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(duplicateNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ERROR_USER_INPUT_DUPLICATE_VALUE)
        );
    }

    @Test
    void 사용자가_0또는_한글을_입력했을경우_예외_테스트() {
        String korean = "한글";
        String numeric0 = "0";
        String english = "english";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(numeric0, korean, english))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ERROR_USER_INPUT_NOT_NUMERIC_VALUE)
        );
    }

    @Test
    void 사용자_입력_길이_값이_3이하인_경우_예외_테스트() {
        String userInputValue = "12";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(userInputValue))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContainingAll(ERROR_USER_INPUT_SIZE_VALUE)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
