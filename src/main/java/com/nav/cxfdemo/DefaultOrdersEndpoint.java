package com.nav.cxfdemo;

import com.nav.schema.order.*;

import javax.jws.WebService;

@WebService(portName = "OrdersSOAP", serviceName = "Orders",
endpointInterface = "com.nav.schema.order.Orders",
targetNamespace="http://www.nav.com/service/Orders/")
public class DefaultOrdersEndpoint implements Orders {
    @Override
    public OrderInquiryResponseType processOrderPlacement(OrderInquiryType orderInquiry) {
        ObjectFactory factory = new ObjectFactory();
        OrderInquiryResponseType response = factory.createOrderInquiryResponseType();
        AccountType account = factory.createAccountType();
        account.setAccountId(1);
        response.setAccount(account);
        return response;
    }
}
