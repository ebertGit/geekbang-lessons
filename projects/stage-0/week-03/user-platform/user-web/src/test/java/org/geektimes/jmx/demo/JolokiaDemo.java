package org.geektimes.jmx.demo;

import org.jolokia.client.J4pClient;
import org.jolokia.client.exception.J4pException;
import org.jolokia.client.request.J4pReadRequest;
import org.jolokia.client.request.J4pReadResponse;

import javax.management.MalformedObjectNameException;

public class JolokiaDemo {

    public static void main(String[] args) throws Exception {
        J4pClient client = new J4pClient("http://localhost:8080/jolokia");
        J4pReadRequest request =
                new J4pReadRequest("java.lang:type=Memory","HeapMemoryUsage");
        request.setPath("used");
        J4pReadResponse response = client.execute(request);
        System.out.println("Memory used: " + response.getValue());
    }
}
