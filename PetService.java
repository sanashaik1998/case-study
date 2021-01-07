package com.hcl.service;
import java.util.List;

import com.hcl.model.Pet;
import com.hcl.model.User;
public interface PetService {

	public List<Pet> getAllPets();
	
	public void savePet(Pet pet);
	
}
