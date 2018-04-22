package com.corffen.mvvmdemo;

/**
 * Date: 2018-04-22 21:08
 *
 * @author: Administrator
 */
public class Student {

    private String studentName;

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
