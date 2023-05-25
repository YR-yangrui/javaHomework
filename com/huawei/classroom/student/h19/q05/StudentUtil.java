package com.huawei.classroom.student.h19.q05;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentUtil {


    private boolean check(Student student, String[] infos) {
        if(student.getName().equals(infos[0])) {
            student.addScore(Integer.parseInt(infos[2]));
            if("语文".equals(infos[1])) {
                student.setScores(0,Integer.parseInt(infos[2]));
            }
            if("数学".equals(infos[1])) {
                student.setScores(1,Integer.parseInt(infos[2]));
            }
            if("英语".equals(infos[1])) {
                student.setScores(2,Integer.parseInt(infos[2]));
            }
            return true;
        }
        return false;
    }
    private void setScore(List<Student> studentList, String info) {
        String[] infos = info.split(",");
        infos[2] = infos[2].replace(";","");
        for (Student student : studentList) {
            if(check(student,infos)) {
                return;
            }
        }
        Student student = new Student(infos[0]);
        check(student,infos);
        studentList.add(student);
    }
    public List<String> sort(String fileName) {
        List<Student> studentList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String info = bufferedReader.readLine();
            while(info != null) {
                setScore(studentList,info);
                info = bufferedReader.readLine();
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(studentList);
        List<String> students = new ArrayList<>();
        for (Student student : studentList) {
            students.add(student.getName());
        }
        return students;
    }
}
