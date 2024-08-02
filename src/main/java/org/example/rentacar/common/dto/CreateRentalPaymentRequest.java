package org.example.rentacar.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateRentalPaymentRequest {
    private int cardExpirationMonth;
    private int cardExpirationYear;
    private String cardNumber;
    private String cardholder;
    private String cardCvv;
    private double price;
}
