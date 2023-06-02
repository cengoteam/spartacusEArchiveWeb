
package com.spartacus.eArchiveWeb.soap;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="GetEInvoiceDocumentByObjectResult" type="{http://www.netle.com.tr/EDonusum/OrtakFatura/Ver1.0/}ArrayOfNDocumentWithObject" minOccurs="0"/&gt;
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
    "getEInvoiceDocumentByObjectResult"
})
@XmlRootElement(name = "GetEInvoiceDocumentByObjectResponse")
public class GetEInvoiceDocumentByObjectResponse {

    @XmlElement(name = "GetEInvoiceDocumentByObjectResult")
    protected ArrayOfNDocumentWithObject getEInvoiceDocumentByObjectResult;

    /**
     * Gets the value of the getEInvoiceDocumentByObjectResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfNDocumentWithObject }
     *     
     */
    public ArrayOfNDocumentWithObject getGetEInvoiceDocumentByObjectResult() {
        return getEInvoiceDocumentByObjectResult;
    }

    /**
     * Sets the value of the getEInvoiceDocumentByObjectResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfNDocumentWithObject }
     *     
     */
    public void setGetEInvoiceDocumentByObjectResult(ArrayOfNDocumentWithObject value) {
        this.getEInvoiceDocumentByObjectResult = value;
    }

}
