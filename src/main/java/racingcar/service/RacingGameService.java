package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.CarNameParser;
import racingcar.util.ValidUtil;

import java.util.List;

import static racingcar.constant.ErrorMessages.CAR_COUNT_ERROR_MESSAGE;
import static racingcar.constant.ErrorMessages.CAR_NAME_DUPLICATE_ERROR_MESSAGE;
import static racingcar.constant.ServiceConstants.MIN_CAR_COUNT;

public class RacingGameService {
    public List<Car> createCarsWithUniqueName(String input){
        List<String> carNames = CarNameParser.parse(input);
        validateCarCount(carNames);
        validateUniqueCarNames(carNames);
        return CarFactory.generateCars(carNames);
    }

    private void validateCarCount(List <String> carNames){
        if(carNames.size() < MIN_CAR_COUNT){
            throw new IllegalArgumentException(CAR_COUNT_ERROR_MESSAGE);
        }
    }
    private void validateUniqueCarNames(List<String>carNames){
        if(ValidUtil.isDuplicate(carNames)){
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
