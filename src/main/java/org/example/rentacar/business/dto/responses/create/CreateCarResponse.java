package org.example.rentacar.business.dto.responses.create;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.plaf.nimbus.State;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCarResponse {
    private int id;
    private int modelId;
    private double dailyPrice;
    private int modelYear;
    private String plate;
    private State state;
}
