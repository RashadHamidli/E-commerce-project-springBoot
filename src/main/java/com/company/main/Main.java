package com.company.main;


import com.company.dao.inter.UserDAOinter;
import com.company.entity.User;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        UserDAOinter userDao = Context.instanceUserDao();
        User u=userDao.findByEmail("mr_rashad@email.com");
        System.out.println("u="+u);
        System.out.println(u.getName());
    }
}

