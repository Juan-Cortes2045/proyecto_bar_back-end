package com.sena.barMJC.shared.service;

import java.util.List;

public interface CrudService<
    RESPONSE,
    CREATE,
    UPDATE,
    ID
> {

    List<RESPONSE> findAll();
    
    RESPONSE findById(ID id);

    RESPONSE create(CREATE dto);

    RESPONSE update(ID id, UPDATE dto);

    void delete(ID id);


}
