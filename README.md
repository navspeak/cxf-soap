* mvn archetype:generate -Dfilter=org.apache.cxf.archetype:
* Document/Literal sends full XML document as message whereas rpc makes calls to remote objects and provides features for handling binding and encoding
* Sample SOAP Message and Response
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ord="http://www.nav.com/schema/Order">
   <soapenv:Header/>
   <soapenv:Body>
      <ord:orderInquiry>
         <unqiueId>1</unqiueId>
         <orderQty>1</orderQty>
         <accountId>2</accountId>
         <ean13>1</ean13>
      </ord:orderInquiry>
   </soapenv:Body>
</soapenv:Envelope>

<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
      <ns2:orderInquiryResponse xmlns:ns2="http://www.nav.com/schema/Order">
         <account>
            <accountId>1</accountId>
         </account>
      </ns2:orderInquiryResponse>
   </soap:Body>
</soap:Envelope>

```
* READ -https://www.ibm.com/developerworks/library/ws-whichwsdl/index.html
## WSDL type
public void myMethod(int x, int y);
* xmlns:xsd = "http://www.w3.org/2001/XMLSchema"
* xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
* xmlns:soap = "http://www.w3.org/2001/soap/envelop/"
# RPC / encoded

##### WSDL
```xml
<message name="myMethodRequest">
    <part name="x" type="int"/>
    <part name="y" type="int"/>
</message>
<message name="empty"/>

<portType name="PT">
    <operation name="myMethod">
        <input message="myMethodRequest"/>
        <input message="empty"/>
    </operation>
</portType>
```
##### SOAP Message
```xml
<soap:envelope>
    <soap:body> 
        <myMethod>
            <x xsi:type="xsd:int">5</x>
            <y xsi:type="xsd:float">5.5</y>
        </myMethod>
     </soap:body> 
</soap:envelope>         
```
* Strength 
    - straight forward wsdl.
    - Operation name appears in message so easy for receiver tp dispatch this message to the impl of the operation
* Weakness 
    - Type encoding (xsd:type) overhead degrades performance. 
    - Can't easily validate this message since only <x ..>5</x> comes from schema; the rest of the soap:body content comes from WSDL definitions.
    - not WS-I compliant
    
 # RPC / Literal
##### WSDL
Same as  [RPC Encoded](#rpc--encoded) 

##### SOAP Message
```xml
<soap:envelope>
    <soap:body> 
        <myMethod>
            <x>5</x>
            <y>5.5</y>
        </myMethod>
    </soap:body>
</soap:envelope>          
```
* Strength 
    - straight still forward wsdl.
    - Operation name still appears in message.
    - Type encoding info is eliminated from soap body
    - WS-I compliant
    
* Weakness 
    - Can't still easily validate this message since only <x ..>5</x> comes from schema; the rest of the soap:body content comes from WSDL definitions.
    - not WS-I compliant

# Document/Encoded 
no one uses

# Document literal

#####WSDL
```xml
<types>
    <schema>
        <element name="xElem" type="xsd:int"/>
        <element name="yElem" type="xsd:float"/>
    </schema>
</types>

<message name="myMethodRequest">
    <part name="x" element="xElem"/>
    <part name="y" element="yElem"/>
</message>
<message name="empty"/>

<portType name="PT">
    <operation name="myMethod">
        <input message="myMethodRequest"/>
        <input message="empty"/>
    </operation>
</portType>
```

##### SOAP Message

```xml
<soap:envelope>
    <soap:body> 
            <xElem>5</xElem>
            <yElem>5.5</yElem>
    </soap:body>
</soap:envelope>          
```
* Strength 
    - Finally validate this message using any XML validator. Everything within soap:body is defined the schema
    - Type encoding info is eliminated from soap body
    - WS-I compliant (though soap:body must have only 1 child which is not the case here)
    
* Weakness 
    - Operation name soap message is losy and without the name, dispatching can be difficult or even impossible
    - WSDL is complicated (though that's not an issue)
 
 # Document / Literal Wrapped
 
 ##### WSDL
 ```xml
<types>
    <schema>
        <element name="myMethod">
            <complexType>
                <sequence>
                    <element name="xElem" type="xsd:int"/>
                    <element name="yElem" type="xsd:float"/>
                </sequence>
            </complexType>
        </element>
        <element name="myMethodResponse">
            <complexType/>
        </element>
    </schema>
</types>

<message name="myMethodRequest">
    <part name="parameters" element="myMethod"/>
</message>
<message name="empty">
    <part name="parameters" element="myMethodResponse"/>
</message>

<portType name="PT">
    <operation name="myMethod">
        <input message="myMethodRequest"/>
        <input message="empty"/>
    </operation>
</portType>
```
 ##### SOAP Message
 
 ```xml
 <soap:envelope>
     <soap:body>
        <myMethod>
             <x>5</x>
             <y>5.5</y>
        </myMethod> 
     </soap:body>
 </soap:envelope>          
 ```

Soap message is same as that of [RPC Literal](#rpc--literal). Except that in RPC/literal the <myMethod> was the name of operation but here it is name of the wrapper element which the single input message's part refers to. This is just a way to put back operation name back to message 
