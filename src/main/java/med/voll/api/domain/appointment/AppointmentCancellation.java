package med.voll.api.domain.appointment;

import med.voll.api.domain.ValidationException;
import org.springframework.stereotype.Service;

@Service
public class AppointmentCancellation {

    public void cancel(AppointmentCancellationData data) {
        if (!appointmentRepository.existsById(data.idConsulta())) {
            throw new ValidationException("The given appointment id doesn't exist!");
        }
    }
}
