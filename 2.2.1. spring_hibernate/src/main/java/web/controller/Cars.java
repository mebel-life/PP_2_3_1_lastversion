package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller

public class Cars {

    @GetMapping(value = "/cars")
    public String getCar(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1,"bmw", 101));
        cars.add(new Car(2,"vw", 102));
        cars.add(new Car(3,"toyota", 103));
        cars.add(new Car(4,"lada", 104));
        cars.add(new Car(5,"opel", 105));
        cars = cars.stream().filter(car -> car.getCarId() <= count).toList();
        model.addAttribute("cars", cars);
        return "cars";
    }

}