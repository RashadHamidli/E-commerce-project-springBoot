package com.company.main;

import com.company.dao.impl.UserDAOImpl;
import com.company.dao.inter.UserDAOinter;

public class Context {
    public static UserDAOinter instanceUserDao() {
        return new UserDAOImpl();
    }
}
