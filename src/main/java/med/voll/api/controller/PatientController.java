package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.patient.Patient;
import med.voll.api.model.patient.PatientListData;
import med.voll.api.model.patient.PatientRegistryData;
import med.voll.api.model.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @GetMapping
    public Page<PatientListData> list(@PageableDefault(size = 10, sort = {"name"}, page = 0) Pageable pagination) {
        return repository.findAll(pagination).map(PatientListData::new);
    }

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid PatientRegistryData data) {
        repository.save(new Patient(data));
    }

    @PutMapping("/{id}")
    @Transactional
    public void update(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);
        patient.updateInfo();
    }
}
