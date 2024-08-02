package org.example.rentacar.business.dto.requests.create;


import org.example.rentacar.common.constants.Regex;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarRequest {
    private int modelId;

    @Min(1998)
    private int modelYear;

    @Min(1)
    private double dailyPrice;
    @Pattern(regexp = Regex.Plate, message = "Invalid Licence Plate Code")
    private String plate;
}
