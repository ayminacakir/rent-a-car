package org.example.rentacar.business.abstracts;

import org.example.rentacar.business.dto.requests.create.CreateRentalRequest;
import org.example.rentacar.business.dto.requests.update.UpdateRentalRequest;
import org.example.rentacar.business.dto.responses.create.CreateRentalResponse;
import org.example.rentacar.business.dto.responses.get.Rental.GetAllRentalsResponse;
import org.example.rentacar.business.dto.responses.get.Rental.GetRentalResponse;
import org.example.rentacar.business.dto.responses.update.UpdateRentalResponse;

import java.util.List;

public interface RentalService {
    List<GetAllRentalsResponse> getAll();

    GetRentalResponse getById(int id);

    CreateRentalResponse add(CreateRentalRequest request);

    UpdateRentalResponse update(int id, UpdateRentalRequest request);

    void delete(int id);
}

