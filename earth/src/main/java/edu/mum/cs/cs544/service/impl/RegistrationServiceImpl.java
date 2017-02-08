package edu.mum.cs.cs544.service.impl;

import edu.mum.cs.cs544.dao.RegistrationDao;
import edu.mum.cs.cs544.model.Registration;
import edu.mum.cs.cs544.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by samue on 2/7/2017.
 */
@Service("registrationService")
@Transactional
public class RegistrationServiceImpl implements RegistrationService{

    @Autowired
    RegistrationDao registrationDao;

    @Override
    public void add(Registration registration) {
        registrationDao.add(registration);
    }
}
