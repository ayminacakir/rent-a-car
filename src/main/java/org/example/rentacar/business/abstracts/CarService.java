package org.example.rentacar.business.abstracts;

import org.example.rentacar.business.dto.requests.create.CreateCarRequest;
import org.example.rentacar.business.dto.requests.update.UpdateCarRequest;
import org.example.rentacar.business.dto.responses.create.CreateCarResponse;
import org.example.rentacar.business.dto.responses.get.Car.GetAllCarsResponse;
import org.example.rentacar.business.dto.responses.get.Car.GetCarResponse;
import org.example.rentacar.business.dto.responses.get.Maintenance.GetAllMaintenanceResponse;
import org.example.rentacar.business.dto.responses.update.UpdateCarResponse;
import org.example.rentacar.entities.enums.State;

import java.util.List;

public interface CarService {
    List<GetAllCarsResponse> getAll(boolean includeMaintenance);
    GetCarResponse getById(int id);
    CreateCarResponse add(CreateCarRequest request);
    UpdateCarResponse update(int id, UpdateCarRequest request);
    void delete(int id);
    public void changeState(int carId, State state);

    List<GetAllMaintenanceResponse> showMaintenances(int id);


}
