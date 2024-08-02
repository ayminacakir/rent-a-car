package org.example.rentacar.business.dto.requests.create;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateMaintenanceRequest {
    private int carId; //Bakım yapılacak aracın kimliği.
    private String information;

}
