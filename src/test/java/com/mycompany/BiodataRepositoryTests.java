package com.mycompany;

import com.mycompany.employees.Biodata;
//package org.springframework.data.repository;
import com.mycompany.employees.BiodataRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class BiodataRepositoryTests {
    @Autowired private BiodataRepository repo;

    @Test
    public void testAddNew(){
        Biodata biodata = new Biodata();
        biodata.setAddress("9 Welwyn Close, M24 659, Manchester, UK");
        biodata.setEmail("jubril@gmail.com");
        biodata.setFirstName("Jubril");
        biodata.setLastName("Hassan");
        biodata.setPassword("Jubril156.");
        biodata.setLevel("Lvl12");
        biodata.setPhoneNumber("07825640980");
        biodata.setTaxId("Tl8795");

        Biodata savedBiodata = repo.save(biodata);
        Assertions.assertThat(savedBiodata).isNotNull();
        Assertions.assertThat(savedBiodata.getId()).isGreaterThan(0);

    }

    @Test
    public void testListAll(){
        Iterable<Biodata> biodatas= repo.findAll();
        Assertions.assertThat(biodatas).hasSizeGreaterThan(0);

        for (Biodata biodata : biodatas) {
            System.out.println(biodata);
        }
    }

    @Test
    public void testUpdate(){
        Integer biodataId = 1;
        Optional<Biodata> optionalBiodata=repo.findById(biodataId);
        Biodata biodata = optionalBiodata.get();
        biodata.setLevel("Lvl11");
        repo.save(biodata);

        Biodata updatedBiodata = repo.findById(biodataId).get();
        Assertions.assertThat(updatedBiodata.getLevel()).isEqualTo("Lvl11");

    }

    @Test
    public void testGet(){
        Integer biodataId = 1;
        Optional<Biodata> optionalBiodata=repo.findById(biodataId);
        Assertions.assertThat(optionalBiodata).isPresent();
        System.out.println(optionalBiodata.get());

    }

    @Test
    public void testDelete(){
        Integer biodataId = 1;
        repo.deleteById(biodataId);
        Optional<Biodata> optionalBiodata=repo.findById(biodataId);
        Assertions.assertThat(optionalBiodata).isNotPresent();


    }
}
