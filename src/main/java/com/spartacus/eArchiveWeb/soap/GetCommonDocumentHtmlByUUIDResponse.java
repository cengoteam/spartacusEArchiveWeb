
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
 *         &lt;element name="GetCommonDocumentHtmlByUUIDResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "getCommonDocumentHtmlByUUIDResult"
})
@XmlRootElement(name = "GetCommonDocumentHtmlByUUIDResponse")
public class GetCommonDocumentHtmlByUUIDResponse {

    @XmlElement(name = "GetCommonDocumentHtmlByUUIDResult")
    protected String getCommonDocumentHtmlByUUIDResult;

    /**
     * Gets the value of the getCommonDocumentHtmlByUUIDResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetCommonDocumentHtmlByUUIDResult() {
        return getCommonDocumentHtmlByUUIDResult;
    }

    /**
     * Sets the value of the getCommonDocumentHtmlByUUIDResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetCommonDocumentHtmlByUUIDResult(String value) {
        this.getCommonDocumentHtmlByUUIDResult = value;
    }

}
