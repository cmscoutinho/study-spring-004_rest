package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.patient.Patient;
import med.voll.api.model.patient.PatientListData;
import med.voll.api.model.patient.PatientRegistryData;
import med.voll.api.model.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @GetMapping
    public Page<PatientListData> list(Pageable pagination) {
        return repository.findAll(pagination).map(PatientListData::new);
    }

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid PatientRegistryData data) {
        repository.save(new Patient(data));
    }
}
