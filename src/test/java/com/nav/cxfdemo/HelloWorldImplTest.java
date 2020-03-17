
package com.nav.cxfdemo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HelloWorldImplTest {

    @Test
    public void testSayHi() {
        HelloWorld helloWorldImpl = new HelloWorldImpl();
        String response = helloWorldImpl.sayHi("Sam");
        assertEquals("HelloWorldImpl not properly saying hi", "Hello Sam", response);
    }
}
