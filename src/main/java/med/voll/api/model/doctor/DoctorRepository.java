package med.voll.api.model.doctor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    public Page<Doctor> findByActiveTrue(Pageable pagination);
}
