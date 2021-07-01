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

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthday")
    private Date birthday;

    public int getSid() { return sid; }

    public String getSname() { return sname; }

    public String getGender() { return gender; }

    public Date getBirthday() { return birthday; }

    public void setSid(int sid) { this.sid = sid; }

    public void setSname(String sname) { this.sname = sname; }

    public void setGender(String gender) { this.gender = gender; }

    public void setBirthday(Date birthday) { this.birthday = birthday; }
}
