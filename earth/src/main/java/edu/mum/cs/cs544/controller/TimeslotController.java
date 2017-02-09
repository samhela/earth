package edu.mum.cs.cs544.controller;

import edu.mum.cs.cs544.model.Timeslot;
import edu.mum.cs.cs544.service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by samue on 2/8/2017.
 */
@Controller
public class TimeslotController {

    @Autowired
    TimeslotService timeslotService;




    public Date getStartTimeAM(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 45);
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.MILLISECOND, 000);
        return calendar.getTime();
    }

    public Date getEndTimeAM(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.MILLISECOND, 000);
        return calendar.getTime();
    }

    public Date getStartTimePM(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 13);
        calendar.set(Calendar.MINUTE, 15);
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.MILLISECOND, 000);
        return calendar.getTime();
    }

    public Date getEndTimePM(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 14);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.MILLISECOND, 000);
        return calendar.getTime();
    }


    //list course
    @RequestMapping(value = "/timeslot/timeslotList", method = RequestMethod.GET)
    public String listTimeslot(Model model){

       /* Date date = new Date();
        Timeslot amTimeSlot = new Timeslot("AM", "Morning Session", getStartTimeAM(date), getEndTimeAM(date));
        Timeslot pmTimeSlot = new Timeslot("PM", "Afternoon session", getStartTimePM(date), getEndTimePM(date));

        timeslotService.addTimeslot(pmTimeSlot);
        timeslotService.addTimeslot(amTimeSlot);
*/
        List<Timeslot> timeslots = timeslotService.allTimeslot();
        model.addAttribute("timeslots", timeslots);

        System.out.println("TIME SLOTS ARE : " + timeslots.size());

        return "timeslot/timeslotList";
    }

    //add course form post
    //Need validation at this point
    @RequestMapping(value = { "/timeslot/addTimeslot" }, method = RequestMethod.POST)
    public String saveTimeslot(Timeslot timeslot, BindingResult result,
                             ModelMap model) {
        timeslotService.addTimeslot(timeslot);
        model.addAttribute("success", "Timeslot " + timeslot.getAbbrv() + "  registered successfully");
        return "redirect:/timeslot/timeslotList";
    }
}
