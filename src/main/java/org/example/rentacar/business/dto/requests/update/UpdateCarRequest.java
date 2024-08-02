package org.example.rentacar.business.dto.requests.update;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.plaf.nimbus.State;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCarRequest {
    private int modelId;
    private double dailyPrice;
    private int modelYear;
    private String plate;
    private State state;
}