package com.example.models;

import jakarta.persistence.*;
@Entity
@Table(name = "Clients")
@NamedQuery(name = "Clients.getAll", query = "SELECT c from Clients c")
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_client", nullable = false)
    private Integer id_client;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "exist")
    private Boolean exist;

    public Clients(Integer id_client, String name, String surname, Boolean exist) {
        this.id_client = id_client;
        this.name = name;
        this.surname = surname;
        this.exist = exist;
    }
    public Clients() {}
    public Integer getId_client() {
        return id_client;
    }
    public void setId_client(Integer id) {
        this.id_client = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname()
    {
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