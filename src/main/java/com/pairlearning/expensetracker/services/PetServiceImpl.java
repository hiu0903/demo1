package com.pairlearning.expensetracker.services;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pairlearning.expensetracker.domain.Pet;
import com.pairlearning.expensetracker.exceptions.EtBadRequestException;
import com.pairlearning.expensetracker.exceptions.EtResourceNotFoundException;
import com.pairlearning.expensetracker.repositories.PetRepository;



@Service
@Transactional
public class PetServiceImpl implements PetService{

	@Autowired
    PetRepository petRepository;
	
	@Override
	public List<Pet> fetchAllPet(Integer uid) {
		return petRepository.findAll(uid);
	}

	@Override
	public Pet fetchPetById(Integer uid) throws EtResourceNotFoundException {
		return petRepository.findById(uid);
	}

	@Override
	public Pet addPet(Integer uid, String name, java.sql.Date birth, String breed, String kind, Timestamp added,
			Timestamp updated, String img) throws EtBadRequestException {
		int petid = petRepository.create(uid,name, birth, breed, kind, added,updated,img);
		return petRepository.findById(uid);
	}

	@Override
	public void updatePet(Integer uid, Pet pet) throws EtBadRequestException {
		petRepository.update(uid, pet);
		
	}

	@Override
	public void removePetWithAllProduct(Integer uid) throws EtResourceNotFoundException {
		this.fetchPetById(uid);
        petRepository.removeById(uid);;
		
	}

}
