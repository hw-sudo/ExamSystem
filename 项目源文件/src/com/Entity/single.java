package com.Entity;
//题目
public class single {
    private int single_id;
    private String subject;
    private String option_A;
    private String option_B;
    private String option_C;
    private String option_D;
    private String answer;
    private String paper;

    public int getSingle_id() {
        return single_id;
    }

    public void setSingle_id(int single_id) {
        this.single_id = single_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOption_A() {
        return option_A;
    }

    public void setOption_A(String option_A) {
        this.option_A = option_A;
    }

    public String getOption_B() {
        return option_B;
    }

    public void setOption_B(String option_B) {
        this.option_B = option_B;
    }

    public String getOption_C() {
        return option_C;
    }

    public void setOption_C(String option_C) {
        this.option_C = option_C;
    }

    public String getOption_D() {
        return option_D;
    }

    public void setOption_D(String option_D) {
        this.option_D = option_D;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    @Override
    public String toString() {
        return "single{" +
                "single_id=" + single_id +
                ", subject='" + subject + '\'' +
                ", option_A='" + option_A + '\'' +
                ", option_B='" + option_B + '\'' +
                ", option_C='" + option_C + '\'' +
                ", option_D='" + option_D + '\'' +
                ", answer='" + answer + '\'' +
                ", paper='" + paper + '\'' +
                '}';
    }
}
