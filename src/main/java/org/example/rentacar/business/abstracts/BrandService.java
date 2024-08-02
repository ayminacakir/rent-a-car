package org.example.rentacar.business.abstracts;

import org.example.rentacar.business.dto.requests.create.CreateBrandRequest;
import org.example.rentacar.business.dto.requests.update.UpdateBrandRequest;
import org.example.rentacar.business.dto.responses.create.CreateBrandResponse;
import org.example.rentacar.business.dto.responses.get.Brand.GetAllBrandsResponse;
import org.example.rentacar.business.dto.responses.get.Brand.GetBrandResponse;
import org.example.rentacar.business.dto.responses.get.Model.GetAllModelsResponse;
import org.example.rentacar.business.dto.responses.update.UpdateBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    GetBrandResponse getById(int id);

    CreateBrandResponse add(CreateBrandRequest request);

    UpdateBrandResponse update(int id, UpdateBrandRequest request);

    void delete(int id);

    List<GetAllModelsResponse> showModels(int id);
}