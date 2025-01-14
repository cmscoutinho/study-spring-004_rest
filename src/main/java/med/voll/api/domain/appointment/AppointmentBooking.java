package med.voll.api.domain.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentBooking {

    @Autowired
    private AppointmentRepository repository;
    public void book(AppointmentBookingData data) {

    }
}
