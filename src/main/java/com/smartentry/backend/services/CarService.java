package com.smartentry.backend.services;

import com.smartentry.backend.domain.Car;
import com.smartentry.backend.domain.CarCompany;
import com.smartentry.backend.domain.dto.CarCompanyDTO;
import com.smartentry.backend.domain.dto.CarDTO;
import com.smartentry.backend.repositories.CarCompanyRepository;
import com.smartentry.backend.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Transactional(readOnly = true)
    public Car findById(Integer id) {
        Optional<Car> result = carRepository.findById(id);
        return result.orElseThrow();
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car insert(CarDTO obj) {
        return fromDto(obj);
    }

    private Car fromDto(CarDTO obj) {
        Car newObj = new Car();
        newObj.setId(obj.getId());
        newObj.setModelo(obj.getModelo());
        newObj.setAno(obj.getAno());
        newObj.setPlaca(obj.getPlaca());
        newObj.setStatus(obj.getStatus());

        return carRepository.save(newObj);

    }
}
