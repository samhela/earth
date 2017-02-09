package edu.mum.cs.cs544.ws;

import edu.mum.cs.cs544.model.Course;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */
public class CourseResponse {


    private List<Course> rows;

    public CourseResponse() {
    }
    public List<Course> getRows() {
        return rows;
    }

    public void setRows(List<Course> rows) {
        this.rows = rows;
    }
}
