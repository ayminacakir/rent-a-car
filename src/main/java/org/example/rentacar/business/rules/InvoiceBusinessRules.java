package org.example.rentacar.business.rules;
import org.example.rentacar.abstracts.InvoiceRepository;
import org.example.rentacar.common.constants.Messages;
import org.example.rentacar.core.exceptions.BusinessException;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvoiceBusinessRules {
    private final InvoiceRepository repository;

    // Business rules
    public void checkIfInvoiceExist(int id) {
        if (!repository.existsById(id)) throw new BusinessException(Messages.Invoice.NotFound);
    }
}