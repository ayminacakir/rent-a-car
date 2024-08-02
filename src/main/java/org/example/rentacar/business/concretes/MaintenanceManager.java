package org.example.rentacar.business.concretes;

import org.example.rentacar.abstracts.MaintenanceRepository;
import org.example.rentacar.business.abstracts.CarService;
import org.example.rentacar.business.abstracts.MaintenanceService;
import org.example.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import org.example.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import org.example.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import org.example.rentacar.business.dto.responses.get.Maintenance.GetAllMaintenanceResponse;
import org.example.rentacar.business.dto.responses.get.Maintenance.GetMaintenanceResponse;
import org.example.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;
import org.example.rentacar.business.rules.MaintenanceBusinessRules;
import org.example.rentacar.entities.concretes.Maintenance;
import org.example.rentacar.entities.enums.State;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService {
    private final MaintenanceRepository repository;
    private final ModelMapper mapper;
    private final CarService carService;
    private final MaintenanceBusinessRules rules;

    @Override
    public List<GetAllMaintenanceResponse> getAll() {
        List<Maintenance> maintenances = repository.findAll();
        return maintenances
                .stream()
                .map(maintenance -> mapper.map(maintenance, GetAllMaintenanceResponse.class))
                .toList();
    }

    @Override
    public GetMaintenanceResponse getById(int id) {
        rules.checkIfMaintenanceExist(id);
        Maintenance maintenance = repository.findById(id).orElseThrow();
        return mapper.map(maintenance, GetMaintenanceResponse.class);
    }

    @Override
    public GetMaintenanceResponse returnCarFromMaintenance(int carId) {
        rules.checkIfCarIsNotUnderMaintenance(carId);
        Maintenance maintenance = repository.findMaintenanceByCarIdAndIsCompletedFalse(carId);
        maintenance.setCompleted(true);
        maintenance.setEndDate(LocalDateTime.now());
        repository.save(maintenance);
        carService.changeState(carId, State.AVAILABLE);

        return mapper.map(maintenance, GetMaintenanceResponse.class);
    }

    @Override
    public CreateMaintenanceResponse add(CreateMaintenanceRequest request) {
        rules.checkCarAvailabilityForMaintenance(carService.getById(request.getCarId()).getState());
        rules.checkIfCarUnderMaintenance(request.getCarId());
        Maintenance maintenance = mapper.map(request, Maintenance.class);
        maintenance.setId(0);
        maintenance.setCompleted(false);
        maintenance.setStartDate(LocalDateTime.now());
        maintenance.setEndDate(null);

        carService.changeState(request.getCarId(), State.MAINTENANCE);
        repository.save(maintenance);

        return mapper.map(maintenance, CreateMaintenanceResponse.class);
    }

    @Override
    public UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request) {
        rules.checkIfMaintenanceExist(id);
        Maintenance maintenance = mapper.map(request, Maintenance.class);
        maintenance.setId(id);
        repository.save(maintenance);

        return mapper.map(maintenance, UpdateMaintenanceResponse.class);
    }

    @Override
    public void delete(int id) {
        rules.checkIfMaintenanceExist(id);
        makeCarAvailableIfIsCompletedFalse(id);
        repository.deleteById(id);

    }


    private void makeCarAvailableIfIsCompletedFalse(int id) {
        int carId = repository.findById(id).get().getCar().getId();
        if (repository.existsByCarIdAndIsCompletedFalse(carId))
            carService.changeState(carId, State.AVAILABLE);
    }
}