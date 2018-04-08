package com.jamesgalang.client;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import com.jamesgalang.ws.PeopleDB;

public class PeopleDBClient{

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:9999/ws/people?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://ws.jamesgalang.com/", "PeopleDBImplService");

        Service service = Service.create(url, qname);

        PeopleDB people = service.getPort(PeopleDB.class);

        System.out.println(people.getPeopleDB("jamesgalang"));

    }

}
