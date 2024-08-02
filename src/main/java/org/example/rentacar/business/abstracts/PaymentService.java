package org.example.rentacar.business.abstracts;

import org.example.rentacar.business.dto.requests.create.CreatePaymentRequest;
import org.example.rentacar.business.dto.requests.update.UpdatePaymentRequest;
import org.example.rentacar.business.dto.responses.create.CreatePaymentResponse;
import org.example.rentacar.business.dto.responses.get.Payment.GetAllPaymentsResponse;
import org.example.rentacar.business.dto.responses.get.Payment.GetPaymentResponse;
import org.example.rentacar.business.dto.responses.update.UpdatePaymentResponse;
import org.example.rentacar.common.dto.CreateRentalPaymentRequest;

import java.util.List;

public interface PaymentService {
    List<GetAllPaymentsResponse> getAll();

    GetPaymentResponse getById(int id);

    CreatePaymentResponse add(CreatePaymentRequest request);

    UpdatePaymentResponse update(int id, UpdatePaymentRequest request);

    void delete(int id);
    void processRentalPayment(CreateRentalPaymentRequest request);

}
