package org.example.rentacar.business.dto.requests.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateInvoiceRequest {
    private String cardHolder;
    private String modelNAme;
    private String brandName;
    private String plate;
    private int modelYear;
    private double dailyPrice;
    private int rentedForDays;
    private LocalDateTime rentedAt;

}
