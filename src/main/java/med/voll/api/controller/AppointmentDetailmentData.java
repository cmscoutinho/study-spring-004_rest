package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.appointment.AppointmentBookingData;

import java.time.LocalDateTime;

public record AppointmentDetailmentData(Long id, Long idDoctor, LocalDateTime date) {}
