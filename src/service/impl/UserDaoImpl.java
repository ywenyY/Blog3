package service.impl;

import dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库
        //定义sql
        String sql = "select * from user";
        List<User> users = template.query(sql,new BeanPropertyRowMapper<User>(User.class));
        return users;
    }
    @Override
    public User findUserByUsernameAndPassWord(String username , String password){
        try {
            String sql = "select * from user where name = ? and password = ?";
            User user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username,password);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("---------------------------------------");
            User  reUser = new User();
            reUser.setName(username);
            return reUser;
        }
    }
}
