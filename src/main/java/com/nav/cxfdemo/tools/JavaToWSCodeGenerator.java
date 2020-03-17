package com.nav.cxfdemo.tools;

import org.apache.cxf.tools.java2ws.JavaToWS;

//CXF java2wsdl Example
public class JavaToWSCodeGenerator {
    public static void main(String[] args) {
        try {
            JavaToWS.main(new String[]{"-d", "src", "-o", "main/resources/wsdl/HelloWorldImpl.wsdl", "-createxsdimports", "-wsdl",
                    "com.nav.cxfdemo.HelloWorldImpl"});
            System.out.println("finished %%%%%%%%%%");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}