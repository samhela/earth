package edu.mum.cs.cs544.service.impl;

import edu.mum.cs.cs544.dao.UserProfileDao;
import edu.mum.cs.cs544.model.UserProfile;
import edu.mum.cs.cs544.service.UserProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;


@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {
	
	@Autowired
	UserProfileDao dao;
	
	public UserProfile findById(int id) {
		
		return dao.findById(id);
		
	}

	@NotNull
	public UserProfile findByType(String type){
		return dao.findByType(type);
	}

	public List<UserProfile> findAll() {
		return dao.findAll();
	}
}
