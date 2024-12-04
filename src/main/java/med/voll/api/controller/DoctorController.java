package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.doctor.Doctor;
import med.voll.api.model.doctor.DoctorListData;
import med.voll.api.model.doctor.DoctorRegistryData;
import med.voll.api.model.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public Page<DoctorListData> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        return repository.findAll(pagination).map(DoctorListData::new);
    }
}
