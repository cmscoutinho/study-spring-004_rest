package med.voll.api.domain.doctor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    public Page<Doctor> findByActiveTrue(Pageable pagination);

    Doctor chooseRandomDoctorAvailableInDate(Speciality speciality, LocalDateTime date);
}
