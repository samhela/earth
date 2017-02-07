package edu.mum.cs.cs544.service;



import edu.mum.cs.cs544.model.User;

import java.util.List;

public interface UserService {
	
	User findById(int id);
	
	User findByUserName(String userName);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserByUserName(String userName);

	List<User> findAllUsers(); 
	
	boolean isUserNameUnique(Integer id, String userName);

}