package com.jamesgalang.endpoint;

import com.jamesgalang.ws.PeopleDBImpl;

import javax.xml.ws.Endpoint;

//Endpoint publisher
public class PeopleDBPublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/people", new PeopleDBImpl());
    }
}