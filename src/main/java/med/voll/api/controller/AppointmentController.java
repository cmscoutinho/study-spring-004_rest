package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.appointment.AppointmentBookingData;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @PostMapping
    @Transactional
    public ResponseEntity book(@RequestBody @Valid AppointmentBookingData data) {
        System.out.println(data);
        return ResponseEntity.ok(new AppointmentDetailmentData(id, idDoctor, idPatient, data));
    }
}
