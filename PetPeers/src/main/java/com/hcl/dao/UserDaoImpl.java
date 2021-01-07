package com.hcl.dao;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.exception.ApplicationException;
import com.hcl.model.Pet;
import com.hcl.model.User;


@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	

	
	@Override
	public void doesUserExists(User user) throws ApplicationException {
		
		Long user_count;
		String sql="SELECT COUNT(userId)  FROM User user WHERE user.userName=:username";
		
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(sql);
		query.setString("username",user.getUserName());
		user_count=(Long) query.uniqueResult();
		

		
		if(user_count==1)
		{
		
			throw new ApplicationException("User Name already in use. Please select a different User Name");
		}
	}

	@Override
	public void addUser(User user) {
		Session session=sessionFactory.getCurrentSession();
    	session.save(user);

	}

	@Override
	public void buyPet(long petId,User user) {
	 
		Session session = sessionFactory.getCurrentSession();
		Pet pet = (Pet) session.get(Pet.class,petId);
		pet.setOwner(user);
		session.update(pet);
		
	}

	@Override
	public List<Pet> getMyPets(User user) {
      
		  String sql="SELECT * FROM PETS WHERE OWNER_ID="+user.getUserId();//Native Query returns a Result Set
		  Session session = sessionFactory.getCurrentSession();
		  List<Pet> myPetList=session.createNativeQuery(sql).addEntity(Pet.class).list();
	
			return myPetList;


	}
}
