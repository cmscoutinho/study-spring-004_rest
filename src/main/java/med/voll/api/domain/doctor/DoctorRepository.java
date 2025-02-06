package med.voll.api.domain.doctor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    public Page<Doctor> findByActiveTrue(Pageable pagination);

    @Query("""
            SELECT d FROM Doctor d
            WHERE d.active = true AND d.speciality = :speciality AND d.id NOT in(
                SELECT a.doctor.id FROM Appointment a
                WHERE a.date = :date 
            ) 
            ORDER BY rand()
            LIMIT 1
            """)
    Doctor chooseRandomDoctorAvailableInDate(Speciality speciality, LocalDateTime date);

    @Query("""
            SELECT m.active 
            FROM Doctor m
            WHERE m.id = :id
            """)
    boolean findActiveById(Long id);
}
