package com.hcl.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.model.Pet;

@Repository("petDaoImpl")
public class PetDaoImpl implements PetDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger=LogManager.getLogger(PetDaoImpl.class);
	
	@Override
	public List<Pet> getAllPets() {

        String sql="SELECT * FROM PETS";//Native Query returns a Result Set
		
	
	
	}

	@Override
	public void savePet(Pet pet) {
	
		Session session=sessionFactory.getCurrentSession();
		
		session.save(pet);
	}

}
