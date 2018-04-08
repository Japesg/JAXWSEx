package com.jamesgalang.ws;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "com.jamesgalang.ws.HelloWorld")
public class HelloWorldImpl implements PeopleDB{

    @Override
    public String getPeopleDB(String name) {
        return "//find a way to put data here? " + name;
    }