package org.example.rentacar.business.dto.responses.get.Brand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllBrandsResponse {
    private int id;
    private String name;
}

//GetAllBrandsResponse sınıfı, marka bilgilerini içeren bir yanıtın veri yapısını tanımlar ve bu verileri istemciye sunar.