package edu.mum.cs.cs544.ws;

import edu.mum.cs.cs544.model.Student;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */
public class StudentResponse {


    private List<Student> rows;

    public StudentResponse() {
    }
    public List<Student> getRows() {
        return rows;
    }

    public void setRows(List<Student> rows) {
        this.rows = rows;
    }
}
