package com.mycompany.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BiodataService {
    @Autowired private BiodataRepository repo;

    public List<Biodata> listAll(){
        return (List<Biodata>) repo.findAll();
    }

    public void save(Biodata biodata) {
        repo.save(biodata);
    }

    public Biodata get(Integer id) throws UserNotFoundException{
        Optional<Biodata> result =repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("Could not find any users with ID" + id);
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count = repo.countById(id);
        if(count == null || count ==0){
            throw new UserNotFoundException("Could not find any users with ID" + id);

        }

            repo.deleteById(id);
    }
}
