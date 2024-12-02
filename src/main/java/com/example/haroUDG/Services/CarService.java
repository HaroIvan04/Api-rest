package com.example.haroUDG.Services;

import com.example.haroUDG.Repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Service;
import com.example.haroUDG.Models.CarModel;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public List<CarModel> findAllCars(){
        return (List<CarModel>) carRepository.findAll();
    }

    public CarModel saveCar(CarModel car){
        return carRepository.save(car);
    }

    public Optional<CarModel> findCarByBrand(String brand){
        return carRepository.findByBrand(brand);
    }

    public Optional<CarModel> findCarByVin(long vin){
        return carRepository.findByVin(vin);
    }

    public String deleteCarByVin(long vin){
        String result = "";
        Optional<CarModel> foundCar = findCarByVin(vin);
        if (foundCar.isPresent()){
            carRepository.delete(foundCar.get());
            result = "Car deleted succesfully";
        }
        else{
            result = "Car not found";
        }
        return result;
    }

    public CarModel updateCarByVin(long vin, CarModel car){
        return findCarByVin(vin).isPresent() ? carRepository.save(car) : new CarModel(0L,0L,"Car not found","",0,"",00d);
    }
}
