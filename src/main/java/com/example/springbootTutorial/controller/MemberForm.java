package com.example.springbootTutorial.controller;

public class MemberForm {
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    private String name;
}
