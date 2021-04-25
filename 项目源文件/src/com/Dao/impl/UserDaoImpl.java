package com.Dao.impl;

import com.Dao.UserDao;
import com.Entity.User;
import com.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl  implements UserDao {
    //使用Jdbc链接数据库，并获取数据库资源
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /*
     template.query(SQL语句，对应Entity对象，第一位？预占位值……第N位预占位）
     */

    @Override
    public User queryUser(String username, String password) {
        String sql = "select * from user where username = ? and password= ?";
        List<User> users = template.query(sql,new BeanPropertyRowMapper<User>(User.class),username,password);
        if (users == null || users.size() ==0) {
            return null;
        }else {
            return users.get(0);
        }
    }
/*
template.query（sql语句，对应的Entity对象)
 */
    @Override
    public List<User> queryAllUsers() {
        String sql = "select * from user";
        List<User> users = template.query(sql,new BeanPropertyRowMapper<User>(User.class));
        return users;
    }
    @Override
    public void addUser(String username, String password, String name, String telephone, String sex, String age, String role) {
        String sql = "insert into user values(null,?,?,?,?,?,?,?)";
        template.update(sql,username,password,name,telephone,sex,age,role);
    }

    @Override
    public void insert(User user) {
        String sql="INSERT into user(username,password,name,telephone,sex,age,role ) VALUES(?,?,?,?,?,?,?);";
        template.update(sql,user.getUsername(),user.getPassword(),user.getName(),user.getTelephone(),user.getSex(),user.getAge(),user.getRole());
    }
}
