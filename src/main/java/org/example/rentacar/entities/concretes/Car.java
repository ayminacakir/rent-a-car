package org.example.rentacar.entities.concretes;

import org.example.rentacar.entities.enums.State;
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
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue
    private int id;
    private String modelYear;
    private String plate;
    private double dailyPrice;

    @Enumerated(EnumType.STRING)
    private State state; //  Available, Rented,  Maintenance

    @ManyToOne
    @JoinColumn (name = "model_id")
    private Model model;

    @OneToMany(mappedBy = "car") //mappedBy = "car" ile bu ilişkinin "Maintenance" sınıfındaki "car" alanıyla ilişkilendirildiğini belirtir.
    private List<Maintenance>maintenances;

    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;

}
