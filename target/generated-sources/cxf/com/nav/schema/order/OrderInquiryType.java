
package com.nav.schema.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrderInquiryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderInquiryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="unqiueId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="orderQty" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ean13" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderInquiryType", propOrder = {
    "unqiueId",
    "orderQty",
    "accountId",
    "ean13"
})
public class OrderInquiryType {

    protected int unqiueId;
    protected int orderQty;
    protected int accountId;
    protected long ean13;

    /**
     * Gets the value of the unqiueId property.
     * 
     */
    public int getUnqiueId() {
        return unqiueId;
    }

    /**
     * Sets the value of the unqiueId property.
     * 
     */
    public void setUnqiueId(int value) {
        this.unqiueId = value;
    }

    /**
     * Gets the value of the orderQty property.
     * 
     */
    public int getOrderQty() {
        return orderQty;
    }

    /**
     * Sets the value of the orderQty property.
     * 
     */
    public void setOrderQty(int value) {
        this.orderQty = value;
    }

    /**
     * Gets the value of the accountId property.
     * 
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     */
    public void setAccountId(int value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the ean13 property.
     * 
     */
    public long getEan13() {
        return ean13;
    }

    /**
     * Sets the value of the ean13 property.
     * 
     */
    public void setEan13(long value) {
        this.ean13 = value;
    }

}
