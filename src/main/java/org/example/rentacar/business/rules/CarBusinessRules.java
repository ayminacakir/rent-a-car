package org.example.rentacar.business.rules;

import org.example.rentacar.abstracts.CarRepository;
import org.example.rentacar.common.constants.Messages;
import org.example.rentacar.core.exceptions.BusinessException;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarBusinessRules {
    private final CarRepository repository;

    // Business rules
    public void checkIfCarExists(int id) {
        if (!repository.existsById(id)) throw new BusinessException(Messages.Car.NotExists);

    }
}
