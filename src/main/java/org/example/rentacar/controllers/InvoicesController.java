package org.example.rentacar.controllers;

import org.example.rentacar.business.abstracts.InvoiceService;
import org.example.rentacar.business.dto.requests.create.CreateInvoiceRequest;
import org.example.rentacar.business.dto.requests.update.UpdateInvoiceRequest;
import org.example.rentacar.business.dto.responses.create.CreateInvoiceResponse;
import org.example.rentacar.business.dto.responses.get.Invoice.GetAllInvoicesResponse;
import org.example.rentacar.business.dto.responses.get.Invoice.GetInvoiceResponse;
import org.example.rentacar.business.dto.responses.update.UpdateInvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/invoices")
public class InvoicesController {
    private final InvoiceService service;

    @GetMapping
    public List<GetAllInvoicesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetInvoiceResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public CreateInvoiceResponse add(@RequestBody CreateInvoiceRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateInvoiceResponse update(@PathVariable int id, @RequestBody UpdateInvoiceRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
