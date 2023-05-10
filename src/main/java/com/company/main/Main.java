package com.company.main;

import com.company.dao.inter.UserDAOinter;
import com.company.entity.User;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        UserDAOinter userDAO = Context.instanceUserDao();
        User u = userDAO.getById(13);
        userDAO.removeUser(13);
    }
}
