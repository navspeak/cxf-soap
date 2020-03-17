
package com.nav.cxfdemo;

import javax.jws.WebService;

@WebService(endpointInterface = "com.nav.cxfdemo.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

