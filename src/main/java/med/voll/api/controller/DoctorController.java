package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.doctor.Doctor;
import med.voll.api.model.doctor.DoctorRegistryData;
import med.voll.api.model.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;
    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DoctorRegistryData data) {
        repository.save(new Doctor(data));
    };

    @GetMapping
    public List<Doctor> list() {

    }
}
