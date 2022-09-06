package web.service;

import org.springframework.stereotype.Component;
import web.dao.CarDao;
import web.dao.CarDaoImpl;
import web.model.Car;

import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    private final CarDao carDao = new CarDaoImpl();

    @Override
    public List<Car> index() {
        return carDao.getAllCar();
    }

    public List<Car> countedCar(String count) {
        int a = Integer.parseInt(count);
        if (a < 5) {
            return index().subList(0, a);
        } else {
            return index();
        }

    }

}
