package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.appointment.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentBooking schedule;

    @PostMapping
    @Transactional
    public ResponseEntity book(@RequestBody @Valid AppointmentBookingData data) {
        var dto = schedule.book(data);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancel(@RequestBody @Valid AppointmentCancellationData data) {
        schedule.cancel(data);
        return ResponseEntity.noContent().build();
    }
}
