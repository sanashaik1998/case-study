package com.hcl.service;
import java.util.List;

import com.hcl.model.Pet;
import com.hcl.model.User;
/**
 * 
 * @authors GummadiSunilKumar(51897413),KanumuriSaketh(51897445)
 *
 */
public interface PetService {

	public List<Pet> getAllPets();
	
	public void savePet(Pet pet);
	
}
