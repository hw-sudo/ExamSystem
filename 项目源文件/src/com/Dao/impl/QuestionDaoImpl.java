package com.Dao.impl;

import com.Dao.QuestionDao;
import com.Entity.single;
import com.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class QuestionDaoImpl implements QuestionDao {
    //使用Jdbc链接数据库，并获取数据库资源
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<single> queryPaperSingle(String paper) {
        String sql = "select * from single where paper = ?";
        return template.query(sql,new BeanPropertyRowMapper<single>(single.class),paper);
    }

    @Override
    public List<String> queryPaperList() {
        String sql = "SELECT DISTINCT paper FROM single";
        List<String> list = template.queryForList(sql,String.class);
        return list;
    }
}
