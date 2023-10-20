package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> generateRandomComputerValue;

    public void randomGenerator() {

        generateRandomComputerValue = new ArrayList<>();

        while (generateRandomComputerValue.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
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
        int userInputValuesLen = userInputValues.size();

        for (int i = 0; i < userInputValuesLen; i++) {
            int userInputValue = userInputValues.get(i);
            ball = countUserValueInComputerRandomBall(userInputValue);
            strike = countUserValueInComputerRandomStrike(i, userInputValue);
        }
        return new int[]{ball, strike};
    }


    public int countUserValueInComputerRandomBall(int userInputValue) {
        int ball = 0;
        if (hasUserValueInComputerValue(userInputValue)) {
            ball++;
        }
        return ball;
    }

    public boolean hasUserValueInComputerValue(int userInputValue) {
        return generateRandomComputerValue.contains(userInputValue);
    }

    public int countUserValueInComputerRandomStrike(int idx, int userInputValue) {
        int strike = 0;
        Integer computerValue = generateRandomComputerValue.get(idx);
        if (computerValue.equals(userInputValue)) {
            strike++;
        }
        return strike;
    }
}
