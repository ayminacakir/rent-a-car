package org.example.rentacar.business.rules;

import org.example.rentacar.abstracts.RentalRepository;
import org.example.rentacar.common.constants.Messages;
import org.example.rentacar.core.exceptions.BusinessException;
import org.example.rentacar.entities.enums.State;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class RentalBusinessRules {
    private final RentalRepository repository;

    public void checkIfRentalExists(int id) {
        if (!repository.existsById(id)) //ID'ye sahip bir kiralama kaydı bulunamazsa, if bloğu çalışır.
            throw new BusinessException(Messages.Rental.NotExists);
    }

    public void checkIfCarAvailable(State state) {
        if (!state.equals(State.AVAILABLE)) {
            throw new BusinessException(Messages.Car.NotAvailable);

        }
    }
}
