package com.company.dao.inter;

import com.company.entity.User;

public interface UserDAOinter {


    public User getById(int id);

    public boolean addUser(User user);

    public boolean updateUser(User user);

    public boolean removeUser(int u);

}
