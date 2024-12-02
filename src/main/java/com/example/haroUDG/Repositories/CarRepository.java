package com.example.haroUDG.Repositories;

import com.example.haroUDG.Models.CarModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CarRepository extends CrudRepository<CarModel,Long> {

    public abstract Optional<CarModel> findByVin(long vin);
    public abstract Optional<CarModel> findByBrand(String brand);
}
