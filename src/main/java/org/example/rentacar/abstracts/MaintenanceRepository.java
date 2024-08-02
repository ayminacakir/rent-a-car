package org.example.rentacar.abstracts;

import org.example.rentacar.entities.concretes.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {
    Maintenance findMaintenanceByCarIdAndIsCompletedFalse(int carId);

    boolean existsByCarIdAndIsCompletedFalse(int carId);
}

/*findMaintenanceByCarIdAndIsCompletedFalse(int carId): Verilen carId için tamamlanmamış bakım kaydını döndürür.
existsByCarIdAndIsCompletedFalse(int carId): Verilen carId için tamamlanmamış bakım kaydının var olup olmadığını kontrol eder.
Bu yapılar, belirli bir araç için tamamlanmamış bakım kayıtlarını kolayca bulmanıza ve bu kayıtların varlığını kontrol etmenize yardımcı olur*/