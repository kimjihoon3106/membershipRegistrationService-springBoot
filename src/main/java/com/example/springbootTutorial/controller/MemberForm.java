package com.example.springbootTutorial.controller;

public class MemberForm {
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }


    private int id;
    private String name;

}
