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


}
