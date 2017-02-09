package edu.mum.cs.cs544.service.impl;

import edu.mum.cs.cs544.dao.AttendaceRecordDao;
import edu.mum.cs.cs544.model.AttendanceRecord;
import edu.mum.cs.cs544.service.AttendanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by samue on 2/8/2017.
 */
@Service("attendaceRecordService")
@Transactional
public class AttendanceServiceImpl implements AttendanceRecordService {

    @Autowired
    AttendaceRecordDao attendaceRecordDao;

    @Override
    public void addAttendance(AttendanceRecord attendanceRecord) {
        attendaceRecordDao.addAttendance(attendanceRecord);
    }

    @Override
    public List<AttendanceRecord> listAllAttendaceRecord() {
        return attendaceRecordDao.listAllAttendaceRecord();
    }

    @Override
    public List<AttendanceRecord> liAttendanceRecordsByStudentId(long studentId) {
        return attendaceRecordDao.liAttendanceRecordsByStudentId(studentId);
    }

    @Override
    public List<AttendanceRecord> lisAttendanceRecordsByCourseId(long courseId) {
        return attendaceRecordDao.lisAttendanceRecordsByCourseId(courseId);
    }

    @Override
    public List<AttendanceRecord> lisAttendanceRecordsByLocation(long locationId) {
        return attendaceRecordDao.lisAttendanceRecordsByLocation(locationId);
    }

    public List<AttendanceRecord> lisAttendanceRecordsByBarcode(String barcode){
        return attendaceRecordDao.lisAttendanceRecordsByBarcode(barcode);
    }
}
