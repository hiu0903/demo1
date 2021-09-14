package com.pairlearning.expensetracker.repositories;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.pairlearning.expensetracker.domain.Pet;
import com.pairlearning.expensetracker.exceptions.EtBadRequestException;
import com.pairlearning.expensetracker.exceptions.EtResourceNotFoundException;

public interface PetRepository {

	List<Pet> findAll(Integer uid) throws EtResourceNotFoundException;

    Pet findById(Integer uid) throws EtResourceNotFoundException;

    Integer create(Integer uid, String name,java.sql.Date birth, String breed, String kind, Timestamp added, Timestamp updated, String img) throws EtBadRequestException;

    void update( Integer uid, Pet pet) throws EtBadRequestException;
    void removeById(Integer uid);
}
