package com.sena.barMJC.shared.AbstractCrudController;

import com.sena.barMJC.shared.service.CrudService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractCrudController<
        RESPONSE,
        CREATE,
        UPDATE,
        ID
        > {

    protected abstract CrudService<
            RESPONSE,
            CREATE,
            UPDATE,
            ID> getService();

    @GetMapping
    public ResponseEntity<List<RESPONSE>> findAll() {

        return ResponseEntity.ok(
                getService().findAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<RESPONSE> findById(
            @PathVariable ID id
    ) {

        return ResponseEntity.ok(
                getService().findById(id)
        );
    }

    @PostMapping
    public ResponseEntity<RESPONSE> create(
            @RequestBody CREATE dto
    ) {

        RESPONSE response = getService().create(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RESPONSE> update(
            @PathVariable ID id,
            @RequestBody UPDATE dto
    ) {

        return ResponseEntity.ok(
                getService().update(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable ID id
    ) {

        getService().delete(id);

        return ResponseEntity.noContent().build();
    }
}