package service.impl;

import dao.UserDao;
import domain.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();


    @Override
    public List<User> findAll() {
        //调用DAO完成查询
        return dao.findAll();
    }
    public User login(User user){
        return dao.findUserByUsernameAndPassWord(user.getName(),user.getPassword());
    }
}
