package com.Entity;

import java.util.Date;

//成绩
public class Grade {
    private int grade_id;
    private int user_id;
    private String paper;
    private int score;
    private Date time;

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade_id=" + grade_id +
                ", user_id=" + user_id +
                ", paper='" + paper + '\'' +
                ", score=" + score +
                ", time=" + time +
                '}';
    }



}
