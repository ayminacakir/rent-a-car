package org.example.rentacar.business.dto.requests.update;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class UpdatePaymentRequest {
    @NotNull
    @Min(value = 1)
    private double balance;
}
