package org.example.rentacar.abstracts;

import org.example.rentacar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
    boolean existsByNameIgnoreCase(String name);


}
