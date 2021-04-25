package com.Dao.impl;

import com.Dao.GradeDao;
import com.Entity.Grade;
import com.Entity.single;
import com.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class GradeDaoImpl implements GradeDao {
    //数据库的链接
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public void addGrade(Grade grade) {
        String sql = "insert into grade values(null,?,?,?,now())";
        template.update(sql,grade.getUser_id(),grade.getPaper(),grade.getScore());
    }
//成绩查询
    @Override
    public List<Grade> queryGradeList(int userId) {
        String sql="SELECT * from grade where user_id = ?";
        return template.query(sql,new BeanPropertyRowMapper<Grade>(Grade.class),userId);
    }
}
