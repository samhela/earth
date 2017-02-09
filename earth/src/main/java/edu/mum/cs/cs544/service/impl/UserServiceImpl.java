package edu.mum.cs.cs544.service.impl;

import edu.mum.cs.cs544.model.User;
import edu.mum.cs.cs544.model.UserProfile;
import edu.mum.cs.cs544.model.UserProfileType;
import edu.mum.cs.cs544.service.UserService;
import edu.mum.cs.cs544.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<User> findAllUsers() {

		return dao.findAllUsers();
	}

	@PostConstruct
	public void loadDefaultUsers(){
		System.out.println("*********************LOAD DEFAULT USERS******************");
		try {
			User admin = new User();
			User faculity = new User();
			User student = new User();

			//Test User for student id 1
			User student1 = new User();


			UserProfile userProfile = new UserProfile();
			UserProfile userProfileFaculity = new UserProfile();
			UserProfile userProfileStudent = new UserProfile();

			UserProfile userProfileStudent1 = new UserProfile();

			Set<UserProfile> userProfiles = new HashSet<UserProfile>();
			Set<UserProfile> userProfilesFaculity = new HashSet<UserProfile>();
			Set<UserProfile> userProfilesStudent = new HashSet<UserProfile>();

			Set<UserProfile> userProfilesStudent1 = new HashSet<UserProfile>();

			userProfile.setType(UserProfileType.ADMIN.getUserProfileType());
			userProfileFaculity.setType(UserProfileType.FACULITY.getUserProfileType());
			userProfileStudent.setType(UserProfileType.STUDENT.getUserProfileType());

			userProfileStudent1.setType(UserProfileType.STUDENT.getUserProfileType());



			userProfiles.add(userProfile);
			userProfilesFaculity.add(userProfileFaculity);
			userProfilesStudent.add(userProfileStudent);

			userProfilesStudent1.add(userProfileStudent1);

			admin.setFirstName("Admin");
			admin.setEmail("admin@mum.edu");
			admin.setLastName("admin");
			admin.setPassword("admin");
			admin.setUserName("admin");

			faculity.setFirstName("Faculity");
			faculity.setEmail("Faculity@mum.edu");
			faculity.setLastName("Faculity");
			faculity.setPassword("faculity");
			faculity.setUserName("faculity");

			student.setFirstName("student");
			student.setEmail("student@mum.edu");
			student.setLastName("student");
			student.setPassword("student");
			student.setUserName("student");

			student1.setFirstName("student1");
			student1.setEmail("student1@mum.edu");
			student1.setLastName("student1");
			student1.setPassword("1100107816179");
			student1.setUserName("1100107816179");

			admin.getUserProfiles().addAll(userProfiles);
			faculity.getUserProfiles().addAll(userProfilesFaculity);
			student.getUserProfiles().addAll(userProfilesStudent);

			student1.getUserProfiles().addAll(userProfilesStudent1);

			admin.setUserProfiles(userProfiles);
			faculity.setUserProfiles(userProfilesFaculity);
			student.setUserProfiles(userProfilesStudent);

			student1.setUserProfiles(userProfilesStudent1);
/*
			dao.save(admin);
			dao.save(faculity);
			dao.save(student);*/

			dao.save(student1);


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
