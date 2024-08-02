package org.example.rentacar.abstracts;

import org.example.rentacar.entities.concretes.Car;
import org.example.rentacar.entities.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {
    List<Car> findAllByStateIsNot(State state);
}

