package com.example.nashtech.restapi.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;

    @Column(name = "sname")
    private String sname;

    enum sex { male, female }

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private sex gender;

    @Column(name = "birthday")
    private Date birthday;

    public int getSid() { return sid; }

    public String getSname() { return sname; }

    public sex getGender() { return gender; }

    public Date getBirthday() { return birthday; }

    public void setSid(int sid) { this.sid = sid; }

    public void setSname(String sname) { this.sname = sname; }

    public void setGender(sex gender) { this.gender = gender; }

    public void setBirthday(Date birthday) { this.birthday = birthday; }
}
