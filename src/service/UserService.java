package service;

import domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有的用户信息
     */
    public List<User> findAll();

    /**
     * 登陆方法
     * @param user
     * @return
     */
    public User login(User user);


}

