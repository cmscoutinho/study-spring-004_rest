package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<DoctorListData>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        //return repository.findAll(pagination).map(DoctorListData::new);
        var page = repository.findByActiveTrue(pagination).map(DoctorListData::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DoctorUpdateData data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.updateInfo(data);

        return ResponseEntity.ok(new DoctorDetailmentData(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        //repository.deleteById(id);
        var doctor = repository.getReferenceById(id);
        doctor.delete();
        return ResponseEntity.noContent().build();
    }
}
