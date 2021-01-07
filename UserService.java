package com.hcl.service;

import java.util.List;

import com.hcl.exception.ApplicationException;
import com.hcl.model.Pet;
import com.hcl.model.User;

public interface UserService {
  
	public void doesUserExists(User user) throws ApplicationException;
	public void addUser(User user);
	public void buyPet(long petId,User user);
	public List<Pet> getMyPets(User user);
}
