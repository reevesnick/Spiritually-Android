package com.app.spritually.model;

public class HistoryModel {

    private String question;
    private String answer;
    private String date;

    public HistoryModel(String question, String answer, String date){
        this.setQuestion(question);
        this.setAnswer(answer);
        this.setDate(date);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
