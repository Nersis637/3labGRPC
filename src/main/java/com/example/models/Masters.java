package com.example.models;

import jakarta.persistence.*;
@Entity
@Table(name = "Masters")
@NamedQuery(name = "Masters.getAll", query = "SELECT m from Masters m")
public class Masters {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_master")
    private Integer id_master;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name="exist")
    private Boolean exist;
    public Masters(Integer id_master, String name, String surname, Boolean exist) {
        this.id_master = id_master;
        this.name = name;
        this.surname = surname;
        this.exist = exist;
    }
    public Masters() {}
    public Integer getId_master() {
        return id_master;
    }
    public void setId_master(Integer id_master){this.id_master = id_master;}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boolean getExist() {
        return exist;
    }
    public void setExist(Boolean exist) {
        this.exist = exist;
    }
}