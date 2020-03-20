package com.nav.cxfdemo.orders;

import com.nav.schema.order.OrderInquiryResponseType;

public interface OrderService {
    OrderInquiryResponseType processOrder(int uniqueOrderId, int orderQty,
                                          int accountId, long ean13);
}
