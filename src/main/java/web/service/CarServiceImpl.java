package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    private List<Car> carList = new ArrayList<>();
    private static int CAR_COUNT;

    {
        carList.add(new Car(++CAR_COUNT, "BMW", "RED"));
        carList.add(new Car(++CAR_COUNT, "LADA", "GREY"));
        carList.add(new Car(++CAR_COUNT, "MERCEDES", "WHITE"));
        carList.add(new Car(++CAR_COUNT, "AUDI", "BLACK"));
        carList.add(new Car(++CAR_COUNT, "FIAT", "BLUE"));
    }

    @Override
    public List<Car> index() {
        return carList;
    }

}
