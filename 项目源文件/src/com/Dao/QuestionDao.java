package com.Dao;

import com.Entity.single;

import java.util.List;

public interface QuestionDao {
    List<single> queryPaperSingle(String paper);

    List<String> queryPaperList();
}
