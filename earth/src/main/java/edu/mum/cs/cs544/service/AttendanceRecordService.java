package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.model.AttendanceRecord;

import java.util.List;

/**
 * Created by samue on 2/8/2017.
 */
public interface AttendanceRecordService {
    public void addAttendance(AttendanceRecord attendanceRecord);
    public List<AttendanceRecord> listAllAttendaceRecord();

    public List<AttendanceRecord> liAttendanceRecordsByStudentId(long studentId);
    public List<AttendanceRecord> lisAttendanceRecordsByCourseId(long courseId);
    public List<AttendanceRecord> lisAttendanceRecordsByLocation(long locationId);
}
