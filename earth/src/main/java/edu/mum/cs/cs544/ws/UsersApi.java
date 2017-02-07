package edu.mum.cs.cs544.ws;

import edu.mum.cs.cs544.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by samue on 2/6/2017.
 */
@Path("/users/list")
@Component
@Transactional
public class UsersApi {
    @Autowired
    UserService userService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getAllUsers(){

        if(userService == null){
            System.out.println("userService is null");
        }


        System.out.println("*********************Users are loaded*******************************");

        System.out.println("Size is from the WS" + userService.findAllUsers().size());
        //return userService.findAllUsers();
    }

}
