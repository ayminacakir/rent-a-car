package org.example.rentacar.business.dto.requests.create;
import org.example.rentacar.business.dto.requests.PaymentRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateRentalRequest {
    private int CarId;
    private int rentedForDays;
    private double dailyPrice;

    private PaymentRequest paymentRequest;


}
