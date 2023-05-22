package com.mycompany.employees;

import org.springframework.data.repository.CrudRepository;

public interface BiodataRepository extends CrudRepository <Biodata, Integer>{
    public Long countById(Integer id);

}
