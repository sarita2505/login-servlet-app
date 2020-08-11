package com.java.database;

import com.java.userdetails.User;

import java.util.ArrayList;
import java.util.List;

public class UserDb {
    public static List<User> users(){
        List<User> list=new ArrayList<>();
        list.add(new User("name1","pass1"));
        list.add(new User("name2","pass2"));
        list.add(new User("name3","pass3"));
        return list;
    }
}
