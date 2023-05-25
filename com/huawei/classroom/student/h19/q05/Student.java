package com.huawei.classroom.student.h19.q05;

public class Student implements Comparable<Student>{
    private int[] scores;
    private String name;

    private int totalScore;

    public Student(String name) {
        this.name = name;
        scores = new int[3];
        totalScore = 0;
    }


    @Override
    public int compareTo(Student o) {
        if(totalScore != o.totalScore) {
            return o.totalScore - totalScore;
        }
        if(scores[0] != o.scores[0]) {
            return o.scores[0] - scores[0];
        }
        if(scores[1] != o.scores[1]) {
            return o.scores[1] - scores[1];
        }
        return o.scores[2] - scores[2];
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int idx,int score) {
        this.scores[idx] = score;
    }

    public String getName() {
        return name;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void addScore(int s) {
        this.totalScore += s;
    }

    public void setName(String name) {
        this.name = name;
    }
}
