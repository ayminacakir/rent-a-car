package org.example.rentacar.abstracts;

import org.example.rentacar.entities.concretes.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    //@Transactional
    //void deleteByRentalId(int rentalId);
}
