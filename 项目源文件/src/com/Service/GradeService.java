package com.Service;

import com.Dao.GradeDao;
import com.Dao.impl.GradeDaoImpl;
import com.Entity.Grade;

import java.util.List;

public class GradeService {
    private GradeDao gradeDao=new GradeDaoImpl();

    public void addGrade(Grade grade) {
         gradeDao.addGrade(grade);
    }

    public List<Grade> queryGradeList(int userId) {
        return gradeDao.queryGradeList(userId);
    }
}
