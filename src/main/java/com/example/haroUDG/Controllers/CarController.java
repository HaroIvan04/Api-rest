package com.example.haroUDG.Controllers;

import com.example.haroUDG.Models.CarModel;
import com.example.haroUDG.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping()
    public List<CarModel> findAllCarsSaved(){
        return carService.findAllCars();
    }

    @PostMapping()
    public CarModel saveCar(@RequestBody CarModel car){
        return carService.saveCar(car);
    }

    @PutMapping()
    public CarModel updateCar(@RequestBody CarModel car){
        return carService.saveCar(car);
    }

    //Buscar por vin
    @GetMapping("findByVin={vin}") //localhost:8080/car/find-by-vin?
    public Optional<CarModel> findCarByVin(@PathVariable long vin){
        return carService.findCarByVin(vin);
    }

    //Buscar por brand
    @GetMapping("/findByBrand={brand}") //localhost:8080/car/find-by-brand?
    public Optional<CarModel> findCarByBrand(@PathVariable String brand){
        return carService.findCarByBrand(brand);
    }

    @DeleteMapping("/deleteByVin={vin}")
    public String deleteCarByVin(@PathVariable long vin){
        return carService.deleteCarByVin(vin);
    }

    @PutMapping("/updateByVin={vin}")
    public CarModel updateCarByVin(@PathVariable long vin, @RequestBody CarModel car){
        return carService.updateCarByVin(vin, car);
    }


}
