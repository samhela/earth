package edu.mum.cs.cs544.controller;

import edu.mum.cs.cs544.model.AttendanceRecord;
import edu.mum.cs.cs544.service.AttendanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by samue on 2/8/2017.
 */
@Controller
public class AttendanceRecordController {

    @Autowired
    AttendanceRecordService attendanceRecordService;

    @RequestMapping(value = "/attendance/attendanceList", method = RequestMethod.GET)
    public String listAllAttendance(Model model){
        List<AttendanceRecord> attendanceRecordList = attendanceRecordService.listAllAttendaceRecord();
        model.addAttribute("attendanceRecordList", attendanceRecordList);
        System.out.println("Size is : " + attendanceRecordList.size());

        return "attendance/attendanceList";
    }

    @RequestMapping(value = "/attendance/attendanceListByStudentId}", method = RequestMethod.GET)
    public String listAttendanceByStudent(Model model, long studentId){
        List<AttendanceRecord> attendanceRecordListByStudent = attendanceRecordService.liAttendanceRecordsByStudentId(studentId);
        model.addAttribute("attendanceRecordListByStudent", attendanceRecordListByStudent);
        System.out.println("Size is : " + attendanceRecordListByStudent.size());

        return "attendance/attendanceList";
    }

    //student/myAttendace

    @RequestMapping(value = "/attendance/myAttendace-{barcode}", method = RequestMethod.GET)
    public String myAttendance(Model model, @PathVariable String barcode){

        List<AttendanceRecord> attendanceRecordList = attendanceRecordService.lisAttendanceRecordsByBarcode(barcode);
        System.out.println("---------------------------THE SIZE OF MY ATTENDANCE IS :-------------" + attendanceRecordList.size());
        model.addAttribute("attendanceRecordList", attendanceRecordList);
        return "attendance/attendanceList";
    }


}
