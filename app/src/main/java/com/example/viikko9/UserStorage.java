package com.example.viikko9;

import java.util.ArrayList;

public class UserStorage {

    private ArrayList<User> users = new ArrayList<>();

    private static UserStorage singleton = null;

    private UserStorage()   {
    }

    public static UserStorage getInstance() {
        if (singleton == null)  {
            singleton = new UserStorage();
        }
        return singleton;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user)  {
        users.add(user);
    }

    public void removeUser(int id)  {
        users.remove(id);
    }
}
