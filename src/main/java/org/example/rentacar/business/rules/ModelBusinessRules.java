package org.example.rentacar.business.rules;

import org.example.rentacar.abstracts.ModelRepository;
import org.example.rentacar.common.constants.Messages;
import org.example.rentacar.core.exceptions.BusinessException;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelBusinessRules {
    private final ModelRepository repository;
    public void checkIfModelExists(int id){
        if (!repository.existsById(id)) throw new BusinessException(Messages.Model.NotExists);
    }
    public void checkIfModelExistsByName(String name){
        if (repository.existsByNameIgnoreCase(name)) throw  new BusinessException(Messages.Model.Exists);
    }
}
