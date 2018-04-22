package com.corffen.mvvmdemo;

/**
 * Date: 2018-04-22 21:09
 *
 * @author: Administrator
 */
public class Teacher {

    private String teacherName;

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
