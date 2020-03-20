package com.nav.cxfdemo.orders;

import com.nav.schema.order.*;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class DefaultOrderService implements OrderService {
    @Override
    public OrderInquiryResponseType processOrder(int uniqueOrderId, int orderQty, int accountId, long ean13) {
        ObjectFactory factory = new ObjectFactory();
        OrderInquiryResponseType response = factory.createOrderInquiryResponseType();
        AccountType account = factory.createAccountType();
        response.setAccount(account);
        account.setAccountId(uniqueOrderId);
        OrderItemType orderItem = factory.createOrderItemType();
        BookType bookType = factory.createBookType();
        bookType.setEan13(ean13);
        bookType.setTitle("A CXF book");
        orderItem.setBook(bookType);
        try {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(new Date(System.currentTimeMillis()));
            XMLGregorianCalendar estimatedShippingDate = DatatypeFactory
                    .newInstance().newXMLGregorianCalendar(cal);
            orderItem.setExpectedShippingDate(estimatedShippingDate);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        OrderType order = factory.createOrderType();
        order.setOrderStatus(OrderStatusType.READY);
        order.setOrderItem(orderItem);
        response.setOrder(order);

        return response;
    }
}
