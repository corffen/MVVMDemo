package com.corffen.mvvmdemo;

/**
 * Date: 2018-04-22 21:08
 *
 * @author: Administrator
 */
public class Person {

    private String personName;

    public Person(String personName) {
        this.personName = personName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
