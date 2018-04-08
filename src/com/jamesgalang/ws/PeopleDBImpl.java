package com.jamesgalang.ws;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "com.jamesgalang.ws.PeopleDB")
public class PeopleDBImpl implements PeopleDB {

    @Override
    public String getPeopleDB(String name) {
        return "database results for " + name;
    }
}