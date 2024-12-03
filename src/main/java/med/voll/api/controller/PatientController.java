package med.voll.api.controller;

import med.voll.api.model.patient.PatientRegistryData;
import med.voll.api.model.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    PatientRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody PatientRegistryData data) {
        System.out.println(data);
    }
}
