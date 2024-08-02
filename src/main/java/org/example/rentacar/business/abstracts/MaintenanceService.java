package org.example.rentacar.business.abstracts;
import org.example.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import org.example.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import org.example.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import org.example.rentacar.business.dto.responses.get.Maintenance.GetAllMaintenanceResponse;
import org.example.rentacar.business.dto.responses.get.Maintenance.GetMaintenanceResponse;
import org.example.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;

import java.util.List;

public interface MaintenanceService {
    List<GetAllMaintenanceResponse> getAll();

    GetMaintenanceResponse getById(int id);

    GetMaintenanceResponse returnCarFromMaintenance(int carId);

    CreateMaintenanceResponse add(CreateMaintenanceRequest request);

    UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request);

    void delete(int id);

}