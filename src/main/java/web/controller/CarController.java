package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarServiceImpl carService;

    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping
    public String printCar(ModelMap model, @RequestParam(required = false) String count) {
        if (count == null) {
            model.addAttribute("cars", carService.index());
        } else {
            model.addAttribute("cars", carService.countedCar(count));
        }

        System.out.println(count);
        return "cars";
    }

}
