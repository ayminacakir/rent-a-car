package org.example.rentacar.controllers;

import org.example.rentacar.business.abstracts.MaintenanceService;
import org.example.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import org.example.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import org.example.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import org.example.rentacar.business.dto.responses.get.Maintenance.GetAllMaintenanceResponse;
import org.example.rentacar.business.dto.responses.get.Maintenance.GetMaintenanceResponse;
import org.example.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/maintenances")
public class MaintenanceController {
    private final MaintenanceService service;

    @GetMapping
    public List<GetAllMaintenanceResponse> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public GetMaintenanceResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateMaintenanceResponse add(@RequestBody CreateMaintenanceRequest request){
        return service.add(request);
    }
    @PutMapping("/return")
    public GetMaintenanceResponse returnCarFromMaintenance(@RequestParam int carId){
        return service.returnCarFromMaintenance(carId);
    }
    @PutMapping("/{id}")
    public UpdateMaintenanceResponse update(@PathVariable int id, @RequestBody UpdateMaintenanceRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}
