package edu.mum.cs.cs544.controller;

import edu.mum.cs.cs544.model.Course;
import edu.mum.cs.cs544.model.Location;
import edu.mum.cs.cs544.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by samue on 2/8/2017.
 */
@Controller
public class LocationController {

    @Autowired
    LocationService locationService;


    //list course
    @RequestMapping(value = "/location/locationList", method = RequestMethod.GET)
    public String listLocations(Model model){
        System.out.println("-------------------LOCATION IS CALLED-------------------------------");
        List<Location> locationList = locationService.allLocations();
        model.addAttribute("locationList", locationList);
        return "location/locationList";
    }

    //add course form
    @RequestMapping(value = "/location/addLocation", method = RequestMethod.GET)
    public String addLocation(ModelMap model){
        Course course = new Course();
        Location location = new Location();
        model.addAttribute("location", location);
        model.addAttribute("edit", false);

        return "location/addLocation";
    }

    //add course form post
    //Need validation at this point
    @RequestMapping(value = { "/location/addLocation" }, method = RequestMethod.POST)
    public String saveLocation(Location location, BindingResult result, ModelMap model) {
        locationService.addLocation(location);
        model.addAttribute("success", "Location " + location.getName() + "  registered successfully");
        return "redirect:/location/locationList";
    }
    
    @RequestMapping(value = { "/delete-location/{locationId}" }, method = RequestMethod.GET)
   	public String deleteUser(@PathVariable String locationId) {
   		locationService.deleteLocationById(locationId);
   		return "redirect:/location/locationList";
   	}

       @RequestMapping(value="/edit-location/{locationId}",method=RequestMethod.GET)
       public String editCourse(@PathVariable("locationId") String locationId, Model model){
        model.addAttribute("location", this.locationService.getByLocationId(locationId));
        
   		model.addAttribute("edit", true);
   		
   		
   	    return "location/addLocation";
       }
       @RequestMapping(value="/edit-location/{locationId}",method=RequestMethod.POST)
       public String updateCourse(@PathVariable("locationId") String locationId, Location location){
//       	course = this.courseService.findByCourseId(id);
       	locationService.updateLocation(location);
   	    return "redirect:/location/locationList";
       }
}
