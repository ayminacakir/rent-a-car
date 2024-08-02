package org.example.rentacar.business.abstracts;

import org.example.rentacar.business.dto.requests.create.CreateModelRequest;
import org.example.rentacar.business.dto.requests.update.UpdateModelRequest;
import org.example.rentacar.business.dto.responses.create.CreateModelResponse;
import org.example.rentacar.business.dto.responses.get.Car.GetAllCarsResponse;
import org.example.rentacar.business.dto.responses.get.Model.GetAllModelsResponse;
import org.example.rentacar.business.dto.responses.get.Model.GetModelResponse;
import org.example.rentacar.business.dto.responses.update.UpdateModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();

    GetModelResponse getById(int id);

    CreateModelResponse add(CreateModelRequest request);

    UpdateModelResponse update(int id, UpdateModelRequest request);

    void delete(int id);

    List<GetAllCarsResponse> showCars(int id);
}
