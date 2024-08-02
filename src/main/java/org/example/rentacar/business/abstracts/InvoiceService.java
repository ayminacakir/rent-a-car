package org.example.rentacar.business.abstracts;

import org.example.rentacar.business.dto.requests.create.CreateInvoiceRequest;
import org.example.rentacar.business.dto.requests.update.UpdateInvoiceRequest;
import org.example.rentacar.business.dto.responses.create.CreateInvoiceResponse;
import org.example.rentacar.business.dto.responses.get.Invoice.GetAllInvoicesResponse;
import org.example.rentacar.business.dto.responses.get.Invoice.GetInvoiceResponse;
import org.example.rentacar.business.dto.responses.update.UpdateInvoiceResponse;

import java.util.List;

public interface InvoiceService {
    List<GetAllInvoicesResponse> getAll();

    GetInvoiceResponse getById(int id);

    CreateInvoiceResponse add(CreateInvoiceRequest request);

    UpdateInvoiceResponse update(int id, UpdateInvoiceRequest request);

    void delete(int id);
}