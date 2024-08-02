package org.example.rentacar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int rentedForDays;
    private double dailyPrice;
    private double totalPrice;
    private LocalDateTime startDate;

    @ManyToOne //birden fazla kiralama kaydı bir araba ile ilişkili olabilir.
    @JoinColumn(name = "car_id")
    private Car car;
}
