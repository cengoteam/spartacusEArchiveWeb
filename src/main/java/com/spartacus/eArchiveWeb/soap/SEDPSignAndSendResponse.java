
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
 *         &lt;element name="SEDP_SignAndSendResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "sedpSignAndSendResult"
})
@XmlRootElement(name = "SEDP_SignAndSendResponse")
public class SEDPSignAndSendResponse {

    @XmlElement(name = "SEDP_SignAndSendResult")
    protected String sedpSignAndSendResult;

    /**
     * Gets the value of the sedpSignAndSendResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEDPSignAndSendResult() {
        return sedpSignAndSendResult;
    }

    /**
     * Sets the value of the sedpSignAndSendResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEDPSignAndSendResult(String value) {
        this.sedpSignAndSendResult = value;
    }

}
