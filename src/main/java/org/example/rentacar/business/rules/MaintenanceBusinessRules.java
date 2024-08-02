package org.example.rentacar.business.rules;

import org.example.rentacar.abstracts.MaintenanceRepository;
import org.example.rentacar.common.constants.Messages;
import org.example.rentacar.core.exceptions.BusinessException;
import org.example.rentacar.entities.enums.State;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class MaintenanceBusinessRules {
    private final MaintenanceRepository repository;
    // Business rules

    public void checkIfMaintenanceExist(int id) {
        if (!repository.existsById(id)) throw new BusinessException(Messages.Maintenance.NotExists);
    }


    public void checkIfCarUnderMaintenance(int carId) {
        if (repository.existsByCarIdAndIsCompletedFalse(carId)) {
            throw new BusinessException(Messages.Maintenance.CarExists);
        }

    }

    public void checkIfCarIsNotUnderMaintenance(int carId) {
        if (!repository.existsByCarIdAndIsCompletedFalse(carId)) {
            throw new BusinessException(Messages.Maintenance.CarNotExists);
        }
    }

    public void checkCarAvailabilityForMaintenance(State state) {
        if (state.equals(State.RENTED)) {
            throw new BusinessException(Messages.Maintenance.CarIsRented);
        }
    }
}