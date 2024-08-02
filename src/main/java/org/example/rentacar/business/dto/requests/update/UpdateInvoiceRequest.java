package org.example.rentacar.business.dto.requests.update;
import org.example.rentacar.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateInvoiceRequest {
    private int modelId;
    private double dailyPrice;
    private int modelYear;
    private String plate;
    private State state;
}
