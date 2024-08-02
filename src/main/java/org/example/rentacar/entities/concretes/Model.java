package org.example.rentacar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private List<Car> cars;
}
//brand: @ManyToOne ile belirtilen ilişki, her modelin bir markaya ait olduğunu belirtir. @JoinColumn(name = "brand_id") ile bu ilişkinin "brand_id" kolonuyla ilişkilendirildiğini belirtir.
//cars: @OneToMany(mappedBy = "model") ile belirtilen ilişki, her modelin birden fazla arabası olabileceğini belirtir.
// mappedBy = "model" ile bu ilişkinin "Car" sınıfındaki "model" alanıyla ilişkilendirildiğini belirtir