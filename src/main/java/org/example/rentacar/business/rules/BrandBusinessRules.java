package org.example.rentacar.business.rules;
import org.example.rentacar.abstracts.BrandRepository;
import org.example.rentacar.common.constants.Messages;
import org.example.rentacar.core.exceptions.BusinessException;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private final BrandRepository repository;

    //Business rules
    public void checkIfBrandExists(int id) {
        if (!repository.existsById(id)) throw new BusinessException(Messages.Brand.NotExists);
    }

    public void checkIfBrandExistsByName(String name) {
        if (repository.existsByNameIgnoreCase(name)) throw new BusinessException(Messages.Brand.Exists);
    }

}
