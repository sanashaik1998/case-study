package com.hcl.dao;

import java.util.List;

import com.hcl.model.Pet;
import com.hcl.model.User;

public interface PetDao {

	public List<Pet> getAllPets();
	
	public void savePet(Pet pet);
}
