package org.example.rentacar.controllers;

import org.example.rentacar.business.abstracts.RentalService;
import org.example.rentacar.business.dto.requests.create.CreateRentalRequest;
import org.example.rentacar.business.dto.requests.update.UpdateRentalRequest;
import org.example.rentacar.business.dto.responses.create.CreateRentalResponse;
import org.example.rentacar.business.dto.responses.get.Rental.GetAllRentalsResponse;
import org.example.rentacar.business.dto.responses.get.Rental.GetRentalResponse;
import org.example.rentacar.business.dto.responses.update.UpdateRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rentals")
public class RentalsController {
    private final RentalService service;

    @GetMapping
    public List<GetAllRentalsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetRentalResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateRentalResponse add(@RequestBody CreateRentalRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateRentalResponse update(@PathVariable int id, @RequestBody UpdateRentalRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}