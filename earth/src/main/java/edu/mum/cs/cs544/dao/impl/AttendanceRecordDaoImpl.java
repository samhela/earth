package edu.mum.cs.cs544.dao.impl;

import edu.mum.cs.cs544.dao.AbstractDao;
import edu.mum.cs.cs544.model.AttendanceRecord;
import edu.mum.cs.cs544.dao.AttendaceRecordDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by samue on 2/8/2017.
 */
@Repository("attendanceRecordDao")
public class AttendanceRecordDaoImpl extends AbstractDao<Integer, AttendanceRecord> implements AttendaceRecordDao{

    static final Logger logger = LoggerFactory.getLogger(AttendanceRecordDaoImpl.class);

    @Override
    public void addAttendance(AttendanceRecord attendanceRecord) {
        persist(attendanceRecord);

    }

    @Override
    public List<AttendanceRecord> listAllAttendaceRecord() {
        List<AttendanceRecord> attendanceRecordList = createNamedEntityQuery("AttendanceRecord.allAttendanceRecord")
                .list();
        return attendanceRecordList;

    }

    @Override
    public List<AttendanceRecord> liAttendanceRecordsByStudentId(long studentId) {
       /* List<AttendanceRecord> attendanceRecordList = createNamedEntityQuery("AttendanceRecord.liAttendanceRecordsByStudentId")
                .setParameter("studentId", studentId)
                .list();
        return attendanceRecordList;*/
        return null;
    }

    @Override
    public List<AttendanceRecord> lisAttendanceRecordsByCourseId(long courseId) {
       /* List<AttendanceRecord> attendanceRecordList = createNamedEntityQuery("AttendanceRecord.lisAttendanceRecordsByCourseId")
                .setParameter("courseId", courseId)
                .list();
        return attendanceRecordList;*/
       return null;
    }

    @Override
    public List<AttendanceRecord> lisAttendanceRecordsByLocation(long locationId) {
       /* List<AttendanceRecord> attendanceRecordList = createNamedEntityQuery("AttendanceRecord.lisAttendanceRecordsByLocation")
                .setParameter("locationId", locationId)
                .list();
        return attendanceRecordList;*/
       return null;
    }
}
