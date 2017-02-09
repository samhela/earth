package edu.mum.cs.cs544.configuration;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by samue on 2/6/2017.
 */
@ApplicationPath("/api")
public class ApiConfig extends Application {
	
    @Override
    public Map<String, Object> getProperties() {
        System.out.println("*********************API method called***********************");
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("jersey.config.server.provider.packages", "edu.mum.cs.cs544");
        return properties;
    }
}
