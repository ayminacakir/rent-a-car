package org.example.rentacar.business.concretes;

import org.example.rentacar.abstracts.InvoiceRepository;
import org.example.rentacar.business.abstracts.InvoiceService;
import org.example.rentacar.business.dto.requests.create.CreateInvoiceRequest;
import org.example.rentacar.business.dto.requests.update.UpdateInvoiceRequest;
import org.example.rentacar.business.dto.responses.create.CreateInvoiceResponse;
import org.example.rentacar.business.dto.responses.get.Invoice.GetAllInvoicesResponse;
import org.example.rentacar.business.dto.responses.get.Invoice.GetInvoiceResponse;
import org.example.rentacar.business.dto.responses.update.UpdateInvoiceResponse;
import org.example.rentacar.business.rules.InvoiceBusinessRules;
import org.example.rentacar.entities.concretes.Invoice;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private final InvoiceRepository repository;
    private final ModelMapper mapper;
    private final InvoiceBusinessRules rules;

    @Override
    public List<GetAllInvoicesResponse> getAll() {

        return repository.findAll().stream()
                .map(invoice -> mapper.map(invoice, GetAllInvoicesResponse.class))
                .toList();
    }

    @Override
    public GetInvoiceResponse getById(int id) {
        Invoice invoice = repository.findById(id).orElseThrow();
        return mapper.map(invoice, GetInvoiceResponse.class);
    }

    @Override
    public CreateInvoiceResponse add(CreateInvoiceRequest request) {
        Invoice invoice = mapper.map(request, Invoice.class);
        invoice.setId(0);
        invoice.setTotalPrice(getTotalPrice(invoice));
        repository.save(invoice);
        return mapper.map(invoice, CreateInvoiceResponse.class);
    }

    @Override
    public UpdateInvoiceResponse update(int id, UpdateInvoiceRequest request) {
        rules.checkIfInvoiceExist(id);
        Invoice invoice = mapper.map(request, Invoice.class);
        invoice.setId(id);
        repository.save(invoice);

        return mapper.map(invoice, UpdateInvoiceResponse.class);
    }

    @Override
    public void delete(int id) {
        rules.checkIfInvoiceExist(id);
        ;
        repository.deleteById(id);

    }


    private double getTotalPrice(Invoice invoice) {
        return invoice.getDailyPrice() * invoice.getRentedForDays();
    }


}