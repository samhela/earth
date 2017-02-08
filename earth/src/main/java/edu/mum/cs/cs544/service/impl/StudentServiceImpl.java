package edu.mum.cs.cs544.service.impl;

import edu.mum.cs.cs544.dao.impl.StudentDaoImpl;
import edu.mum.cs.cs544.model.Student;
import edu.mum.cs.cs544.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDaoImpl studentDAO=new StudentDaoImpl();

    @Override
    public List<Student> getAllStudents() {
        List<Student> student = studentDAO.getAllStudents();
        return student;
    }

    @Override
    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    //@Transactional(propagation=Propagation.REQUIRES_NEW)
    @Override
    public Student getStudent(long Id) {
        return studentDAO.getStudent(Id);

    }
    //@Transactional(propagation=Propagation.REQUIRES_NEW)
    @Override
    public void deleteStudent(long Id) {
        studentDAO.deleteStudent(Id);

    }
    //@Transactional(propagation=Propagation.REQUIRES_NEW)
    @Override
    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);

    }


}
