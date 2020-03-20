package com.nav.cxfdemo.orders;

import com.nav.schema.order.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;

@WebService(portName = "OrdersSOAP", serviceName = "Orders",
endpointInterface = "com.nav.schema.order.Orders",
targetNamespace="http://www.nav.com/service/Orders/")
public class DefaultOrdersEndpoint implements Orders {
    @Autowired
    private OrderService orderService;

    @Override
    public OrderInquiryResponseType processOrderPlacement(OrderInquiryType orderInquiry) {
       OrderInquiryResponseType response = orderService.processOrder(
               orderInquiry.getUnqiueId(),
               orderInquiry.getOrderQty(),
               orderInquiry.getAccountId(),
               orderInquiry.getEan13()
       );
        return response;
    }

    private OrderInquiryResponseType getDummyOrderInquiryResponseType() {
        ObjectFactory factory = new ObjectFactory();
        OrderInquiryResponseType response = factory.createOrderInquiryResponseType();
        AccountType account = factory.createAccountType();
        account.setAccountId(1);
        response.setAccount(account);
        return response;
    }
}
