package edu.mum.cs.cs544.dao;



import edu.mum.cs.cs544.model.User;

import java.util.List;

public interface UserDao {

	User findById(int id);

	User findByUserName(String userName);

	void save(User user);

	void deleteByUserName(String userName);

	List<User> findAllUsers();
}
