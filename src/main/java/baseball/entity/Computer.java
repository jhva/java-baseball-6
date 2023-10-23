package baseball.entity;


import static baseball.constants.BaseBallGameNumber.RANDOM_RANGE_FINAL_NUMBER;
import static baseball.constants.BaseBallGameNumber.RANDOM_RANGE_START_NUMBER;
import static baseball.constants.BaseBallGameNumber.RANDOM_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> generateRandomComputerValue;

    public void randomGenerator() {

        generateRandomComputerValue = new ArrayList<>();
        while (generateRandomComputerValue.size() < RANDOM_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_RANGE_START_NUMBER, RANDOM_RANGE_FINAL_NUMBER);
            findDuplicatesRandomValue(randomNumber);
        }
    }

    public void findDuplicatesRandomValue(int randomNumber) {
        if (!generateRandomComputerValue.contains(randomNumber)) {
            generateRandomComputerValue.add(randomNumber);
        }
    }

    public int[] userMatchesComputerRandom(List<Integer> userInputValues) {
        int ball = 0;
        int strike = 0;
        int userInputSize = userInputValues.size();
        for (int i = 0; i < userInputSize; i++) {
            int userInputValue = userInputValues.get(i);
            int computerValue = generateRandomComputerValue.get(i);
            strike += countUserValueInComputerRandomStrike(computerValue, userInputValue);
            ball += countUserValueInComputerRandomBall(userInputValue, computerValue);
        }
        return new int[]{ball, strike};
    }

    private int countUserValueInComputerRandomBall(int userInputValue, int computerValue) {
        int ball = 0;
        if (generateRandomComputerValue.contains(userInputValue) && userInputValue != computerValue) {
            ball++;
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

