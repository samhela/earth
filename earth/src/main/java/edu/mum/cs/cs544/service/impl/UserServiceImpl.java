package edu.mum.cs.cs544.service.impl;

import edu.mum.cs.cs544.model.User;
import edu.mum.cs.cs544.model.UserProfile;
import edu.mum.cs.cs544.model.UserProfileType;
import edu.mum.cs.cs544.service.UserService;
import edu.mum.cs.cs544.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private  UserDao dao;



	@Autowired
	private PasswordEncoder passwordEncoder;

	public User findById(int id) {
		return dao.findById(id);
	}


	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with
	 * proper values within transaction. It will be updated in db once
	 * transaction ends.
	 */
	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
		if (entity != null) {
			entity.setUserName(user.getUserName());
			if (!user.getPassword().equals(entity.getPassword())) {
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setEmail(user.getEmail());
			entity.setUserProfiles(user.getUserProfiles());
		}
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	@PostConstruct
	public void loadDefaultUsers(){
		System.out.println("*********************LOAD DEFAULT USERS******************");
		try {
			User user1 = new User();

			UserProfile userProfile = new UserProfile();
			Set<UserProfile> userProfiles = new HashSet<UserProfile>();
			userProfile.setType(UserProfileType.ADMIN.getUserProfileType());
			userProfile.setType(UserProfileType.USER.getUserProfileType());

			//userProfiles.add(userProfile);

			user1.setFirstName("Samuel");
			user1.setEmail("saminium@gmail.com");
			user1.setLastName("Zeru");
			user1.setPassword("samuel");
			user1.setUserName("samuel");




			user1.getUserProfiles().addAll(userProfiles);
			user1.setUserProfiles(userProfiles);
			dao.save(user1);


		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	@Override
	public User findByUserName(String userName) {
		User user = dao.findByUserName(userName);
		return user;
	}

	@Override
	public void deleteUserByUserName(String userName) {
		dao.deleteByUserName(userName);

	}

	@Override
	public boolean isUserNameUnique(Integer id, String userName) {
		User user = findByUserName(userName);
		return (user == null || ((id != null) && (user.getId() == id)));
	}

}
