package baseball.entity;

import static baseball.utils.MessageUtils.RANDOM_RANGE_FINAL_NUMBER;
import static baseball.utils.MessageUtils.RANDOM_RANGE_START_NUMBER;
import static baseball.utils.MessageUtils.RANDOM_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> generateRandomComputerValue;

    protected void randomGenerator() {

        generateRandomComputerValue = new ArrayList<>();

        while (generateRandomComputerValue.size() < RANDOM_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_RANGE_START_NUMBER, RANDOM_RANGE_FINAL_NUMBER);
            findDuplicatesRandomValue(randomNumber);
        }
    }

    protected void findDuplicatesRandomValue(int randomNumber) {
        if (!generateRandomComputerValue.contains(randomNumber)) {
            generateRandomComputerValue.add(randomNumber);
        }
    }

    protected int[] userMatchesComputerRandom(List<Integer> userInputValues) {
        int ball = 0;
        int strike = 0;
        int userInputSize = userInputValues.size();
        for (int i = 0; i < userInputSize; i++) {
            int userInputValue = userInputValues.get(i);
            int computerValue = generateRandomComputerValue.get(i);
            strike += countUserValueInComputerRandomStrike(computerValue, userInputValue);
            ball += countUserValueInComputerRandomBall(userInputValue, userInputSize, i);
        }
        return new int[]{ball, strike};
    }

    private int countUserValueInComputerRandomBall(int userInputValue, int len, int i) {
        int ball = 0;
        for (int j = i + 1; j < len; j++) {
            int computerValue = generateRandomComputerValue.get(j);
            if (userInputValue == computerValue) {
                ball++;
            }
        }

        return ball;
    }

    private int countUserValueInComputerRandomStrike(int computerValue, int userInputValue) {
        int strike = 0;
        if (computerValue == userInputValue) {
            strike++;
        }
        return strike;
    }
}

