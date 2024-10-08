package org.example.rentacar.controllers;

import org.example.rentacar.business.abstracts.BrandService;
import org.example.rentacar.business.dto.requests.create.CreateBrandRequest;
import org.example.rentacar.business.dto.requests.update.UpdateBrandRequest;
import org.example.rentacar.business.dto.responses.create.CreateBrandResponse;
import org.example.rentacar.business.dto.responses.get.Brand.GetAllBrandsResponse;
import org.example.rentacar.business.dto.responses.get.Brand.GetBrandResponse;
import org.example.rentacar.business.dto.responses.get.Model.GetAllModelsResponse;
import org.example.rentacar.business.dto.responses.update.UpdateBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/api/brands")
public class BrandsController {
    private final BrandService service;

    @GetMapping
    public List<GetAllBrandsResponse>getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetBrandResponse
    getById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBrandResponse add (@RequestBody CreateBrandRequest request) {
        return service.add(request);
    }
    @PutMapping("/{id}")
    public UpdateBrandResponse update(@PathVariable int id, @RequestBody UpdateBrandRequest request){
        return service.update(id,request);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
    @GetMapping("/models-of-{id}")
    public List<GetAllModelsResponse> getModels(@PathVariable int id) {
        return service.showModels(id);
    }
}
