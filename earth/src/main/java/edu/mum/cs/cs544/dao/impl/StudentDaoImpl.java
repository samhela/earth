package edu.mum.cs.cs544.dao.impl;

import edu.mum.cs.cs544.dao.AbstractDao;
import edu.mum.cs.cs544.dao.StudentDao;
import edu.mum.cs.cs544.model.AttendanceRecord;
import edu.mum.cs.cs544.model.CourseOffering;
import edu.mum.cs.cs544.model.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentDao")
public class StudentDaoImpl  extends  AbstractDao<Integer, Student> implements StudentDao {

    //harcoding
    @Autowired
    private SessionFactory sf;



    //@Transactional(propagation=Propagation.MANDATORY)
    @SuppressWarnings("unchecked")
    @Override
    public  List<Student> getAllStudents(){

        List<Student> student = (List<Student>) createNamedEntityQuery("Student.finadAllStudent").list();
        return student;
    }

    //@Transactional(propagation=Propagation.MANDATORY)
    @Override
    public void addStudent(Student student) {
        persist(student);

    }

    //@Transactional(propagation=Propagation.MANDATORY)
    @Override
    public Student getStudent(long Id) {
        Student student = (Student) createNamedEntityQuery("Student.findByStudentId")
                .setParameter("courseId", Id)
                .uniqueResult();
        return student;

    }

    //@Transactional(propagation=Propagation.MANDATORY)
    @Override
    public void deleteStudent(long Id) {
        Student student = (Student) createNamedEntityQuery("Student.findByStudentId")
                .setParameter("courseId", Id)
                .uniqueResult();
        delete(student);
    }

    //@Transactional(propagation=Propagation.MANDATORY)
    @Override
    public void updateStudent(Student student) {
        update(student);

    }

    @Override
    public List<CourseOffering> registredCourse(CourseOffering courseOffering) {
        // TODO Auto-generated method stub

        return null;
    }

    @Override
    public List<AttendanceRecord> getAttendanceRecod(long locationId) {
        // TODO Auto-generated method stub
        return null;
    }

}
