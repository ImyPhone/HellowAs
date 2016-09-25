package com.itcast.hellowas;

/**
 * @author Jimmy White
 * @version @Rev$
 * @time 2016/9/19 11:24
 * @des ${TODO}
 */
public class Teacher {
    private int age;
    private String name;
    private String sex;

    public Teacher(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
