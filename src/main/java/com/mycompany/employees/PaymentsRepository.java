package com.mycompany.employees;

import org.springframework.data.repository.CrudRepository;

public interface PaymentsRepository extends CrudRepository<Payments, Integer> {
}
