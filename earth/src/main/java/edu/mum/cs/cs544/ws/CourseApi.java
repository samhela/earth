package edu.mum.cs.cs544.ws;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;

/**
 * Created by samue on 2/6/2017.
 */
@Path("/course")
public class CourseApi {


    Map<String, String>  member1 = new HashMap<String, String>() ;
    Map<String, String>  member2 = new HashMap<String, String>() ;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public  List<Map<String, String>> getAllCourses(){
        List<Map<String, String>> listOfProjectTeamMembers = new ArrayList<Map<String, String>>();
        member1.put("name", "Team 1");
        member1.put("task", "Developer");

        member2.put("name", "Team 2");
        member2.put("task", "Tester");

        listOfProjectTeamMembers.addAll(Arrays.asList(member1, member2));

        return listOfProjectTeamMembers;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String testPost(){
        return "Post Data";
    }
}
