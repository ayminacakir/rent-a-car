package org.example.rentacar.abstracts;

import org.example.rentacar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {

    boolean existsByNameIgnoreCase(String name);
}
