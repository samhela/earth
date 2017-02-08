package edu.mum.cs.cs544.dao.impl;

import edu.mum.cs.cs544.dao.AbstractDao;
import edu.mum.cs.cs544.model.Registration;
import edu.mum.cs.cs544.dao.RegistrationDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by samue on 2/7/2017.
 */
@Repository("registrationDao")
public class RegistrationDaoImpl extends AbstractDao<Integer, Registration> implements RegistrationDao {
    static final Logger logger = LoggerFactory.getLogger(Registration.class);
    @Override
    public void add(Registration registration) {
        persist(registration);
    }
}
