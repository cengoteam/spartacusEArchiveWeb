
package com.spartacus.eArchiveWeb.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="despatchAdvice" type="{http://www.netle.com.tr/EDonusum/OrtakFatura/Ver1.0/}NetleEIrsaliye" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "userToken",
    "despatchAdvice"
})
@XmlRootElement(name = "CheckDespatchAdvice")
public class CheckDespatchAdvice {

    protected String userToken;
    protected NetleEIrsaliye despatchAdvice;

    /**
     * Gets the value of the userToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserToken() {
        return userToken;
    }

    /**
     * Sets the value of the userToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserToken(String value) {
        this.userToken = value;
    }

    /**
     * Gets the value of the despatchAdvice property.
     * 
     * @return
     *     possible object is
     *     {@link NetleEIrsaliye }
     *     
     */
    public NetleEIrsaliye getDespatchAdvice() {
        return despatchAdvice;
    }

    /**
     * Sets the value of the despatchAdvice property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetleEIrsaliye }
     *     
     */
    public void setDespatchAdvice(NetleEIrsaliye value) {
        this.despatchAdvice = value;
    }

}
