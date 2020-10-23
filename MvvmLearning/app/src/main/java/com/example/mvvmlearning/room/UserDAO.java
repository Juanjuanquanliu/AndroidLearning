package com.example.mvvmlearning.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mvvmlearning.bean.User;

@Dao
public interface UserDAO {

    @Query("SELECT * from users where email = :email")
    User getRegistedUser(String email);

    @Query("SELECT * from users where email = :email AND password = :password")
    User getUser(String email, String password);

    @Update
    void update(User user);

    @Insert
    void registeUser(User user);

}
