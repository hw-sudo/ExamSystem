package com.Service;

import com.Dao.QuestionDao;
import com.Dao.UserDao;
import com.Dao.impl.QuestionDaoImpl;
import com.Entity.single;

import java.util.List;

public class QuestionService {
    private QuestionDao questionDao=new QuestionDaoImpl();
    //根据科目查询对应试题集
    public List<single> queryPaperSingle(String paper) {
        return questionDao.queryPaperSingle(paper);
    }

    public List<String> queryPaperList() {
        return questionDao.queryPaperList();
    }
}
