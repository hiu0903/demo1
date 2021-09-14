package com.pairlearning.expensetracker.services;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.pairlearning.expensetracker.domain.Pet;
import com.pairlearning.expensetracker.exceptions.EtBadRequestException;
import com.pairlearning.expensetracker.exceptions.EtResourceNotFoundException;

public interface PetService {
	List<Pet> fetchAllPet(Integer uid);

    Pet fetchPetById(Integer ui) throws EtResourceNotFoundException;

    Pet addPet(Integer uid, String name,java.sql.Date birth, String breed, String kind, Timestamp added, Timestamp updated, String img) throws EtBadRequestException;

    void updatePet(Integer uid,Pet pet) throws EtBadRequestException;
    
    void removePetWithAllProduct(Integer uid) throws EtResourceNotFoundException;
}
