package org.example.rentacar.business.dto.requests.update;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateRentalRequest {
    private int CarId;
    private int rentedForDays;
    private double dailyPrice;
    private LocalDateTime startDate;

}
