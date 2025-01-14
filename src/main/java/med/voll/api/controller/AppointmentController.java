package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.appointment.AppointmentBooking;
import med.voll.api.domain.appointment.AppointmentBookingData;
import med.voll.api.domain.appointment.AppointmentDetailmentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentBooking schedule;

    @PostMapping
    @Transactional
    public ResponseEntity book(@RequestBody @Valid AppointmentBookingData data) {
        schedule.book(data);
        return ResponseEntity.ok(new AppointmentDetailmentData(null, null, null, null));
    }
}
