package org.example.rentacar.controllers;

import org.example.rentacar.business.abstracts.ModelService;
import org.example.rentacar.business.dto.requests.create.CreateModelRequest;
import org.example.rentacar.business.dto.requests.update.UpdateModelRequest;
import org.example.rentacar.business.dto.responses.create.CreateModelResponse;
import org.example.rentacar.business.dto.responses.get.Car.GetAllCarsResponse;
import org.example.rentacar.business.dto.responses.get.Model.GetAllModelsResponse;
import org.example.rentacar.business.dto.responses.get.Model.GetModelResponse;
import org.example.rentacar.business.dto.responses.update.UpdateModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/models")
public class ModelsController {
    private final ModelService service;

    @GetMapping
    public List<GetAllModelsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetModelResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateModelResponse add(@RequestBody CreateModelRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateModelResponse update(@PathVariable int id, @RequestBody UpdateModelRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping("/cars-of-{id}")
    public List<GetAllCarsResponse> getModels(@PathVariable int id) {
        return service.showCars(id);
    }
}