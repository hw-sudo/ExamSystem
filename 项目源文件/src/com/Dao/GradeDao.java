package com.Dao;

import com.Entity.Grade;

import java.util.List;

public interface GradeDao {
    //添加分数
    void addGrade(Grade grade);

    List<Grade> queryGradeList(int userId);
}
