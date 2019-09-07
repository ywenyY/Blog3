package dao;

import domain.User;

import java.util.List;

/**
 * 用户操作的dao
 */
public interface UserDao {
    public List<User> findAll();
    public User findUserByUsernameAndPassWord(String username , String password);
}

