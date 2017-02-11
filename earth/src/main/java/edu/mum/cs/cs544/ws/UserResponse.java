package edu.mum.cs.cs544.ws;

import edu.mum.cs.cs544.model.User;

import java.util.List;

/**
 * Created by samue on 2/7/2017.
 */
public class UserResponse {


    private List<User> rows;

    public UserResponse() {
    }

    public List<User> getRows() {
        return rows;
    }

    public void setRows(List<User> rows) {
        this.rows = rows;
    }
}
