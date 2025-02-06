package med.voll.api.domain.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findByActiveTrue(Pageable pagination);

    @Query("""
            SELECT p.active 
            FROM Patient p
            WHERE p.id = :id
            """)
    boolean findActiveById(Long id);
}
